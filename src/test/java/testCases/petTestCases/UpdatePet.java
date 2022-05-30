package testCases.petTestCases;

import helper.PetSteps;
import model.Pet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
@DisplayName("Обновление питомца")
public class UpdatePet extends TestBase {
    PetSteps helper = new PetSteps();

    @Test
    public void updatePet(){

        step("Создание питомца");
        Pet createPet = helper.createPet();

        step("Обновление питомца");
        Pet updatePet = helper.updatePet(createPet);

        step("Получить информация по питомца по id");
        Pet getPet = helper.getPet(createPet.getId());

        assertAll(
                () -> assertThat("Проверка имени", getPet.getName(), equalTo(updatePet.getName())),
                () -> assertThat("Проверка id", getPet.getId(), equalTo(updatePet.getId())),
                () -> assertThat("Проверка id категории", getPet.getCategory().getId(), equalTo(updatePet.getCategory().getId())),
                () -> assertThat("Проверка url фото", getPet.getPhotoUrls(), equalTo(updatePet.getPhotoUrls())),
                () -> assertThat("Проверка id тэга", getPet.getTags().get(0).getId(), equalTo(updatePet.getTags().get(0).getId())),
                () -> assertThat("Проверка названия тэга", getPet.getStatus(), equalTo(updatePet.getStatus()))
        );
    }

}
