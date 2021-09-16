import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyMoneyTest {
    @Test
    @DisplayName("BuyMoney IllegalArgumentException Test")
    @Disabled
    public void configPurchaseAmountExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> BuyMoney.configPurchaseAmount("-1"));
    }

    @Test
    @DisplayName("BuyMoney Test")
    @Disabled
    public void configPurchaseAmountTest() {
        BuyMoney buyMoney = BuyMoney.configPurchaseAmount("14000");
        Assertions.assertEquals(buyMoney.getPurchaseAmount(), 14000);
    }
}