package testCases.petTestCases;

import helper.PetSteps;
import model.Pet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.TestBase;

@DisplayName("Удалиение питомца")
public class DeletePet extends TestBase {
    PetSteps helper = new PetSteps();
    @Test
    public void deletePet() {

        step("Создание животного");
        Pet createPet = helper.createPet();

        step("Удалить питомца по id");
        String deletePet = helper.deletePet(createPet.getId());

        step("Провекрка отсутствия питомца");
        String getPet = helper.getDeletedPet(createPet.getId());
    }
}
