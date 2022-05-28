package userTestCases;

import helper.UserSteps;
import model.User;
import org.junit.jupiter.api.Test;
import utils.TestBase;

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
