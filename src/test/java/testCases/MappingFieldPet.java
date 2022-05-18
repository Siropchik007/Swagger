package testCases;

import help.Steps;
import model.Pet;
import org.junit.jupiter.api.Test;
import utils.TestBase;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.*;


public class MappingFieldPet extends TestBase {
        Steps helper = new Steps();
        @Test
        public void mappingFieldPet() {

            step("Создание животного");
            Pet createPet = helper.createPet();

            step("Получить информация по животному по id");
            Pet getPet = helper.getPet(createPet.getId());

            assertAll(
                    () -> assertEquals( getPet.getName(), (createPet.getName()), "Проверка name")
            );

        }

}

