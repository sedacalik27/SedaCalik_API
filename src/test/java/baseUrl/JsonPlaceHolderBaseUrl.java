package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {
    protected RequestSpecification spec;

    @Before
    public void setup(){
        spec = new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .setContentType(ContentType.JSON)// Post işlemi yapmayacağımız için kullanmaya gerek yok diye yoruma aldık. (Post işlemleri için gerek var.)
                .build();
    }
}
