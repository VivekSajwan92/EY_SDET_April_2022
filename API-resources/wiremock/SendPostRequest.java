package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.impl.FailingDeserializer;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.HashMap;

public class SendPostRequest {

    public static void main(String[] args) throws JsonProcessingException {

        // hashmap to store the headers

        /**
         * Content-Type: application/json
         * Accept : application/json
         *
         */

        String body = "{\"short_description\":\"need dev box vault access\",\"category\":\"software\",\"priority\":\"2\"}";

        ObjectMapper mapper = new ObjectMapper();
        // type reference - what type of object to construct
        TypeReference<HashMap<String, String>> type = new TypeReference<>() {
        };

        HashMap<String, String> map = mapper.readValue(body, type);

        map.put("short_description", "need dev box vault access-from map");
        map.put("category", "hardware");

        System.out.println(map);

        HashMap<String, String> headersMap = new HashMap<>();
        headersMap.put("Content-Type", "application/json");
        headersMap.put("Accept", " application/json");

        // set end point ans base URI and auth
        RestAssured.baseURI = "https://dev70245.service-now.com";
        RestAssured.basePath = "/api/now/table/";
        RestAssured.authentication = RestAssured.basic("admin", "FYZ!4co-f0cP");

        RestAssuredConfig restAssuredConfig = RestAssured.config.sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());

        RestAssured.config.sslConfig(SSLConfig.sslConfig().with().
                trustStore("", "").
                trustStoreType("").
                keyStore("", "").
                keystoreType("")
        );


        Response response = RestAssured.given().log().all()
                .headers(headersMap)
                .body(map)
                .when()
                .post("incident")
                .then().log().all()
                .statusCode(201)
                .extract().response();

        System.out.println(response.prettyPrint());

        // validate the short description
        response.then().body("result.short_description", is("need dev box vault access-from map"));

        // validate the incident number
        response.then().body("result.number", containsString("INC00"));

        // validate the schema

        File file = new File("./src/test/java/resources/schema.json");
        response.then().body(JsonSchemaValidator.matchesJsonSchema(file));


    }
}
