package homework;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Soru03 extends JsonPlaceHolderBaseUrl {
    /*
        Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status Code 200 olmalı
        And
            Content Type “application/json” olmalı
        And
            “title” şu metni içermeli: “et itaque necessitatibus maxime molestiae qui quas velit”,
        And
            “completed” değeri false olmalı
        And
            “userId” değeri 2 olmalı
     */

    @Test
    public void soru03() {
        //Set the url
        spec.pathParams("first","todos","second",23);

        //set the expected data

        //send the request and get the responce
        Response response=given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        Map<String,Object> map= new HashMap<>();
        map.put("userId",2);
        map.put("title","et itaque necessitatibus maxime molestiae qui quas velit");
        map.put("completed",false);


        //Do assertion
        assertEquals(200,response.statusCode());
        assertTrue(response.contentType().contains("application/json"));

        JsonPath jsonPath= response.jsonPath();
        assertTrue(map.get("title").toString(),jsonPath.getString("title").contains("et itaque necessitatibus maxime molestiae qui quas velit"));
        assertFalse(map.get("completed").toString(), jsonPath.getBoolean("completed"));
        assertEquals(map.get("userId"), jsonPath.getInt("userId"));

        //sor hocaya : burda tostring yapmadık yine depass oldu



    }
}
