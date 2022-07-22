package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.codehaus.groovy.runtime.GStringUtil;
import org.junit.Rule;
import org.junit.Test;

import java.io.File;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.matching;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class ServiceNowMock {


    @Rule
    public WireMockRule wm=new WireMockRule(wireMockConfig().port(8082).extensions(new ResponseTemplateTransformer(false)));

    @SneakyThrows
    @Test
    public void incidentMimic(){

        String body="{\n" +
                "  \"short_description\": \"need dev box vault access\",\n" +
                "  \"category\": \"software\",\n" +
                "  \"priority\": \"{{{pickRandom '1' '2' '3'}}}\",\n" +
                "  \"impact\": {{{pickRandom '1' '2' '3' '4' '5'}}},\n" +
                "  \"sysId\": \"{{randomValue length=33 type='ALPHANUMERIC'}}\",\n" +
                "  \"created_timeStamp\": \"{{now}}\",\n" +
                "  \"owner\": \"name\"\n" +
                "}";

        File file= new File("./src/test/resources/request.json");

        ObjectMapper mapper=new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(file);

        StubMapping stubMapping = stubFor(post(urlMatching("/jira/issue")).
                withBasicAuth("admin", "admin").
                withHeader("Content-Type", containing("application/json")).
                willReturn(aResponse().withStatus(201).withStatusMessage("Created").
                        withJsonBody(jsonNode).
                        withHeader("Correlation-id","{{{{randomValue type='UUID'}}}").
                        withTransformers("response-template")).persistent());

        RestAssured.baseURI="http://localhost:8082";
        Response response = RestAssured.given().log().all().
                headers("Content-Type","application/json").body("").post("/jira/issue").then().log().all().extract().response();

    }
}
