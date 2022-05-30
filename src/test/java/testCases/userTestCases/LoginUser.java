package testCases.userTestCases;

import helper.UserSteps;
import model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.TestBase;

@DisplayName("Вход пользователя")
public class LoginUser extends TestBase {
    UserSteps helper = new UserSteps();

    @Test
    public void loginUser(){
        step("Создание пользователя");
        User createUser = helper.createUser();

        step("Вход пользователя");
        User loginUser = helper.loginUser(createUser);
    }
}
