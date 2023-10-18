package homework;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

public class Odev2 {
    /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */

    @Test
    public void odev02() {
        RestAssured.baseURI="https://reqres.in/api";
        RestAssured.basePath="users/23";

        Response response=given().when().get();
        response
                .then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .header("Server","cloudflare")
                .body(containsString(""));
        //Assert.assertFalse(responseBody.isEmpty());//başkası böyle yapmış




    }
    /*
     // set the url
        spec.pathParams("first","users","second",23);

        // set the expected data

        // send the request get the response
        Response response = given(spec).when().get("{first}/{second}");

      response.prettyPrint();

        // do assertion
        // Hamcrest Matchers
        response
                .then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .header("Server","cloudflare").body(is(anEmptyMap()));
     */
}
