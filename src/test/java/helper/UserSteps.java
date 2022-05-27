package helper;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import model.User;

import static io.restassured.RestAssured.given;

public class UserSteps {
    Faker faker = new Faker();
    private static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri("https://petstore.swagger.io/v2")
                    .setBasePath("/user")
                    .setContentType(ContentType.JSON)
                    .build();

    /*
        Создание пользователя
     */
    public User createUser(){
        User body = new User()
                .id(faker.hashCode())
                .username(faker.name().username())
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password())
                .phone(faker.phoneNumber().cellPhone())
                .userStatus(faker.hashCode());
        given()
                .spec(REQ_SPEC)
                .body(body).log().all()
                .when().post()
                .then().statusCode(200);
        return body;
    }

    /*
        Получение пользователя
     */

    public User getUser(String username){
        User findOrder = given().pathParam("username", username)
                .spec(REQ_SPEC)
                .when().get("/{username}")
                .then().statusCode(200).and().log().all()
                .extract().response().prettyPeek().as(User.class);
        return findOrder;
    }

    /*
        Удаление пользователя
     */
    public String deleteUser(String username) {

        String result = given().pathParam("username", username)
                .spec(REQ_SPEC)
                .when().delete("/{username}")
                .then().statusCode(200).and().log().all()
                .extract().response().prettyPeek().asString();
        return result;
    }

    /*
        Проверка на наличие удалённого пользователя
     */

    public String getDeletedUser(String username) {

        String findOrder = given().pathParam("username", username)
                .spec(REQ_SPEC)
                .when().get("/{username}")
                .then().statusCode(404)
                .extract().response().prettyPeek().asString();
        return findOrder;
    }

    /*
        Обновление пользователя
     */
    public User updateUser(User updatedUser) {
        User body = new User()
                .id(faker.hashCode())
                .username(updatedUser.getUsername())
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password())
                .phone(faker.phoneNumber().cellPhone())
                .userStatus(faker.hashCode());
        given()
                .spec(REQ_SPEC)
                .body(body).log().all()
                .when().put("/{username}", updatedUser.getUsername())
                .then().statusCode(200);
        return body;
    }

}
