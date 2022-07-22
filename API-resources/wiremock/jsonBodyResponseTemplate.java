package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.matching;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class jsonBodyResponseTemplate {

    @Rule
    public WireMockRule wireMockRule=new WireMockRule(wireMockConfig().port(8080).extensions(new ResponseTemplateTransformer(false)));

    @Test
    public void createStub() throws JsonProcessingException {

        String body="{\n" +
                " \"id\":\"{{request.headers.correlation-id}}\",\n" +
                " \"username\": \"user\",\n" +
                " \"profession\":\"{{now}}\"\n" +
                " }";

        String ticket="{\n" +
                "\t\"id\":\"{{randomInt}}\",\n" +
                "\t\"desc\":\"this is issue descripion\",\n" +
                "\t\"sysId\":\"{{randomValue length=33 type='ALPHANUMERIC'}}\",\n" +
                "\t\"priority\":\"{{{pickRandom '1' '2' '3' '4' '5' '6' '7'}}}\",\n" +
                "\t\"time_stamp\":\"{{now}}\",\n" +
                "\t\"created_timestamp\":\"{{now offset='3 days'}}\"\n" +
                "\n" +
                "}\n" +
                "\n";

        ObjectMapper mapper=new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(ticket);

//{{request.header.Content-Type}}
        //{{randomValue length=33 type='ALPHANUMERIC'}}
        StubMapping ok = stubFor(WireMock.post((urlMatching("/api/incident"))).
                withHeader("Content-Type", containing("application/json")).
                withHeader("correlation-id", matching(".*")).
                willReturn(aResponse().withJsonBody(jsonNode).withHeader("correlation-id", "{{randomValue length=33 type='ALPHANUMERIC'}}")
                        .withStatus(200).withStatusMessage("OK").withTransformers("response-template")).persistent());


        RestAssured.baseURI="http://localhost:8080";
        Response this_is_the_body = RestAssured.given().log().all().
                headers("Content-Type", "application/json").
                headers("correlation-id", "123").body("").
               post("/api/incident").then().log().all().extract().response();

        //   System.out.println(this_is_the_body.getTime());
        this_is_the_body.prettyPrint();
    }
}
