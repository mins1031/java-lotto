package lotto.domain;

public enum Rank {
    FIRST(2_000_000_000, 0),
    SECOND(30_000_000, 1),
    THIRD(1_500_000, 2),
    FOURTH(50_000, 3),
    FIFTH(5_000, 4);

    private int prize;
    private int code;

    Rank(int prize, int code) {
        this.prize = prize;
        this.code = code;
    }

    public int getPrize() {
        return prize;
    }

    public int getCode() {
        return code;
    }
}
