package help;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import model.Category;
import model.Pet;
import model.TagsItem;
import org.junit.jupiter.api.Test;
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

   @Test
    public Pet createPet(){
       Faker faker = new Faker();
        Pet body = new Pet()
                /*.id(faker.hashCode())
                .name(faker.name().fullName())
                .category(new Category().Id(faker.hashCode()).name(faker.name().fullName()))
                .photoUrls(List.of("https://i.ytimg.com/vi/980jxJagep0/maxresdefault_live.jpg"))
                .tags(List.of(new TagsItem().id(faker.hashCode()).name(faker.name().fullName())))*/
                .id(123)
                .name("Bob")
                .category(new Category().Id(12).name("Cat"))
                .photoUrls(List.of("https://i.ytimg.com/vi/980jxJagep0/maxresdefault_live.jpg"))
                .tags(List.of(new TagsItem().id(13).name("funny")))
                .status("available");
        given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet")
                .contentType(ContentType.JSON)
                .body(body).log().all()
                .when().post()
                .then().statusCode(200).log().all();
        return  body;

    }

    @Test
    public Pet getPets(){
        Pet db = new Pet();
        given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet/123")
                .contentType(ContentType.JSON)
                .body(db).log().all()
                .when().get()
                .then().statusCode(200).log().all();
        return  db;
    }
}


