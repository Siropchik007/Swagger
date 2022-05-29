package testCases;

import helper.OrderSteps;
import model.Order;
import org.junit.jupiter.api.Test;
import utils.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


public class OrderCreate extends TestBase {
    OrderSteps helper = new OrderSteps();

    @Test
    public void createTest(){
       step("Создание заказа");
        Order createOrder = helper.createOrder();

        step("Получение заказа");
        Order getOrder = helper.getOrder(createOrder.getId());

        assertAll(
                () -> assertThat("Проверка соответствия id заказа", getOrder.getId(), equalTo(createOrder.getId())),
                () -> assertThat("Проверка соответствия id питомца", getOrder.getPetId(), equalTo(createOrder.getPetId())),
                () -> assertThat("Проверка на соответствие кол-ва", getOrder.getQuantity(), equalTo(createOrder.getQuantity())),
                () -> assertThat("Проверка соответствия статуса", getOrder.getStatus(), equalTo(createOrder.getStatus())),
                () -> assertThat("Проверка состояния заказа", getOrder.isComplete(), equalTo(createOrder.isComplete()))
        );


    }
}
