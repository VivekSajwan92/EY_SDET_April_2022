package org.example;

import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
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
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathMatching;

public class RTP {


    @Rule
    public WireMockRule wm = new WireMockRule(new WireMockConfiguration().port(8080).extensions(new ResponseTemplateTransformer(false)));

    @Test
    public void createStub() {
        stubFor(post(urlPathMatching("/v1/books"))
                .withHeader("Content-Type", containing("application/json"))
                .withQueryParam("id",matching("[0-9]"))
                .withBasicAuth("admin", "admin").willReturn(aResponse()
               // .withBody("{{now}}")
                       // .withBody("{{jsonPath request.body '$.impact'}}")
                        .withBodyFile("book/{{request.pathSegments.[0]}}")));
                       // .withTransformers("response-template"));


        Response response = RestAssured.given().log().all()
                .headers("Authorization", "Basic YWRtaW46YWRtaW4=")
                .headers("Content-Type","application/json")
                .queryParams("id",5)
                .body("{\n" +
                        "  \"short_description\": \"need dev box vault access\",\n" +
                        "  \"category\": \"software\",\n" +
                        "  \"priority\": \"2\",\n" +
                        "  \"impact\": 1\n" +
                        "}")
                .post("http://localhost:8080/v1/books");

        response.prettyPrint();
    }
}
