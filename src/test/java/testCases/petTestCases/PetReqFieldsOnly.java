package testCases.petTestCases;


import helper.PetSteps;
import model.Pet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("Создание питомца без обязательных полей")
public class PetReqFieldsOnly extends TestBase {
    PetSteps helper = new PetSteps();

    @Test
    public void petReqFieldsOnly(){

        step("Создание питомца без обязательных полей");
        Pet createPet = helper.createPetReqFieldsOnly();
        assertAll(
                () -> assertThat("Проверка имени", createPet.getName(), equalTo(createPet.getName())),
                () -> assertThat("Проверка url фото", createPet.getPhotoUrls(), equalTo(createPet.getPhotoUrls())),
                () -> assertThat("Проверка id", createPet.getId(), equalTo(0)),
                () -> assertThat("Проверка id категории", createPet.getCategory(), equalTo(null)),
                () -> assertThat("Проверка id тэга", createPet.getTags(), equalTo(null)),
                () -> assertThat("Проверка названия тэга", createPet.getStatus(), equalTo(null))
        );
    }
}
