import lotto.domain.BuyMoney;
import lotto.domain.LottoCalcurator;
import lotto.domain.WinInfo;
import lotto.domain.WinResult;
import lotto.domain.lottos.Lotto;
import lotto.domain.lottos.LottoInfo;
import lotto.exception.ExceptionHandler;
import lotto.scanner.InputScanner;

public class LottoMain {

    public static void main(String[] args) {

        BuyMoney totalAmount = BuyMoney.configPurchaseAmount("구매금액을 입력해 주세요.");

        LottoInfo lottoInfo = new LottoInfo(totalAmount);
        lottoInfo.calculateInitValue("수동으로 구매할 로또 수를 입력해 주세요.");

        Lotto lotto = new Lotto();
        lotto.createManualLotto("수동으로 구매할 번호를 입력해 주세요.",lottoInfo.getManualLottoCount());
        lotto.createAutoLotto(lottoInfo.getAutoLottoCount());
        lotto.print();

        WinInfo winInfo = new WinInfo();
        winInfo.inputWinNumbers("지난 주 당첨 번호를 입력해 주세요.");
        winInfo.inputBonusBall("보너스 볼을 입력해 주세요.");

        WinResult winResult = LottoCalcurator.calculateStatistic(winInfo, lotto);
        System.out.println(winResult.print());
    }
}
