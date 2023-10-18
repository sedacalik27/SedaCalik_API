package homework;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Soru04 extends JsonPlaceHolderBaseUrl {
     /*
        Given
            https://jsonplaceholder.typicode.com/todos
        When
	 	    Kullanıcı URL'e bir GET request gönderir
	    And
	        Accept type “application/json” olmalı
	    Then
	        HTTP Status Code 200 olmalı
	    And
	        Response format "application/json" olmalı
	    And
	        Listede 200 tane eleman olmalı
	    And
	        title içeriklerinden en az birinin değeri "quis eius est sint explicabo" olmalı
	    And
	        userIds değerleri içerisinde 2, 7, ve 9 bulunmalı
     */

    @Test
    public void soru04() {
        //Set the url
        spec.pathParam("first","todos");

        //Set the expected data


        //Send the request and get the responce
        Response response=given(spec).when().get("{first}");
        response.prettyPrint();

        assertTrue(response.contentType().contains("application/json"));
        assertEquals(200,response.statusCode());

        JsonPath json=response.jsonPath();
        List<Object> list=json.getList("findAll");

        assertEquals(200,list.size());
        List<Object> listTitle=json.getList("findAll{it.title=='quis eius est sint explicabo'}.title");
        System.out.println(listTitle);

        //1.yol
        assertTrue(listTitle.contains("quis eius est sint explicabo"));
        //2.yol
        assertTrue(!listTitle.isEmpty());

        response.then().body("id",hasItems(2,7,9));


    }
}
