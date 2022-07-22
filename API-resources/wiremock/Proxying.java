package org.example;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.matching;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;

public class Proxying {


    @Rule
    public WireMockRule wireMockRule=new WireMockRule(8082);

    @Test
    public void createProxyStub(){
    // proxy
        StubMapping stubMapping = stubFor(get(urlPathEqualTo("/api/users")).
                withQueryParam("page",matching("[0-9]")).
                willReturn(aResponse().withStatus(200).
                        proxiedFrom("https://reqres.in")));

  /*  stubFor(post(urlPathEqualTo("/api/users")).
            withHeader("Content-Type",containing("application/json")).
            willReturn(aResponse().withStatus(201).
                    proxiedFrom("https://reqres.in")));*/



     //   Response response = RestAssured.given().log().all().headers("Content-Type","application/json").body("").post("http://localhost:8082/api/users");

        Response response = RestAssured.given().log().all().queryParams("page",2).get("http://localhost:8082/api/users");

        System.out.println(response.statusCode());
        response.prettyPrint();

    }
}
