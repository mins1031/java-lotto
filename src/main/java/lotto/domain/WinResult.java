package lotto.domain;

public class WinResult {

    private int threeMatchCount = 0;
    private int fourMatchCount = 0;
    private int fiveMatchCount = 0;
    private int fiveAndBonusMatchCount = 0;
    private int sixMatchCount = 0;

    public void distributeMatchCnt(int matchCnt, int bonusCnt){
        if (matchCnt == 3){
            this.threeMatchCount++;
        } else if (matchCnt == 4){
            this.fourMatchCount++;
        } else if (matchCnt == 5){
            if (bonusCnt == 1){
                this.fiveAndBonusMatchCount++;
            } else {
                this.fiveMatchCount++;
            }
        } else if (matchCnt == 6){
            this.sixMatchCount++;
        }
    }

    public int getThreeMatchCount() {
        return threeMatchCount;
    }

    public int getFourMatchCount() {
        return fourMatchCount;
    }

    public int getFiveMatchCount() {
        return fiveMatchCount;
    }

    public int getFiveAndBonusMatchCount() {
        return fiveAndBonusMatchCount;
    }

    public int getSixMatchCount() {
        return sixMatchCount;
    }

}
