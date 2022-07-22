package org.example;


import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.github.tomakehurst.wiremock.recording.SnapshotRecordResult;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.lang.module.ResolutionException;
import java.util.List;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class Recording {


    @Test
    public void createRecord(){

        /** configure wiremock server */
        WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(8080));

        /** start server */
        wireMockServer.start();
        /** start the recording */
        wireMockServer.startRecording("https://reqres.in");

        // call the endpoint from local host
        RestAssured.baseURI="http://localhost:8080";
        RestAssured.given().log().all().get("/api/users");
        RestAssured.given().log().all().get("/api/users/1");

        SnapshotRecordResult snapshotRecordResult = wireMockServer.stopRecording();
        List<StubMapping> stubMappings = snapshotRecordResult.getStubMappings();


    }


}
