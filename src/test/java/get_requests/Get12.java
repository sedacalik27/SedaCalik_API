package get_requests;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.herokuapp.BookingDatesPojo;
import pojos.herokuapp.BookingPojo;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Get12 extends HerokuAppBaseUrl {
    /*
     Given
         https://restful-booker.herokuapp.com/booking/535
     When
         I send GET Request to the URL
     Then
         Status code is 200
     And
         Response body is like:
                {

                    firstname" : "Jane",
                    lastname" : "Doe",
                    totalprice" : 111,
                    depositpaid" : true,
                    bookingdates" : {
                       "checkin" : "2018-01-01",
                       "checkout" : "2019-01-01"
                },
                   "additionalneeds" : "Extra pillows please"
                 }
  */


    @Test
    public void get12() {
        //Set the url
        spec.pathParams("first","booking","second",2737);


        //Set the expected data
        //ilk önce içteki pojoyu çagırıyoz
        BookingDatesPojo bookingDates=new BookingDatesPojo("2018-01-01","2019-01-01");

        BookingPojo expectedData= new BookingPojo("Jane","Doe",111,true,bookingDates,"Extra pillows please");

        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response=given(spec).when().get("{first}/{second}");//seriazilation
        response.prettyPrint();

        //Do assertion
        // Do assertion
        BookingPojo actualData = response.as(BookingPojo.class);//De-serialization
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstname(), actualData.getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getLastname());
        assertEquals(expectedData.getTotalprice(), actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(), actualData.getDepositpaid());
        assertEquals(bookingDates.getCheckin(), actualData.getBookingdates().getCheckin());
        assertEquals(bookingDates.getCheckout(), actualData.getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(), actualData.getAdditionalneeds());


    }
}
