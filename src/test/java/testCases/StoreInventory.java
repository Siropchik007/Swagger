package testCases;

import helper.OrderSteps;
import org.junit.jupiter.api.Test;
import utils.TestBase;

public class StoreInventory extends TestBase {
    OrderSteps helper = new OrderSteps();

    @Test
    public void getInventory(){
        step("Получение информации о инвенторе магазина");
        String inventoryInfo = helper.getInventoryOrder();
    }
}
