import domain.Buyer;
import domain.lotto.Lotto;
import domain.lotto.LottoMarket;
import domain.lotto.LottoNum;
import domain.win.WinCondition;
import scanner.InputUtil;

public class LottoFront {

    public static void main(String[] args) {
        int totalBuyMoney = InputUtil.inputTotalBuyMoney();
        Buyer buyer = new Buyer(totalBuyMoney);
        int manualLottoCount = InputUtil.inputManualLottoCount(buyer.getTotalLottoCount());
        int autoLottoCount = buyer.getTotalLottoCount() - manualLottoCount;
        LottoMarket lottoMarket = new LottoMarket();
        lottoMarket.saveManualLottoNums(InputUtil.inputManualLottoNums(manualLottoCount));
        lottoMarket.generateAutoLottos(autoLottoCount);
        System.out.println("수동으로 " + manualLottoCount + "장, 자동으로 " + autoLottoCount + "장을 구매했습니다.");
        for (Lotto lotto : lottoMarket.getLottos()) {
            System.out.println(lotto.toString());
        }

        WinCondition winCondition = new WinCondition(
                InputUtil.inputWinNums(),
                InputUtil.inputBonusBall()
        )
    }
}
