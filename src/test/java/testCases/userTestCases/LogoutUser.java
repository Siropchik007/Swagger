package testCases.userTestCases;

import helper.UserSteps;
import model.User;
import org.junit.jupiter.api.Test;
import utils.TestBase;

public class LogoutUser extends TestBase {
    UserSteps helper = new UserSteps();

    @Test
    public void loginUser(){
        step("Создание пользователя");
        User createUser = helper.createUser();

        step("Вход пользователя");
        User loginUser = helper.loginUser(createUser);

        step("Выход пользователя");
        User logoutUser = helper.logoutUser(loginUser);
    }
}
