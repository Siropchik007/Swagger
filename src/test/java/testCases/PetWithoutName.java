package testCases;

import help.Steps;
import model.Pet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.TestBase;


public class PetWithoutName extends TestBase {
    Steps helper = new Steps();

    @Test
    public void petWithoutRequiredName(){

        step("Создание животного без имени");
        Pet createPet = helper.createPetWithoutName();

        step("Получить информация по животному по id");
        Pet getPet = helper.getPet(createPet.getId());
        Assertions.assertThat(getPet.getName()).isNotNull();

    }
}
