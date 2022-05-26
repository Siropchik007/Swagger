package helper;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import model.Order;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import static io.restassured.RestAssured.given;

public class OrderSteps extends Order {
    private static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri("https://petstore.swagger.io/v2")
                    .setBasePath("/store/order")
                    .setContentType(ContentType.JSON)
                    .build();

    public Order createOrder(){
        Order body = new Order()
                .petId(1)
                .quantity(2)
                .id(123)
                .shipDate(ZonedDateTime.now())
                .complete(true)
                .status("placed");
        given()
                .spec(REQ_SPEC)
                .body(body)
                .when().post()
                .then().statusCode(200).log().all();
        return body;

    }

    public Order getOrder(int id){
        Order findOrder = given().pathParam("id", id)
                .spec(REQ_SPEC)
                .when().get("/{id}")
                .then().statusCode(200).and().log().all()
                .extract().response().prettyPeek().as(Order.class);
        return findOrder;
    }
}
