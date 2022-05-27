package testCases;

import helper.UserSteps;
import model.User;
import org.junit.jupiter.api.Test;
import utils.TestBase;

public class UserCreate  extends TestBase {

    UserSteps helper = new UserSteps();

    @Test
    public void createTest(){
        step("Создание пользователя");
        User createUser = helper.createUser();

        step("Получение пользователя");
        User getUser = helper.getUser(createUser.getUsername());
    }
}
