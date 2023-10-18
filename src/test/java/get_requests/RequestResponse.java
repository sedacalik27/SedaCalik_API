package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResponse {
    public static void main(String[] args) {
        String url="https://petstore.swagger.io/v2/pet/9898";

       Response response= given().when().get(url);
       response.prettyPrint();

       //Status code nasıl yazdırılır?
        System.out.println("Status Kod: " + response.statusCode());

        //Content Type nasıl yazdırılır?
        System.out.println("Content Type: " + response.contentType());

        //Status Line nasıl yazdırılır
        System.out.println("Status Line: " + response.statusLine());

        //Header bolumunden bir baslık nasıl yazdırılır?
        System.out.println("Header: " + response.header("Server"));

        System.out.println("----------------");

        //Headers bölümündeki tüm başlıklar nasıl yazdırılır?
        System.out.println("Headers: " +response.headers());

        // Time bilgisi nasıl yazdırılır?
        System.out.println("Time: " + response.time());




        //Content nasıl yazdırılır? bunu tavsite etti tabnine
        System.out.println("Content: " + response.body().asString());

    }



}
