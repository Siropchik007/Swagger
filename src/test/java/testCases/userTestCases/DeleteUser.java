package testCases.userTestCases;

import helper.UserSteps;
import model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.TestBase;
@DisplayName("Удаление пользователя")
public class DeleteUser extends TestBase {
    UserSteps helper = new UserSteps();

    @Test
    public void deleteUser(){
        step("Создание животного");
        User createUser = helper.createUser();

        step("Удалить питомца по id");
        String deleteUser = helper.deleteUser(createUser.getUsername());

        step("Провекрка отсутствия питомца");
        String getUser = helper.getDeletedUser(createUser.getUsername());
    }
}
