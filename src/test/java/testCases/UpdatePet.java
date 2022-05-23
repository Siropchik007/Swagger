package testCases;

import com.github.javafaker.Faker;
import help.Steps;
import model.Pet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import utils.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class UpdatePet extends TestBase {
    Steps helper = new Steps();

    @Test
    public void updatePett(){

        step("Создание животного без ссылки на фото");
        Pet createPet = helper.createPet();

        step("Обновление питомца");
        Pet updatePet = helper.updatePet(createPet);

        step("Получить информация по животному по id");
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
