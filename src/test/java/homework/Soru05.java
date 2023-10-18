package homework;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerokuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Soru05 extends HerokuAppBaseUrl {
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
    public void soru05() {
        //Set the URL
        spec.pathParams("first", "booking", "second", 623);

        //Set the expected data

        //Send the request and get the response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        HerokuAppTestData herokuAppTestData = new HerokuAppTestData();
        Map<String, String> bookingMap = herokuAppTestData.getBookingDates("2018-01-01", "2019-01-01");

        Map<String, Object> expectedData = herokuAppTestData.getPayLoad("Jane", "Doe", 101, true, bookingMap, "Extra pillows please");

        Map<String, Object> actualData = response.as(HashMap.class);

        JsonPath jsonPath = response.jsonPath();


        assertEquals(200, response.statusCode());
        assertTrue(response.contentType().contains("application/json"));
        assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));

        assertEquals(bookingMap.get("checkin"), ((Map)actualData.get("bookingdates")).get("checkin"));
        assertEquals(bookingMap.get("checkout"), ((Map)actualData.get("bookingdates")).get("checkout"));


        // BU TEST NASIL GEÇTİ (bookingDates yazınca geçiyor dates yazınca kalıyor)
        assertEquals(expectedData.get("checkin"), jsonPath.getString("bookingDates.checkin"));
        assertEquals(expectedData.get("checkout"), jsonPath.getString("bookingDates.checkout"));

    }
}
