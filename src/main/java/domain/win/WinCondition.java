package domain.win;

import domain.bonusball.BonusBall;
import domain.lotto.LottoNum;
import exception.win.DuplicateBonusBallWithWinNumbers;

import java.util.ArrayList;
import java.util.List;

public class WinCondition {
    private List<LottoNum> winNumbers = new ArrayList<>();
    private BonusBall bonusBall;

    public WinCondition(List<LottoNum> winNumbers, BonusBall bonusBall) {
        verifyBonusBall(winNumbers, bonusBall);
        this.winNumbers = winNumbers;
        this.bonusBall = bonusBall;
    }

    private void verifyBonusBall(List<LottoNum> winNumbers, BonusBall bonusBall) {
        if (winNumbers.contains(LottoNum.of(bonusBall.getBonusBallNum()))) {
            throw new DuplicateBonusBallWithWinNumbers();
        }
    }

    public List<LottoNum> getWinNumbers() {
        return winNumbers;
    }

    public BonusBall getBonusBall() {
        return bonusBall;
    }
}
