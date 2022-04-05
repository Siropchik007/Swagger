package help;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import model.Category;
import model.Pet;
import model.TagsItem;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Steps {

    private static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri("https://petstore.swagger.io/v2")
                    .setBasePath("/pet/12")
                    .setContentType(ContentType.JSON)
                    .build();

    //здесь у меня вообще get метод не очень
    public static List<Pet> getPets(){
        return  given().spec(REQ_SPEC)
                .get()
                .jsonPath().getList("Pet" , Pet.class);
    }


    public static Pet create(){

        Category ct = new Category();
        ct.setId(22);
        ct.setName("retrievers");

        TagsItem ti = new TagsItem();
        ti.setId(100);
        ti.setName("puppy");

        List<TagsItem> tagsItemList = new ArrayList<>();
        tagsItemList.add(ti);

        return Pet.builder()
                .name("sobaka")
                .id(12)
                .status("available")
                .category(ct)
                .tags(tagsItemList)
                .build();

        /* этот кусок кода выдаёт ошибку
        Pet rq = new Pet();
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


        model.Pet rs = given()
                .spec(REQ_SPEC)
                .body(rq)
                .when().post()
                .then().extract().as(model.Pet.class);
        return rs;*/
    }
}
