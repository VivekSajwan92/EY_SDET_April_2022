package org.example;

import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class Junk {

   @Rule
    public WireMockRule wireMockRule=new WireMockRule(wireMockConfig().port(8080).extensions(new ResponseTemplateTransformer(false)));

   @Test
   public void createStub(){
//{{request.header.Content-Type}}
       //{{randomValue length=33 type='ALPHANUMERIC'}}
       StubMapping ok = stubFor(post((urlMatching("/register/users"))).
               withHeader("Content-Type", containing("application/json")).
               willReturn(aResponse().withBody("{{stripes 2 'row-even' 'row-odd'}}").withHeader("correlation-id", "{{randomValue length=33 type='ALPHANUMERIC'}}")
                       .withStatus(200).withStatusMessage("OK").withTransformers("response-template")));


       RestAssured.baseURI="http://localhost:8080";
       Response this_is_the_body = RestAssured.given().log().all().
               headers("Content-Type", "application/json").
               headers("correlation-id", "123").
               body("what the hell is this").post("/register/users").then().log().all().extract().response();

    //   System.out.println(this_is_the_body.getTime());
       this_is_the_body.prettyPrint();
   }
}
