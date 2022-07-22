package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.matching;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class WmJsonBody {

    @Test
    public void createStub() throws JsonProcessingException {
        WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(8080));

        wireMockServer.start();

        // create stub

        String body="{\n" +
                "  \"name\":\"non-fictional book\",\n" +
                "  \"author\":\" ronald\",\n" +
                "  \"publisher\":\" xyz publisher\",\n" +
                "  \"no_of_items_sold\":100\n" +
                "}";
        ObjectMapper mapper=new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(body);


        StubMapping stubMapping = stubFor(post(urlEqualTo("/api/v1/players")).
                withHeader("Content-Type", matching("application/json")).
                withBasicAuth("admin", "admin").
                willReturn(aResponse().withStatus(200).withStatusMessage("Created").withJsonBody(jsonNode)).atPriority(2).persistent(true));

        System.out.println(stubMapping.getPriority());

        // test
        RestAssured.baseURI="http://localhost:8080";
        Response post = RestAssured.given().log().all()
                .headers("Content-Type", "application/json")
                .headers("Authorization","Basic YWRtaW46YWRtaW4=")
                .post("/api/v1/players");
        post.prettyPrint();
    }
}
