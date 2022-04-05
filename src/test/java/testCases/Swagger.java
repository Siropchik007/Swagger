package testCases;

import help.Steps;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import model.Pet;
import org.junit.jupiter.api.Test;

import java.util.List;


public class Swagger {

    private static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri("https://petstore.swagger.io/v2")
                    .setBasePath("/pet")
                    .setContentType(ContentType.JSON)
                    .build();

    @Test
    public void createPet(){

        model.Pet CPet = Steps.create();



    }
    @Test
    public void getPet(){
        List<model.Pet> Gpet = Steps.getPets();

    }


}

