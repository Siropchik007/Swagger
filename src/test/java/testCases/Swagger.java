package testCases;

import help.Steps;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import model.Pet;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static sun.net.NetProperties.get;


public class Swagger extends Steps {

    private static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri("https://reqres.in/api")
                    .setBasePath("/users?page=2")
                    .setContentType(ContentType.JSON)
                    .build();



    /*
    * Тк на создание животного
    * (я поменял тип void => Pet для тк ниже)
    * */
    @Test
    public Pet pCreate(){
        Pet create = new Steps().createPet();
        return create;



    }
    /*
    * Тк на получение животного
    * (я поменял тип void => Pet для тк ниже)
    * */
    @Test
    public Pet pGet(){

        Pet pget = new Steps().getPet(123);
        return pget;

    }


    /*
    * Тк на сравнение животных, если методы pGet и pCreate оставить в качестве тк
    * */

    @Test
    public void compPets(){
        Pet create = new Steps().createPet();
        Pet pget = new Steps().getPet(123);
        create.equals(pget);
    }

    /*
    * Тк на сравнение животных, если методы pGet и pCreate перенести в хелпер для скорости
    * */

    @Test
    public void compPetsWithHealper(){
        pGet().equals(pCreate());
    }







}

