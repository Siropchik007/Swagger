package testCases;

import helper.OrderSteps;
import model.Order;
import org.junit.jupiter.api.Test;
import utils.TestBase;

import java.time.LocalDateTime;

public class OrderCreate extends TestBase {
    OrderSteps helper = new OrderSteps();

    @Test
    public void createTest(){
        step("Создание заказа");
        Order create = helper.createOrder();

        step("Получение заказа");
        Order getOrder = helper.getOrder(create.getId());
    }
}
