package lotto.domain.winlotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNo;
import lotto.domain.result.Rank;

import java.util.List;
import java.util.stream.Collectors;

public class WinLotto {
    private static final String ERROR_MESSAGE_NOT_INTEGER = "숫자가 아닌 문자를 입력하였습니다.";
    private static final String ERROR_MESSAGE_BONUS_OVERLAP = "당첨번호에 보너스볼이 포함되어 있습니다.";

    private final Lotto winLotto;
    private final BonusBall bonusBall;

    private WinLotto(Lotto winLotto, BonusBall bonusBall) {
        this.winLotto = winLotto;
        this.bonusBall = bonusBall;
    }

    public static WinLotto of(List<String> winLottos, String bonusBall) {
        if (winLottos.contains(bonusBall)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_BONUS_OVERLAP);
        }
        Lotto winLotto = Lotto.of(toLottoNos(winLottos));
        return new WinLotto(winLotto, BonusBall.of(bonusBall));
    }

    private static List<LottoNo> toLottoNos(List<String> winLotto) {
        try {
            return winLotto.stream()
                    .map(Integer::parseInt)
                    .map(LottoNo::toLottoNo)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_INTEGER);
        }
    }

    public Rank findRank(Lotto lotto) {
        int calculateHitCount = lotto.calculateHitCount(winLotto);
        boolean matchBonus = lotto.contains(bonusBall.getBonusBall());
        return Rank.findRank(calculateHitCount, matchBonus);
    }

    public Lotto getWinLotto() {
        return winLotto;
    }

    public BonusBall getBonusBall() {
        return bonusBall;
    }
}
