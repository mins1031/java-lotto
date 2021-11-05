import domain.Buyer;
import domain.lotto.Lotto;
import domain.lotto.LottoFront;
import domain.lotto.lottogenerate.LottoAutoGenerator;
import domain.lotto.lottogenerate.LottoGenerator;
import domain.lotto.lottogenerate.LottoManualGenerator;
import domain.win.WinCondition;
import scanner.InputUtil;
import domain.win.WinResult;

import java.util.Arrays;
import java.util.List;

public class LottoMarket {

    public static void main(String[] args) {
        int totalBuyMoney = InputUtil.inputTotalBuyMoney();
        Buyer buyer = new Buyer(totalBuyMoney);
        int manualLottoCount = InputUtil.inputManualLottoCount(buyer.getTotalLottoCount());
        int autoLottoCount = buyer.getTotalLottoCount() - manualLottoCount;
        LottoFront lottoFront = new LottoFront();
        lottoFront.saveManualLottoNums(InputUtil.inputManualLottoNums(manualLottoCount));
        lottoFront.generateAutoLottos(autoLottoCount);
        System.out.println("수동으로 " + manualLottoCount + "장, 자동으로 " + autoLottoCount + "장을 구매했습니다.");
        for (Lotto lotto : lottoFront.getLottos()) {
            System.out.println(lotto.toString());
        }

        WinCondition winCondition = new WinCondition(
                lottoFront.toLottoNum(InputUtil.inputWinNums()),
                InputUtil.inputBonusBall()
        );

        WinResult winResult = new WinResult();
        winResult.checkLottosResult(winCondition, lottoFront.getLottos(), buyer.getTotalBuyMoney());
        System.out.println(winResult);
    }
}
