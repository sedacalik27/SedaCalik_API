package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static utils.AuthenticationGmiBank.generateToken;


public class GmiBankBaseUrl {
    protected RequestSpecification spec;

    @Before
    public void setup() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://www.gmibank.com/")
                .setContentType(ContentType.JSON)//post işleminde buna ihtiyacımız var
                .addHeader("Authorization","Bearer " + generateToken())
                .build();
    }

    // base urle body eklenmez teste eklenir body değişken oldugundan

}
