package org.example;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.matching;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;

public class RTbasics {

    /**
     * instantiate the wiremock server class
     * junit rule
     */

    @Rule
    public WireMockRule wireMockRule=new WireMockRule(WireMockConfiguration.wireMockConfig().port(8082).extensions(new ResponseTemplateTransformer(false)));


    @Test
    public void createStub(){

      //  WireMockConfiguration wireMockConfiguration = WireMockConfiguration.wireMockConfig().dynamicPort();

        StubMapping ok = stubFor(WireMock.post(urlPathEqualTo("/api/now/incident")).withHeader("Content-Type", containing("text/plain")).
                withQueryParam("id",matching(".*")).
                willReturn(aResponse().withStatus(201).withStatusMessage("OK").withBody("{{request.query.id}}").withTransformers("response-template")));

        RestAssured.baseURI="http://localhost:8082";
        Response all = RestAssured.given().log().all().queryParams("id","1988").headers("Content-Type", "text/plain").body("hey there").post("/api/now/incident").then().log().all().extract().response();

        all.prettyPrint();

    }

}
