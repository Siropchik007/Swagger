package testCases;

import com.github.javafaker.Faker;
import help.Steps;
import model.Pet;
import org.junit.jupiter.api.Test;
import utils.TestBase;

import static io.restassured.RestAssured.given;
public class RequiredField extends TestBase {

    @Test
    public void createErrorPet(){
        Faker faker = new Faker();

        Steps helper = new Steps();
        step("Создание животного");
        Pet createPet = helper.createPetWithoutReqField();

        step("Получить информация по животному по id");
        Pet getPet = helper.getPet(createPet.getId());
    }
}
