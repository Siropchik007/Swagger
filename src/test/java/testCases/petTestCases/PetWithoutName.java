package testCases.petTestCases;

import helper.PetSteps;
import model.Pet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.TestBase;


public class PetWithoutName extends TestBase {
    PetSteps helper = new PetSteps();

    @Test
    public void petWithoutRequiredName(){

        step("Создание животного без имени");
        Pet createPet = helper.createPetWithoutName();

        step("Получить информация по животному по id");
        Pet getPet = helper.getPet(createPet.getId());
        Assertions.assertThat(getPet.getName()).isNull();

    }
}
