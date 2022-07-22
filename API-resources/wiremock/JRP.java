package org.example;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.github.tomakehurst.wiremock.matching.RequestPatternBuilder;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.lessThanOrExactly;
import static com.github.tomakehurst.wiremock.client.WireMock.matching;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;

public class JRP {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);

    @Test
    public void createStub(){
        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/api/users")).
                withBasicAuth("admin","admin").
                withHeader("Content-Type",containing("application/json")).
             //   withQueryParam("page",matching("2")).
                willReturn(aResponse().proxiedFrom("https://reqres.in")));

        // to verify how many calls made for an endpoint

        verify(lessThanOrExactly(5),getRequestedFor(urlEqualTo("/api/users")));



        /* through postman we need to send like below to know the number of calls

        Send a POST request to – http://localhost:8080/__admin/requests/count with JSON body as shown below.

{
    "method": "GET",
    "url": "/api/users"
}
         */

        RestAssured.authentication = RestAssured.basic("admin", "admin");
        RestAssured.baseURI="http://localhost:8089";
        Response response = RestAssured.given().log().all()
                .header(new Header("Content-Type","application/json"))
                .headers("Authorization","Basic YWRtaW46YWRtaW4=")
              //  .queryParams("page",2)
                .get("/api/users");
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getTime());
        response.prettyPrint();
    }


}
