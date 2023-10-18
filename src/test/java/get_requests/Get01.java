package get_requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {
    /*
        Given
            https://petstore.swagger.io/v2/pet/5
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status Code 200 olmalı
        And
            Content Type "application/json" olmalı
        And
            Status Line "HTTP/1.1 200 OK" olmalı
    */

    @Test
    public void get01a() {
        //Birinci Yöntem
        String url="https://petstore.swagger.io/v2/pet/5";

        //İkinci yöntem
        // RestAssured--> bizim burda kullandıgımız kütüphane

        RestAssured.baseURI="https://petstore.swagger.io/v2";
        RestAssured.basePath="/pet/5";

        Response response= given().when().get();
        response.prettyPrint();
        //response get dediğimizde gelen datayı responsun içine koyuyoruz
        //responce put dediğimizde biz body gönderiyoruz

        //assertlerde then methodu kullanılır

        response.then().assertThat().statusCode(200).
                and().contentType("application/json").
                and().statusLine("HTTP/1.1 200 OK");

    }


    @Test
    public void get01b() {

        RestAssured.baseURI="https://petstore.swagger.io/v2";
        RestAssured.basePath="/pet/5";

        Response response= given().when().get();
        given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .contentType("application/json")
                .statusLine("HTTP/1.1 200 OK");

    }
}