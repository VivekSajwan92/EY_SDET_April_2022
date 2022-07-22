package org.example;

import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configure;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.matching;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class RTProxy {

    @Rule
    public WireMockRule wireMockRule=new WireMockRule(wireMockConfig().port(8082).extensions(new ResponseTemplateTransformer(false)));

    @Test
    public void createProxyStub(){
        // proxy
        StubMapping stubMapping = stubFor(get(urlPathEqualTo("/api/users")).
                withQueryParam("page",matching("[0-9]")).
                willReturn(aResponse().withStatus(200).
                        proxiedFrom("{{request.headers.url}}").withTransformers("response-template")));




        //   Response response = RestAssured.given().log().all().headers("Content-Type","application/json").body("").post("http://localhost:8082/api/users");

        Response response = RestAssured.given().log().all().
                headers("url","https://reqres.in").
                queryParams("page",2).get("http://localhost:8082/api/users");

        System.out.println(response.statusCode());
        response.prettyPrint();

    }
}
