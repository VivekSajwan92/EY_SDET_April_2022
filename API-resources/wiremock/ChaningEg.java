package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

public class ChaningEg {

    String sysId;
    String number;

    @Test()
    public void createIncident(ITestContext iTestContext) {

        String body = "{\"short_description\":\"need dev box vault access\",\"category\":\"software\",\"priority\":\"2\"}";

        HashMap<String, String> headersMap = new HashMap<>();
        headersMap.put("Content-Type", "application/json");
        headersMap.put("Accept", " application/json");

        // set end point ans base URI and auth
        RestAssured.baseURI = "https://dev70245.service-now.com";
        RestAssured.basePath = "/api/now/table/";
        RestAssured.authentication = RestAssured.basic("admin", "FYZ!4co-f0cP");

        Response response = RestAssured.given().log().all()
                .headers(headersMap)
                .body(body)
                .when()
                .post("incident")
                .then().log().all()
                .statusCode(201)
                .extract().response();

        // get the incident sys id
        JsonPath jsonPath = response.jsonPath();
        iTestContext.setAttribute("number",jsonPath.get("result.number"));
        iTestContext.setAttribute("sysId",jsonPath.get("result.sys_id"));

      /*  sysId = jsonPath.get("result.sys_id");
        number = jsonPath.get("result.number");*/

        // validate the short description
        response.then().body("result.short_description", Matchers.is("need dev box vault access"));

        // validate the incident number
        response.then().body("result.number", Matchers.containsString("INC00"));

    }

    @Test(dependsOnMethods = {"createIncident"})
    public void getIncident(ITestContext iTestContext){

        HashMap<String, String> headersMap = new HashMap<>();
        headersMap.put("Content-Type", "application/json");
        headersMap.put("Accept", " application/json");

        // set end point ans base URI and auth
        RestAssured.baseURI = "https://dev70245.service-now.com";
        RestAssured.basePath = "/api/now/table/";
        RestAssured.authentication = RestAssured.basic("admin", "FYZ!4co-f0cP");

        Response response = RestAssured.given().log().all()
                .headers(headersMap)
                .when()
                .get("incident/"+iTestContext.getAttribute("sysId"))
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response();
    }

    @Test(dependsOnMethods = {"createIncident"})
    public void updateIncident(ITestContext iTestContext){

        HashMap<String, String> headersMap = new HashMap<>();
        headersMap.put("Content-Type", "application/json");
        headersMap.put("Accept", " application/json");

        // set end point ans base URI and auth
        RestAssured.baseURI = "https://dev70245.service-now.com";
        RestAssured.basePath = "/api/now/table/";
        RestAssured.authentication = RestAssured.basic("admin", "FYZ!4co-f0cP");

        String updateBody = "{\"short_description\":\"need dev box vault access updated desc\",\"category\":\"software\",\"priority\":\"2\"}";

        Response response = RestAssured.given().log().all()
                .headers(headersMap)
                .body(updateBody)
                .when()
                .put("incident/"+iTestContext.getAttribute("sysId"))
                .then().log().all()
                .statusCode(200)
                .extract().response();

        response.then().body("result.short_description",Matchers.is("need dev box vault access updated desc"));
        response.then().body("result.number",Matchers.is(iTestContext.getAttribute("number")));

    }

    @Test(dependsOnMethods = {"getIncident","updateIncident","createIncident"})
    public void deleteIncident(ITestContext iTestContext){

        HashMap<String, String> headersMap = new HashMap<>();
        headersMap.put("Content-Type", "application/json");
        headersMap.put("Accept", " application/json");

        // set end point ans base URI and auth
        RestAssured.baseURI = "https://dev70245.service-now.com";
        RestAssured.basePath = "/api/now/table/";
        RestAssured.authentication = RestAssured.basic("admin", "FYZ!4co-f0cP");

        Response response = RestAssured.given().log().all()
                .headers(headersMap)
                .when()
                .delete("incident/"+iTestContext.getAttribute("sysId"))
                .then().log().all()
                .statusCode(204)
                .extract().response();


    }
}
