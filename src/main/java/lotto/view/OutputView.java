package lotto.view;

import lotto.domain.gambler.BettingMoney;
import lotto.domain.gambler.Gambler;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.result.LottoResult;
import lotto.util.StringUtils;

public class OutputView {
    private static final String INCOME_RATE_MESSAGE_FORMAT = "총 수익률은 %d %s 입니다.";
    private static final String BUY_MESSAGE_FORMAT = "수동으로 %d개, 자동으로 %d개를 구매했습니다";
    private static final String PERCENT = "%";

    public static void printLottos(Lottos lottos) {
        StringBuilder builder = new StringBuilder();
        for (Lotto lotto : lottos.getLottos()) {
            builder.append(lotto).append(StringUtils.LINE_SEPARATOR);
        }
        System.out.println(builder);
    }

    public static void printLottoAmounts(Gambler gambler) {
        System.out.println(String.format(BUY_MESSAGE_FORMAT, gambler.calculateManualLottoCount(), gambler.calculateAutoLottoCount()));
    }

    public static void printResult(BettingMoney bettingMoney, LottoResult lottoResult) {
        System.out.println(lottoResult.toString());

        long totalReward = lottoResult.calculateTotalReward();
        System.out.println(String.format(INCOME_RATE_MESSAGE_FORMAT, bettingMoney.calculateIncomeRate(totalReward), PERCENT));
    }
}
