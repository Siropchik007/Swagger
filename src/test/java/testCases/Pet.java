package testCases;

import help.Steps;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import model.Category;
import model.Request;
import model.Response;
import model.TagsItem;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


public class Pet {

    private static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri("https://petstore.swagger.io/v2")
                    .setBasePath("/pet")
                    .setContentType(ContentType.JSON)
                    .build();

    @Test
    public void createPet(){
        Request rq = new Request();
        rq.setName("sobaka");
        rq.setId(12);
        rq.setStatus("available");

        Category category = new Category();
        category.setId(22);
        category.setName("retrievers");
        rq.setCategory(category);

        TagsItem ti = new TagsItem();
        ti.setId(100);
        ti.setName("puppy");

        List<TagsItem> tagsItemList = new ArrayList<>();
        tagsItemList.add(ti);
        rq.setTags(tagsItemList);


        Response rs = given()
                .spec(REQ_SPEC)
                .body(rq)
                .when().post()
                .then().extract().as(Response.class);

    }
    @Test
    public void getPet(){
        List<Response> pets = Steps.getPets();
        //assertThat(pets).extracting(Response::getId).contains(12);

    }
}

