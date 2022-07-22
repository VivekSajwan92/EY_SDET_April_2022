package org.example;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import io.restassured.RestAssured;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.lessThan;
import static com.github.tomakehurst.wiremock.client.WireMock.matching;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class ProxyResponseTemplate {

    @Rule
    public WireMockRule wireMock=new WireMockRule(wireMockConfig().port(8082).extensions(new ResponseTemplateTransformer(false)));

    @Test
    public void proxyStub(){
        stubFor(get(urlEqualTo("/api/users")).willReturn(aResponse().
                proxiedFrom("{{request.headers.url}}").withStatus(200).withTransformers("response-template")));

        verify(lessThan(0),getRequestedFor(urlEqualTo("/api/users")));


        RestAssured.baseURI="http://localhost:8082";
        RestAssured.given().log().all().headers("url","https://reqres.in").get("/api/users").then().log().all();
    }
}
