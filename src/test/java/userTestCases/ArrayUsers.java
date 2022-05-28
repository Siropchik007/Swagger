package userTestCases;

import helper.UserSteps;
import model.User;
import org.junit.jupiter.api.Test;
import utils.TestBase;

import java.util.ArrayList;

public class ArrayUsers extends TestBase {
    UserSteps helper = new UserSteps();

    @Test
    public void arrayUser(){
        step("Создание пользователя");
        User createUser = helper.createUser();
        step("Создание пользователя");
        User createUser2 = helper.createUser();

        step("Добавляение vfccbdf пользователей");
        ArrayList<User> addUser = helper.arrayUser(createUser);
        ArrayList<User> addUser2 = helper.arrayUser(createUser2);
    }
}
