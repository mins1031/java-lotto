package lotto.domain.result;

import java.util.Arrays;

public enum Rank {
    SIXTH(2000, 2),
    FIFTH(5000, 3),
    FOURTH(50000, 4),
    THIRD(1500000, 5),
    SECOND(30000000, 5),
    FIRST(2000000000, 6);

    private static final String MESSAGE_NOT_FOUND_RANK = "당첨되지 않았습니다.";
    public static final int MIN_WIN_COUNT = 3;

    private final Long reward;
    private final int hitCount;

    Rank(long reward, int hitCount) {
        this.reward = reward;
        this.hitCount = hitCount;
    }

    public static Rank findRank(int count, boolean bonus) {
        Rank rank = Arrays.stream(values())
                .filter(x -> x.hitCount == count)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(MESSAGE_NOT_FOUND_RANK));
        return rank.checkSecondOrNot(bonus);
    }

    private Rank checkSecondOrNot(boolean bonus) {
        if (this.equals(THIRD) && bonus) {
            return SECOND;
        }
        return this;
    }

    public long getReward() {
        return reward;
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%d원) ", hitCount, reward);
    }
}
