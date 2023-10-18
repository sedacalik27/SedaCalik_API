package gmi_bank;

import baseUrl.GmiBankBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.gmibank.PostCountryPojo;
import pojos.gmibank.StatesPojo;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PostCountry extends GmiBankBaseUrl{
     /*
        https://app.swaggerhub.com/apis/yasinaniltechpro/GmiBank/0.0.1 dokümanını kullanarak en az 3 "state"
        içeren bir "country" oluşturan bir otomasyon testi yazınız.
        Not : Autherization için headers'a "Authorization" = ""Bearer abc123"  şeklinde Bearer token giriniz.
     */


        /*
 Given
    https://gmibank.com/api/tp-countries
 And
    {
      "name": "Muz Cumhuriyeti",
      "states": [
        {
          "id": 1,
          "name": "Elma"
        },
        {
          "id": 2,
          "name": "Kiraz"
        },
        {
          "id": 3,
          "name": "Kivi"
        }
      ]
    }

 When
    Kullanıcı POST Request gönderir
 Then
    Status Code: 201
 And //dönen bodyi buraya ekliyoruz aşagıya
    {
        "id": 193527,
        "name": "Muz Cumhuriyeti",
        "states": [
            {
                "id": 1,
                "name": "Elma",
                "tpcountry": null
            },
            {
                "id": 2,
                "name": "Kiraz",
                "tpcountry": null
            },
            {
                "id": 3,
                "name": "Kivi",
                "tpcountry": null
            }
        ]
    }
*/


    @Test
    public void postCountry() {
        //Set the url
        //önce base url yapıcaz extend edicez
        spec.pathParams("first","api","second","tp-countries");



        //pojoları eklenti yardımıyla yada siteler var onlardan faydalanabiliriz
        //şimdi eklentilerden faydalanıcaz--File / Settings / Plugins / Marketplace / Pojo Generator

        //Set the expected data
        //burada pojoya ihtiyacımız var
        //eklenti yardımıyla pojoları otomatik yükledik
        //requestteki bodyi siyah ekrana yapıştırıyoz
        //öncelikle 3 tane obje oluşturucaz elma,kiraz, kivi için ayrı ayrı obje oluşturuyoz

        StatesPojo state1 = new StatesPojo(1,"Elma");
        StatesPojo state2 = new StatesPojo(2,"Kiraz");
        StatesPojo state3 = new StatesPojo(3,"Kivi");



        List<StatesPojo> stateList= new ArrayList<>();
        stateList.add(state1);
        stateList.add(state2);
        stateList.add(state3);

        //2,yol
       // List<StatesPojo> stateList = new ArrayList<StatesPojo>(Arrays.asList(state1,state2,state3));

        //3.yol//eger bu yolu tercih edersek yukardaki objelere ve add lere gerek yok
     //  List<StatesPojo> stateList2 = List.of(
     //          new StatesPojo(1, "Elma"),
     //          new StatesPojo(2, "Kiraz"),
     //          new StatesPojo(3, "Kivi"));//ama bunda değişiklik yapamıyoruz bu list oluşturma yöntemini tercih edersek değikilik yapamıyoz


        PostCountryPojo payLoad= new PostCountryPojo("Muz Cumhuriyeti", stateList);//expected datamızı oluşturduk daha göndermedik


        // Send the request and get the response
        Response response = given(spec).body(payLoad).when().post("{first}/{second}");//burda hazırladıgımız dataları gönderiyoruz bununla
        response.prettyPrint();

        //burda hata aldık çünkü utilse AuthenticationGmiBank eklememiz gerek , çünkü unaotorization hatası aldık


        //Do assertion
       // responsetan gelen bodyi as methoduyla country pojo classına dönüştürüyoruz

        PostCountryPojo actualData = response.as(PostCountryPojo.class);


        assertEquals(201, response.statusCode());
        //name payloadın içinde payload.getname diyoz
        assertEquals(payLoad.getName(), actualData.getName());
        //şimdi stateleri dogrulucaz bu benim state1 objemde
        //statein içinde 3 data oldugundan indexten alıyoz
        assertEquals(state1.getId(), actualData.getStates().get(0).getId());
        assertEquals(state1.getName(), actualData.getStates().get(0).getName());
        assertEquals(state2.getId(), actualData.getStates().get(1).getId());
        assertEquals(state2.getName(), actualData.getStates().get(1).getName());
        assertEquals(state3.getId(), actualData.getStates().get(2).getId());
        assertEquals(state3.getName(), actualData.getStates().get(2).getName());









    }
}
