/*
package org.example;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.module.ResolutionException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class Practise {


   */
/* @Rule
    public WireMockRule wireMockRule = new WireMockRule(8080);*//*


    public static WireMockServer server;

   @Test
    public void setUp() throws JsonProcessingException {
      //  WireMockRule wireMockRule = new WireMockRule(8089);

       server=new WireMockServer(wireMockConfig().port(8080));
       server.start();
       createStub();
       test();
       tearDown();

    }



    public void createStub() throws JsonProcessingException {

        server=new WireMockServer(wireMockConfig().port(8080));
        server.start();

        String body="{\n" +
                " \"id\":1,\n" +
                " \"username\": \"user\",\n" +
                " \"profession\":\"profession\"\n" +
                " }";

        ObjectMapper mapper=new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(body);


        StubMapping stubMapping = stubFor(get(urlPathEqualTo("/test/api")).
                willReturn(aResponse().withJsonBody(jsonNode).withStatus(200)));

    }
    public void test() throws JsonProcessingException {
       // createStub();

        Response response = RestAssured.given().log().all().get("http://localhost:8080/test/api");
        response.prettyPrint();
    }


    public void tearDown(){
        server.stop();
    }
}
*/
