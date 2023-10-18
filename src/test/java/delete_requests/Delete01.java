package delete_requests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class Delete01 extends JsonPlaceHolderBaseUrl {
      /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
            I send DELETE Request to the Url
        Then
            Status code is 200
        And Response body is { }
    */

    @Test
    public void delete01() {
        //Set the url
        spec.pathParams("first","todos","second",198);

        //Set the expected data
        Map<String,String> expectedDta=new HashMap<>();


        //Set the request anad get the response
        Response response=given(spec).when().delete("{first}/{second}");
        response.prettyPrint();

        //do assertion
        //karşıdan gelen datayıda bir mape alıcaz
        Map<String,String> actualData=response.as(HashMap.class);
        assertEquals(200,response.statusCode());
        //1.yol
        assertEquals(expectedDta,actualData);
        //2.yol
        assertTrue(actualData.isEmpty());
        //3.yol
        assertEquals(0,actualData.size());





    }
}
