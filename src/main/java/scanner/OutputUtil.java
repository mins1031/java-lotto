package scanner;

import domain.Buyer;
import domain.lotto.Lotto;
import domain.win.WinResult;

import java.util.List;

public class OutputUtil {
    public static final String TOTALMONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String MANUALLOTTOCOUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String MANUALLOTTONUMS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    public static final String WINNUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String BONUSBALL_MESSAGE = "보너스 볼을 입력해 주세요.";

    public static void informBuyLottosCount(Buyer buyer) {
        System.out.println("수동으로 " + buyer.getManualLottoCount() + "장, 자동으로 " + buyer.getAutoLottoCount() + "장을 구매했습니다.");
    }

    public static void informBuyLottoNums(List<Lotto> buyLottos) {
        buyLottos.stream().forEach(System.out::println);
    }

    public static void informWinStatistics(WinResult winResult) {
        System.out.println(winResult);
    }
}
