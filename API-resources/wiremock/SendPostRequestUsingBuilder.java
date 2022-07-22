package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class SendPostRequestUsingBuilder {

    public static void main(String[] args) throws IOException {

        HashMap<String, String> headersMap = new HashMap<>();
        headersMap.put("Content-Type", "application/json");
        headersMap.put("Accept", " application/json");



        // set end point ans base URI and auth
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

        System.out.println(response.getResult().getImpact());


    }
}
