package testCases;

import help.Steps;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import model.Pet;
import org.junit.jupiter.api.Test;


public class Swagger extends Steps {

    private static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri("https://petstore.swagger.io/v2")
                    .setBasePath("/pet")
                    .setContentType(ContentType.JSON)
                    .build();

    @Test
    public void tCreate(){
        Pet create = new Steps().createPet();
       /* assertThat(create)
                .isNotNull()
                .extracting(Pet::getName)
                .isEqualTo("Bob");*/

    }
    @Test
    public void tGet(){
        Pet get = new Steps().getPets();
    }





}

