package testCases.userTestCases;

import helper.UserSteps;
import model.User;
import org.junit.jupiter.api.Test;
import utils.TestBase;

import java.util.List;

public class ListUser extends TestBase {
    UserSteps helper = new UserSteps();

    @Test
    public void listUser(){
        step("Создание пользователя");
        User createUser = helper.createUser();
        step("Создание пользователя");
        User createUser2 = helper.createUser();

        step("Добавляение списка пользователей");
        List<User> addUser = helper.arrayUser(createUser);
        List<User> addUser2 = helper.arrayUser(createUser2);
    }
}
