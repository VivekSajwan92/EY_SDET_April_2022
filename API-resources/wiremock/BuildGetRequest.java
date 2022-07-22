package org.example;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.testng.Assert;

import java.sql.PreparedStatement;
import java.util.List;

public class BuildGetRequest {

    public static void main(String[] args) {

      //  getWeatherInfo();

        // URl and endpoint

        RestAssured.baseURI="https://reqres.in/";
        RestAssured.basePath="/api/users/";

      //  SSLConfig sslConfig = RestAssured.config().getSSLConfig().allowAllHostnames();
        // HTTP method/ verb
        Response response = RestAssured.given().log().all().
                headers("Content-Type", "application/json").
                header(new Header("Accept", "application/json")).
                queryParams("page","2").
                when().
                get()
                .then().log().all()
                .statusCode(200).
                extract().response();

        JsonPath jsonPath = response.jsonPath();
        Integer id = jsonPath.get("data[0].id");
        System.out.println(id);


        //  String email = jsonPath.get("data.email");
     //   Assert.assertEquals(email,"janet.weaver@reqres.in");
     //   System.out.println(email);
     //   System.out.println(response.prettyPrint());
    }

    //https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}

    public static void getWeatherInfo(){
        RestAssured.baseURI="https://gorest.co.in";
        RestAssured.basePath="/public/v2/users";

        Response response = RestAssured.given().header(new Header("Authorization", "Bearer 31270062a4adc492f10c78cb6dd985349194cb06b68f34f4c217c52e2760a3c6"))
                .get();

        System.out.println(response.prettyPrint());
    }
}
