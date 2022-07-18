package org.example;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.MathContext;
import java.util.HashMap;
import java.util.List;

public class EndToEndTest {

    /**
     * create incident
     * update the same sysId
     * get the incident verify the update
     * get all incidents and check if the created incident present or not
     * delete the incident
     *
     */

    String sysId;
    String number;

    @Test
    public void createIncident(){
        HashMap<String, String> headersMap = new HashMap<>();
        headersMap.put("Content-Type", "application/json");
        headersMap.put("Accept", " application/json");

        // set end point and base URI and auth
        RestAssured.baseURI = "https://dev70245.service-now.com";
        RestAssured.basePath = "/api/now/table/";
        RestAssured.authentication = RestAssured.preemptive().basic("admin", "FYZ!4co-f0cP");

        // construct body
        ServiceNowRequest serviceNowRequest = ServiceNowRequest.builder()
                .impact("3")
                .approval("NO")
                .shortDescription("this is built using builder pattern")
                .build();


        CreateIncidentResponse response = RestAssured.given().log().all()
                .headers(headersMap)
                .body(serviceNowRequest)
                .when()
                .post("incident")
                .then().log().all()
                .statusCode(201)
                .extract().response().as(CreateIncidentResponse.class);

        sysId = response.getResult().getSysId();
        number = response.getResult().getNumber();
    }

    @Test(dependsOnMethods = {"createIncident"})
    public void getAllIncidents(){
        HashMap<String, String> headersMap = new HashMap<>();
        headersMap.put("Content-Type", "application/json");
        headersMap.put("Accept", " application/json");

        // set end point and base URI and auth
        RestAssured.baseURI = "https://dev70245.service-now.com";
        RestAssured.basePath = "/api/now/table/";
        RestAssured.authentication = RestAssured.basic("admin", "FYZ!4co-f0cP");

        Response response = RestAssured.given().log().all()
                .headers(headersMap)
                .queryParams("sysparm_fields", "number,sys_id,category,short_description")
                .when()
                .get("incident")
                .then()
                .statusCode(200)
                .extract()
                .response();


        JsonPath jsonPath = response.jsonPath();
        List<String> list = jsonPath.getList("result.number");

        response.then().body("result.number",Matchers.hasItem(number));

        Assert.assertTrue(list.contains(number));
        response.prettyPrint();
    }

    @Test
    public void updateIncident(){
        HashMap<String, String> headersMap = new HashMap<>();
        headersMap.put("Content-Type", "application/json");
        headersMap.put("Accept", " application/json");

        RestAssured.baseURI = "https://dev70245.service-now.com";
        RestAssured.basePath = "/api/now/table/";
        RestAssured.authentication = RestAssured.basic("admin", "FYZ!4co-f0cP");

        // construct body
        ServiceNowRequest serviceNowRequest = ServiceNowRequest.builder()
                .impact("3")
                .approval("NO")
                .shortDescription("this is built using builder pattern- updated description")
                .build();

        Response response = RestAssured.given().log().all()
                .headers(headersMap)
                .body(serviceNowRequest)
                .when()
                .put("incident/"+sysId)
                .then().log().all()
                .statusCode(200)
                .extract().response();

    }

    @Test
    public void getIncident(){
        HashMap<String, String> headersMap = new HashMap<>();
        headersMap.put("Content-Type", "application/json");
        headersMap.put("Accept", " application/json");

        RestAssured.baseURI = "https://dev70245.service-now.com";
        RestAssured.basePath = "/api/now/table/";
        RestAssured.authentication = RestAssured.basic("admin", "FYZ!4co-f0cP");

        Response response = RestAssured.given().log().all()
                .headers(headersMap)
                .queryParams("sysparm_fields", "number,sys_id,category,short_description")
                .when()
                .get("incident/"+sysId)
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath jsonPath = response.jsonPath();

        response.then().body("result.short_description", Matchers.is("this is built using builder pattern- updated description"));

        Assert.assertEquals(jsonPath.get("result.number"),number);

    }

    @Test(dependsOnMethods = {"createIncident","updateIncident","getIncident"})
    public void deleteIncident(){
        HashMap<String, String> headersMap = new HashMap<>();
        headersMap.put("Content-Type", "application/json");
        headersMap.put("Accept", " application/json");

        RestAssured.baseURI = "https://dev70245.service-now.com";
        RestAssured.basePath = "/api/now/table/";
        RestAssured.authentication = RestAssured.basic("admin", "FYZ!4co-f0cP");

        Response response = RestAssured.given().log().all()
                .headers(headersMap)
                .queryParams("sysparm_fields", "number,sys_id,category,short_description")
                .when()
                .delete("incident/"+sysId)
                .then()
                .statusCode(204)
                .extract()
                .response();

    }
}
