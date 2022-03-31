package help;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import model.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Steps {

    private static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri("https://petstore.swagger.io/v2")
                    .setBasePath("/pet/12")
                    .setContentType(ContentType.JSON)
                    .build();

    public static List<Response> getPets(){
        return  given().spec(REQ_SPEC)
                .get()
                .jsonPath().getList("tags" , Response.class);
    }
}
