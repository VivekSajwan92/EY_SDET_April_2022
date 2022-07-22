package org.example;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import io.restassured.RestAssured;
import io.restassured.internal.proxy.RestAssuredProxySelector;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class CreateAGetMock {

    // wire mock server running
    // contract for a specific API
    // test the stub thats been created


    @Test
    public void createMock(){

        /**
         *
         * given this is my URI
         * and headers, HTTP verb
         * then
         * respond with a specific status code
         * and response body
         */

        /** configure wiremock server */
        WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(8080));

        /** start server */
        wireMockServer.start();

      //  File file = new File("./src/test/java/resources/book.json");

        StubMapping stubMapping = stubFor(get(urlPathEqualTo("/api/v1/books")).
                willReturn(aResponse().withStatus(200).withBodyFile("book.json")).
                withHeader("Content-Type",containing("application/json")));

        System.out.println(stubMapping.getId());

        Response response = RestAssured.given().log().all()
                .headers("Content-Type","application/json")
                .get("http://localhost:8080/api/v1/books");

       response.prettyPrint();

       wireMockServer.stop();
    }



}
