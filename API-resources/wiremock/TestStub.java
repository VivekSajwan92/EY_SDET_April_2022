package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.awt.geom.RectangularShape;

public class TestStub {

    @Test
    public void getStuDetails(){

        RestAssured.baseURI="http://localhost:8080";
        Response response = RestAssured.given().log().all()
                .get("/api/users");

        response.prettyPrint();
    }
}
