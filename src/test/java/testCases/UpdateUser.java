package testCases;

import helper.UserSteps;
import model.User;
import org.junit.jupiter.api.Test;
import utils.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class UpdateUser extends TestBase {
    UserSteps helper = new UserSteps();

    @Test
    public void updateUser(){

        step("Создание пользователя");
        User createUser = helper.createUser();

        step("Обновление пользователя");
        User updateUser = helper.updateUser(createUser);

        step("Получить информация о пользователе по id");
        User getUser = helper.getUser(createUser.getUsername());

        assertAll(
                () -> assertThat("Проверка ", getUser.getUsername(), equalTo(updateUser.getUsername())),
                () -> assertThat("Проверка ", getUser.getFirstName(), equalTo(updateUser.getFirstName())),
                () -> assertThat("Проверка ", getUser.getLastName(), equalTo(updateUser.getLastName())),
                () -> assertThat("Проверка ", getUser.getEmail(), equalTo(updateUser.getEmail())),
                () -> assertThat("Проверка ", getUser.getPassword(), equalTo(updateUser.getPassword())),
                () -> assertThat("Проверка ", getUser.getPhone(), equalTo(updateUser.getPhone())),
                () -> assertThat("Проверка ", getUser.getUserStatus(), equalTo(updateUser.getUserStatus()))
        );
    }
}
