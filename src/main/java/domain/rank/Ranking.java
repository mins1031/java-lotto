package domain.rank;

import domain.lotto.Lotto;
import domain.win.WinCondition;

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

    public static Ranking findRank(Lotto lotto, WinCondition winCondition) {
    }
}
