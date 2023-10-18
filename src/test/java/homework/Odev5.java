package homework;

import baseUrl.RegresInApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class Odev5 extends RegresInApiBaseUrl{
    /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then
            1)Status code is 200
            2)Print all pantone_values
              (Tüm pantone_value değerlerini yazdırınız)
            3)Print all ids greater than 3 on the console
              (3'ten büyük id'leri yazdırınız)
              Assert that there are 3 ids greater than 3
              (3'ten büyük 3 adet id olduğunu doğrulayınız)
            4)Print all names whose ids are less than 3 on the console
              (id'si 3'ten küçük isimleri yazdırınız)
              Assert that the number of names whose ids are less than 3 is 2
              (id'si 3'ten küçük 2 isim olduğunu doğrulayınız)
    */

    @Test
    public void odev05() {
        //Set the url
        spec.pathParam("first","unknown");

        //Set the expected data
        //Set the request and get the response
        Response response = given(spec).when().get("{first}");
        response.prettyPrint();

        //Do assertion
        assertEquals(200,response.statusCode());

        JsonPath json = response.jsonPath();
        //System.out.println(json);

        //(3'ten büyük id'leri yazdırınız)
        List<Object> idList = json.getList("data.findAll{it.id}");//datadaki herşeyi ara it deki idleri ara
        System.out.println("idList = " + idList);
        //(3'ten büyük 3 adet id olduğunu doğrulayınız)
       // assertEquals(3,idList.size());




    }
}
