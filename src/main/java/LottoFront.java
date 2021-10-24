import domain.Buyer;
import domain.lotto.Lotto;
import domain.lotto.LottoMarket;
import domain.lotto.LottoNum;
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
        int i = 0;
        for (Lotto lotto : lottoMarket.getLottos()) {
            /*for (LottoNum lottoNum : lotto.getLotto()) {
                System.out.println(lottoNum.getNum());
            }*/
            System.out.println(lotto.toString());
        }
    }
}
