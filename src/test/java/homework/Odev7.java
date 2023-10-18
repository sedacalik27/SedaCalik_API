package homework;

import baseUrl.PetStoreBaseUrl;
import org.junit.Test;
import pojos.petstore.PetStorePojo;

public class Odev7 extends PetStoreBaseUrl {
      /*
   "https://petstore.swagger.io/" dökümanını kullanarak 'user' oluşturacak bir otomasyon testi yazınız
    Not: Test Case'i gherkin language ile yazınız.
    */


    /*
   "https://petstore.swagger.io/" dökümanını kullanarak 'user' oluşturacak bir otomasyon testi yazınız
    Not: Test Case'i gherkin language ile yazınız.
    */
    /*
    Given
       1) https://petstore.swagger.io/v2/user
       2)  {
  		"id": 0,
  		"username": "string",
  		"firstName": "string",
  		"lastName": "string",
  		"email": "string",
  		"password": "string",
  		"phone": "string",
  		"userStatus": 0
	   }
    When
        I send POST Request to the Url
    Then
        Status code is 200
    And
        response body is like
		{
    			"code": 200,
    			"type": "unknown",
    			"message": "55555"
		}
     */

    @Test
    public void odev07() {
        //Set the url
        spec.pathParam("first","user");

        PetStorePojo petStorePojo = new PetStorePojo("john123","John","Doe","john123@hotmail.com","pwd","12345",14);







    }
}
