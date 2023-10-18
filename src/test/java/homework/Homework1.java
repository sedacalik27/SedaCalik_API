package homework;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Homework1 extends HerokuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/1
    When
        Kullanıcı URL'e bir GET request gönderir
    Then
        HTTP Status Code 200 olmalı
    And
        Content Type "application/json" olmalı
    And
        Status Line "HTTP/1.1 200 OK" olmalı
    And
        Body değerleri doğrulanmalı
*/

    @Test
    public void get01() {

        spec.pathParams("first", "booking", "second", 1);
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .statusLine("HTTP/1.1 200 OK")
                .body("firstname", equalTo("Susan"),
                        "lastname", equalTo("Jackson"),
                        "totalprice", equalTo(346),
                        "depositpaid", equalTo(false),
                        "bookingdates.checkin", equalTo("2023-03-08"),
                        "bookingdates.checkout", equalTo("2023-09-28"));
    }
}
