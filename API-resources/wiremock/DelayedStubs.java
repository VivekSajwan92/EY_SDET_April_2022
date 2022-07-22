package org.example;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

public class DelayedStubs {


    @Rule
    public WireMockRule wireMockRule=new WireMockRule(8082);

    @Test
    public void createStub(){

        stubFor(get(urlEqualTo("/api/users")).willReturn(aResponse().withFixedDelay(5000).proxiedFrom("http://reqres.in")));

        Response response = RestAssured.given().log().all().get("http://localhost:8082/api/users");
        System.out.println(response.statusCode());
        System.out.println(response.getTime());
        response.prettyPrint();
    }
}
