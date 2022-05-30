package testCases.orderTestCases;

import helper.OrderSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.TestBase;

@DisplayName("Получение информации о инвенторе магазина")
public class StoreInventory extends TestBase {
    OrderSteps helper = new OrderSteps();

    @Test
    public void getInventory(){
        step("Получение информации о инвенторе магазина");
        String inventoryInfo = helper.getInventoryOrder();
    }
}
