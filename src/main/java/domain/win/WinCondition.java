package domain.win;

import domain.lotto.LottoNum;
import exception.win.DuplicateBonusBallWithWinNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WinCondition {
    private List<LottoNum> winNumbers = new ArrayList<>();
    private int bonusBall = 0;

    public WinCondition(List<LottoNum> winNumbers, int bonusBall) {
        verifyBonusBall(winNumbers, bonusBall);
        this.winNumbers = winNumbers;
        this.bonusBall = bonusBall;
    }

    private void verifyBonusBall(List<LottoNum> winNumbers, int bonusBall) {
        Optional<LottoNum> verifyResult = winNumbers.stream().filter(winNumber -> winNumber.getNum() == bonusBall).findAny();
        if (verifyResult.isPresent()) {
            throw new DuplicateBonusBallWithWinNumbers();
        }
    }

    public List<LottoNum> getWinNumbers() {
        return winNumbers;
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
