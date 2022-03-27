package model;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class getPet {

    @Test
    public void createPet(){
        Request rq = new Request();
        rq.setName("popa");

        Response rs = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet")
                .contentType(ContentType.JSON)
                .body(rq)
                .when().post()
                .then().extract().as(Response.class);
    }

    @Test
    public void  getPet(){
        given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet/12")
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
                .body("name", equalTo("dom"));
    }


}
