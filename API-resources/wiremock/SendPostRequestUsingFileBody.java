package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
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

public class SendPostRequestUsingFileBody {

    public static void main(String[] args) throws IOException {

        HashMap<String, String> headersMap = new HashMap<>();
        headersMap.put("Content-Type", "application/json");
        headersMap.put("Accept", " application/json");



        // set end point ans base URI and auth
        RestAssured.baseURI = "https://dev70245.service-now.com";
        RestAssured.basePath = "/api/now/table/";
        RestAssured.authentication = RestAssured.basic("admin", "FYZ!4co-f0cP");

        RestAssuredConfig restAssuredConfig = RestAssured.config.sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());

        Path path = Paths.get("./src/test/java/resources/request.json");
        byte[] bytes = Files.readAllBytes(path);

      //  File file1 = new File("./src/test/java/resources/request.json");


        ObjectMapper mapper = new ObjectMapper();
        ServiceNowRequest serviceNowRequest = mapper.readValue(bytes, ServiceNowRequest.class);

        serviceNowRequest.setCategory("other");
        serviceNowRequest.setPriority("3");
        serviceNowRequest.setShortDescription("cdshh");



        Response response = RestAssured.given().log().all()
                .headers(headersMap)
                .body(serviceNowRequest)
                .when()
                .post("incident")
                .then().log().all()
                .statusCode(201)
                .extract().response();

        System.out.println(response.prettyPrint());

        // validate the short description
        response.then().body("result.short_description", Matchers.is("need dev box vault access-from map"));

        // validate the incident number
        response.then().body("result.number", Matchers.containsString("INC00"));

        // validate the schema

        File file = new File("./src/test/java/resources/schema.json");
        response.then().body(JsonSchemaValidator.matchesJsonSchema(file));


    }
}
