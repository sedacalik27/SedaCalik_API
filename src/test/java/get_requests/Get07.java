package get_requests;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertTrue;

public class Get07 extends HerokuAppBaseUrl{
      /*
        Given
            https://restful-booker.herokuapp.com/booking/23
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json"
        And
            Response body should be like;
      {
            "firstname": "Bradley",
            "lastname": "Pearson",
            "totalprice": 132,
            "depositpaid": false,
            "bookingdates": {
                "checkin": "2022-10-27",
                "checkout": "2022-11-07"
            },
            "additionalneeds": "None"
        }
     */


    @Test

        public void get07() {
            // Set the URL
            spec.pathParams("first", "booking", "second", 23);
            // Set the expected data
            // Send the request and get the response
            Response response = given(spec).when().get("{first}/{second}");
            response.prettyPrint();
            // Do assertion
            // 1. YOL
            response
                    .then()
                    .statusCode(200)
                    .contentType(ContentType.JSON)
                    .body("firstname", equalTo("John"))
                    .body("lastname", equalTo("Smith"))
                    .body("totalprice", equalTo(111))
                    .body("depositpaid", equalTo(true))
                    .body("bookingdates.checkin", equalTo("2018-01-01"))
                    .body("bookingdates.checkout", equalTo("2019-01-01"))
                    .body("additionalneeds", equalTo("Breakfast"));
            // JsonPath Alıştırmaları2, yol json la yapılan sorgulama
        // NOT: JsonPath ile Json datadaki değerleri bir değişken içerisine koyabiliriz.
            JsonPath json = response.jsonPath();//responsu alıp json pathe çeviriyoruz burda daha dinamik oluyor code
        //json la bodynin içini test ediyoruz
            String firstName = json.getString("firstname"); // John
            String checkIn = json.getString("bookingdates.checkin"); // 2018-01-01
            int totalprice = json.getInt("totalprice"); // 111
            System.out.println(totalprice);
            // 2. YOL
            assertEquals(200, response.statusCode());
            assertTrue(response.contentType().contains("application/json"));
            assertEquals("John", json.getString("firstname"));
            assertEquals("Smith", json.getString("lastname"));
            assertEquals(111, json.getInt("totalprice"));
            assertTrue(json.getBoolean("depositpaid"));
            assertEquals("2018-01-01", json.getString("bookingdates.checkin"));
            assertEquals("2019-01-01", json.get("bookingdates.checkout"));
            assertEquals("Breakfast", json.get("additionalneeds"));


        }
}
