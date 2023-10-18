package get_requests;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class Get03 {
    /*
        Given
            https://petstore.swagger.io/v2/pet/9898
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status Code 200 olmalı
        And
            Content Type "application/json" olmalı
        And
            "name" şu metni içermeli: "Pamuk",
        And
            "status" değeri "available" olmalı
        And
            "category" altındaki "name" değeri "Köpek" olmalı
        And
            "tags" altındaki "name" değeri "Sibirya Kurdu" olmalı
     */

    @Test
    public void get03HardAssertion() {
        /*
        1.Set the URL-->given
        2.Set the expected data-->given
        3.Send the request and get the responce -->when
        4.Do assertion -->then
         */
        //set the URL
        RestAssured.baseURI="https://petstore.swagger.io/v2";
        RestAssured.basePath="/pet/9898";

        // 2. Set the expected data
        /*
        (Bu işlemi POST, PUT gibi metotları kullanacağımız zaman ve
         GET metodu kullandığımızda dataları karşılıklı olarak doğrulayacağımız zaman yapacağız)
        */

        // 3. Send the request and get the responce
        given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("name", containsString("Pamuk"))
                .body("status", equalTo("available"))
                .body("category.name", equalTo("Köpek"))//{ görünce nokta koy
                .body("tags[0].name", equalTo("Sibirya Kurdu"));


    }
    //hard ta ilkinde hata oldugu zaman duruyor diğer hataları göstermiyor
    //fakat softta hata olan tüm kodları gösteriyor


    @Test
    public void get03SoftAssertion() {
        // 1. Set the URL
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet/9898";
        // 2. Set the expected data
        // 3. Send the request and get the response
        given()
                .when()
                .get()
                .then() // 4. Do assertion
                .statusCode(200)
                .contentType("application/json")
                .body("name", containsString("Pamuks")
                        ,"status", equalTo("available")
                        ,"category.name", equalTo("Köpeks")
                        ,"tags[0].name", equalTo("Sibirya Kurdu"));



    }





}
