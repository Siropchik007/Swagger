package testCases.petTestCases;

import helper.PetSteps;
import model.Pet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("Создание питомца")
public class MappingFieldPet extends TestBase {
        PetSteps helper = new PetSteps();
        @Test
        public void mappingFieldPet() {

            step("Создание питомца");
            Pet createPet = helper.createPet();

            step("Получить информация по питомца по id");
            Pet getPet = helper.getPet(createPet.getId());
            assertAll(
                    () -> assertThat("Проверка соответствия имени", getPet.getName(), equalTo(createPet.getName())),
                    () -> assertThat("Проверка соответствия  id", getPet.getId(), equalTo(createPet.getId())),
                    () -> assertThat("Проверка соответствия id категории", getPet.getCategory().getId(), equalTo(createPet.getCategory().getId())),
                    () -> assertThat("Проверка соответствия url фото", getPet.getPhotoUrls(), equalTo(createPet.getPhotoUrls())),
                    () -> assertThat("Проверка соответствия id тэга", getPet.getTags().get(0).getId(), equalTo(createPet.getTags().get(0).getId())),
                    () -> assertThat("Проверка соответствия статуса", getPet.getStatus(), equalTo(createPet.getStatus()))
            );


        }

}

