import domain.Buyer;
import domain.bonusball.BonusBall;
import domain.lotto.Lotto;
import domain.lotto.LottoMarket;
import domain.win.WinCondition;
import domain.win.WinResult;
import scanner.InputUtil;
import scanner.OutputUtil;

public class LottoMain {

    public static void main(String[] args) {
        Buyer buyer = new Buyer(InputUtil.inputTotalBuyMoney());
        buyer.defineAllLottoCountTypes(InputUtil.inputManualLottoCount());
        LottoMarket.generateLottos(buyer);
        OutputUtil.informBuyLottosCount(buyer);
        OutputUtil.informBuyLottoNums(buyer.getBuyLottos());

        WinCondition winCondition = new WinCondition(Lotto.toLottoNum(InputUtil.inputWinNums()), new BonusBall(InputUtil.inputBonusBall()));
        WinResult winResult = new WinResult();
        winResult.checkLottosResult(winCondition, buyer.getBuyLottos(), buyer.getBuyMoney().getBuyMoney());
        OutputUtil.informWinStatistics(winResult);
    }
}
