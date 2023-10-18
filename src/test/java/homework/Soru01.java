package homework;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class Soru01 extends HerokuAppBaseUrl{
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
    public void soru01(){
        //Set the url
        spec.pathParams("first","booking","second",1302);
        //set the expected data

        //send the request and get the responce
       Response response= given(spec).when().get("{first}/{second}");
       response.prettyPrint();

        assertEquals(200,response.statusCode());
        assertTrue(response.contentType().contains("application/json"));
        assertEquals("HTTP/1.1 200 OK",response.statusLine());

        Map<String,String> mapIc= new HashMap<>();//json body içindeki json body datalarını alıp mape koyduk
        mapIc.put("checkin","2018-01-01");
        mapIc.put("checkout","2019-01-01");

        Map<String,Object> mapDis= new HashMap<>();//json body içindeki dataları mapa koyduk
        mapDis.put("firstname","Jane");
        mapDis.put("lastname","Doe");
        mapDis.put("totalprice",111);
        mapDis.put("depositpaid",true);
        mapDis.put("additionalneeds","Extra pillows please");

        Map<String,Object> actualData=response.as(HashMap.class);//gerçek dataları çekip mape koyduk response body nin içindeki butun dataları mape koyduk
        JsonPath path= response.jsonPath();//burda response içindeki dataları alıp json pathe dönüştürdük . ile ulaşabilelim diye
        assertEquals(mapIc.get("checkin"),path.getString("bookingdates.checkin"));
        assertEquals(mapIc.get("checkout"),path.getString("bookingdates.checkout"));

        assertEquals(mapDis.get("firstname"),actualData.get("firstname"));
        assertEquals(mapDis.get("lastname"),actualData.get("lastname"));
        assertEquals(mapDis.get("totalprice"),actualData.get("totalprice"));
        assertEquals(mapDis.get("depositpaid"),actualData.get("depositpaid"));
        assertEquals(mapDis.get("additionalneeds"),actualData.get("additionalneeds"));







    }
}
