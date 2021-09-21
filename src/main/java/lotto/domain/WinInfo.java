package lotto.domain;

import lotto.domain.lottos.LottoGame;
import lotto.domain.lottos.LottoNo;
import lotto.domain.lottos.LottoNumbers;
import lotto.scanner.InputScanner;

import java.util.List;

public class WinInfo {

    private LottoGame winNumbers = new LottoGame();
    private LottoNo bonusBall;

    public WinInfo() {
    }

    public void inputWinNumbers(String message) {
        System.out.println(message);
        int winNumCount = 1;
        List<LottoGame> lottoGames = InputScanner.userLottoInput(winNumCount);
        winNumbers.addAll(lottoGames.get(0).getNumbers());
    }

    public void inputBonusBall(String message) {
        int tempBonusBall = InputScanner.userNumberInput(message);
        if (winNumbers.getNumbers().contains(tempBonusBall)){
            throw new IllegalArgumentException("보너스 볼이 당첨번호와 중복됩니다.");
        }
        if (tempBonusBall < 1 || tempBonusBall > 45){
            throw new IllegalArgumentException("보너스 볼은 1~45 사이의 수여야 합니다.");
        }

        int realBonusBall = LottoNumbers.getInstance().get(tempBonusBall - 1).getNumber();
        bonusBall = new LottoNo(realBonusBall);
    }

    public LottoGame getWinNumbers() {
        return winNumbers;
    }

    public LottoNo getBonusBall() {
        return bonusBall;
    }

    public void setWinNumbers(LottoGame winNumbers) {
        this.winNumbers = winNumbers;
    }

    public void setBonusBall(LottoNo bonusBall) {
        this.bonusBall = bonusBall;
    }
}
