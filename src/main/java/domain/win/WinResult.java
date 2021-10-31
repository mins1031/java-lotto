package domain.win;

import domain.lotto.Lotto;

import java.util.List;

public class WinResult {
    private int firstCount = 0;
    private int secondCount = 0;
    private int thirdCount = 0;
    private int fourthCount = 0;
    private int fivethCount = 0;

    public void matchWinCount(WinCondition winCondition, List<Lotto> lottos) {

    }

    public int getFirstCount() {
        return firstCount;
    }

    public int getSecondCount() {
        return secondCount;
    }

    public int getThirdCount() {
        return thirdCount;
    }

    public int getFourthCount() {
        return fourthCount;
    }

    public int getFivethCount() {
        return fivethCount;
    }
}
