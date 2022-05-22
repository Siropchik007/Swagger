package help;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import model.Category;
import model.Pet;
import model.TagsItem;
import com.github.javafaker.*;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Steps extends Pet {

    private static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri("https://petstore.swagger.io/v2")
                    .setBasePath("/pet/12")
                    .setContentType(ContentType.JSON)
                    .build();


    /*
        Метод для создания животного
    */

    public Pet createPet(){
       Faker faker = new Faker();
        Pet body = new Pet()
                .id(faker.hashCode())
                .name(faker.name().fullName())
                .category(new Category()
                        .Id(faker.hashCode())
                        .name(faker.name().fullName()))
                .photoUrls(List.of("https://i.ytimg.com/vi/980jxJagep0/maxresdefault_live.jpg"))
                .tags(List.of(new TagsItem()
                        .id(faker.hashCode())
                        .name(faker.name().fullName())))
                .status("available");

        given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet")
                .contentType(ContentType.JSON)
                .body(body)
                .when().post()
                .then().statusCode(200).log().all();
        return  body;

    }


    /*
        Метод для получения животного
    */

    public Pet getPet(int id) {

        Pet findPet = given().pathParam("id", id)
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet")
                .contentType(ContentType.JSON)
                .when().get("/{id}")
                .then().statusCode(200).and().log().all()
                .extract().response().prettyPeek().as(Pet.class);
        return findPet;
    }

    /*
        Создание питомца без заполнения обязательных полей
     */

    public Pet createPetWithoutReqField() {
        Faker faker = new Faker();
        Pet body = new Pet()
                .id(faker.hashCode())
                .category(new Category()
                        .Id(faker.hashCode())
                        .name(faker.name().fullName()));
        given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet")
                .contentType(ContentType.JSON)
                .body(body)
                .when().post()
                .then().statusCode(200).log().all();
        return body;
    }

}


