package testCases;

import helper.PetSteps;
import model.Pet;
import org.junit.jupiter.api.Test;
import utils.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


public class MappingFieldPet extends TestBase {
        PetSteps helper = new PetSteps();
        @Test
        public void mappingFieldPet() {

            step("Создание животного");
            Pet createPet = helper.createPet();

            step("Получить информация по животному по id");
            Pet getPet = helper.getPet(createPet.getId());
            assertAll(
                    () -> assertThat("Проверка имени", getPet.getName(), equalTo(createPet.getName())),
                    () -> assertThat("Проверка id", getPet.getId(), equalTo(createPet.getId())),
                    () -> assertThat("Проверка id категории", getPet.getCategory().getId(), equalTo(createPet.getCategory().getId())),
                    () -> assertThat("Проверка url фото", getPet.getPhotoUrls(), equalTo(createPet.getPhotoUrls())),
                    () -> assertThat("Проверка id тэга", getPet.getTags().get(0).getId(), equalTo(createPet.getTags().get(0).getId())),
                    () -> assertThat("Проверка названия тэга", getPet.getStatus(), equalTo(createPet.getStatus()))
            );


        }

}

