package domain.rank;

import domain.lotto.Lotto;
import domain.lotto.LottoNum;

import java.util.Arrays;
import java.util.List;

public enum Ranking {
    FIRST(2000000000, 6, false),
    SECOND(30000000, 5, true),
    THIRD(1500000, 5, false),
    FOURTH(50000, 4, false),
    FIVTH(5000, 3, false);

    private int prize;
    private int matchCount;
    private boolean bonusBall;

    Ranking(int prize, int matchCount, boolean bonusBall) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.bonusBall = bonusBall;
    }

    public static Ranking compareMatchCountAndBonusBall(List<LottoNum> winnums, int bonusBall, Lotto compareLotto) {
        long matchCount = winnums.stream()
                .filter(winnum -> compareLotto.getLotto().contains(winnum))
                .count();
        boolean bonusBallResult = compareLotto.getLotto().contains((LottoNum.of(bonusBall)));

        return arrangeRanking(matchCount, bonusBallResult);
    }

    private static Ranking arrangeRanking(long matchCount, boolean bonusBallResult) {
        if (matchCount < 3) {
            return null;
        }
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.matchCount == matchCount && ranking.bonusBall == bonusBallResult)
                .findAny().orElse(null);
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusBall() {
        return bonusBall;
    }
}
