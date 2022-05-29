package testCases;

import helper.OrderSteps;
import model.Order;
import org.junit.jupiter.api.Test;
import utils.TestBase;

public class DeleteOrder extends TestBase {
    OrderSteps helper = new OrderSteps();

    @Test
    public void deleteOrder(){
        step("Создание животного");
        Order createPet = helper.createOrder();

        step("Удалить питомца по id");
        String deletePet = helper.deleteOrder(createPet.getId());

        step("Провекрка отсутствия питомца");
        String getPet = helper.getDeletedOrder(createPet.getId());
    }


}
