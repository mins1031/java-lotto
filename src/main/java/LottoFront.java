import domain.Buyer;
import scanner.InputUtil;

public class LottoFront {

    public static void main(String[] args) {
        int totalBuyMoney = InputUtil.inputTotalBuyMoney();
        Buyer buyer = new Buyer(totalBuyMoney);
        int manualLottoCount = InputUtil.inputManualLottoCount(buyer.getTotalLottoCount());

    }
}
