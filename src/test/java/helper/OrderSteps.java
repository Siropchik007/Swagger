package helper;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import model.Order;

import java.time.ZonedDateTime;

import static io.restassured.RestAssured.given;

public class OrderSteps extends Order {
    Faker faker = new Faker();
    private static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri("https://petstore.swagger.io/v2")
                    .setBasePath("/store/order")
                    .setContentType(ContentType.JSON)
                    .build();

    /*
        Создание заказа
     */
    public Order createOrder(){
        Order body = new Order()
                .petId(faker.hashCode())
                .quantity(faker.hashCode())
                .id(faker.hashCode())
                .shipDate(ZonedDateTime.now())
                .complete(faker.random().nextBoolean())
                .status("placed");
        given()
                .spec(REQ_SPEC)
                .body(body)
                .when().post()
                .then().statusCode(200).log().all();
        return body;

    }
    /*
        Получение заказа
     */

    public Order getOrder(int id){
        Order findOrder = given().pathParam("id", id)
                .spec(REQ_SPEC)
                .when().get("/{id}")
                .then().statusCode(200).and().log().all()
                .extract().response().prettyPeek().as(Order.class);
        return findOrder;
    }

    /*
        Получение информации о инвенторе магазина
     */
    public String getInventoryOrder(){
        String rs = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/store/inventory")
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200).log().all()
                .extract().asString();
        return rs;
    }

    /*
        Метод для удаления заказа
     */

    public String deleteOrder(int id) {

        String result = given().pathParam("id", id)
                .spec(REQ_SPEC)
                .when().delete(PetSteps.EndPoints.pet)
                .then().statusCode(200).and().log().all()
                .extract().response().prettyPeek().asString();
        return result;
    }

    /*
        Проверка на наличие удалённого заказа
     */

    public String getDeletedOrder(int id) {

        String findOrder = given().pathParam("id", id)
                .spec(REQ_SPEC)
                .when().get("/{id}")
                .then().statusCode(404)
                .extract().response().prettyPeek().asString();
        return findOrder;
    }
}
