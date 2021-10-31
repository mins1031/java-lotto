package domain.rank;

public enum Ranking {
    FIRST(1,6, false),
    SECOND(2,5, true),
    THIRD(3,5, false),
    FOURTH(4,4, false),
    FIVETH(5,3, false);

    private int rank;
    private int matchCount;
    private boolean bonusBall;

    Ranking(int rank, int matchCount, boolean bonusBall) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.bonusBall = bonusBall;
    }
}
