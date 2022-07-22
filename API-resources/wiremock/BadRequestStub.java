package org.example;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.badRequest;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.serverError;
import static com.github.tomakehurst.wiremock.client.WireMock.serviceUnavailable;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

public class BadRequestStub {

    @Rule
    public WireMockRule wireMockRule=new WireMockRule(8082);

    @Test
    public void createStub(){

        StubMapping stubMapping = stubFor(post(urlEqualTo("/api/v1/books")).
                withHeader("Content-Type", containing("application/json")).
                willReturn(badRequest().withBody("one ore more fields in the request body sent are not supported")));

        StubMapping stubMapping2 = stubFor(post(urlEqualTo("/api/v1/books")).
                withHeader("Content-Type", containing("application/json")).
                willReturn(serverError().withBody("INTERNAL SERVER")));

        StubMapping stubMapping3 = stubFor(post(urlEqualTo("/api/v1/books")).
                withHeader("Content-Type", containing("application/json")).
                willReturn(serviceUnavailable().withBody("503 service unavailable..")));

        Response post = RestAssured.given().log().all().headers("Content-Type", "application/json").post("http://localhost:8082/api/v1/books").then().log().all().extract().response();
        post.prettyPrint();



    }
}
