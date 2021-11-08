package scanner;

import domain.Buyer;
import domain.lotto.Lotto;
import domain.rank.Ranking;
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
        System.out.println(
                "당첨 통계 \n" +
                "--------- \n" +
                "3개 일치 (" + Ranking.FIVTH.getPrize() + ")- " + winResult.getCount(Ranking.FIVTH) + "개\n" +
                "4개 일치 (" + Ranking.FOURTH.getPrize() + ")- " + winResult.getCount(Ranking.FOURTH) + "개\n" +
                "5개 일치 (" + Ranking.THIRD.getPrize() + ")- " + winResult.getCount(Ranking.THIRD) + "개\n" +
                "5개, 보너스볼 일치 (" + Ranking.SECOND.getPrize() + ")- " + winResult.getCount(Ranking.SECOND) + "개\n" +
                "6개 일치 (" + Ranking.FIRST.getPrize() + ")- " + winResult.getCount(Ranking.FIRST) + "개\n" +
                "총 수익률은 " + winResult.getProfitRate() + "입니다."
        );
    }
}
