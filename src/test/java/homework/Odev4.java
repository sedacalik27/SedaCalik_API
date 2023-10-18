package homework;

import baseUrl.RegresInApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.reset;
import static org.hamcrest.CoreMatchers.equalTo;

public class Odev4 extends RegresInApiBaseUrl {
    /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json; charset=utf-8”
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
}
      */

    @Test
    public void odev04() {
        //Set the url
        spec.pathParams("first","unknown","second",3);

        //Set the expected data
        //Send the request and get the response
       Response response= given(spec).when().get("{first}/{second}");
       response.prettyPrint();

       //Do aseertion
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.name",equalTo("true red"))
                .body("data.year",equalTo(2002))
                .body("data.color",equalTo("#BF1932"))
                .body("data.pantone_value",equalTo("19-1664"))
                .body("support.url",equalTo("https://reqres.in/#support-heading"))
                .body("support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));


    }
}
