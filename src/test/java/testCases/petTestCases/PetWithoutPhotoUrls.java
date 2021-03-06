package testCases.petTestCases;

import helper.PetSteps;
import model.Pet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.TestBase;

@DisplayName("Создание питомца без фото")
public class PetWithoutPhotoUrls extends TestBase {
    PetSteps helper = new PetSteps();

    @Test
    public void petWithoutRequiredPhoto(){

        step("Создание животного без ссылки на фото");
        Pet createPet = helper.createPetWithoutPhotoUrls();

        step("Получить информация по животному по id");
        Pet getPet = helper.getPet(createPet.getId());

        Assertions.assertThat(getPet.getPhotoUrls()).isNull();

    }
}
