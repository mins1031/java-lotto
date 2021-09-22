package lotto.domain;

import lotto.domain.lottos.LottoGame;
import lotto.domain.lottos.LottoNumber;
import lotto.domain.lottos.LottoNumbers;
import lotto.scanner.InputScanner;

import java.util.List;

public class WinResult {

//    private static LottoGame winNumbers = new LottoGame();
//    private static LottoNumber bonusBall;
//
//    public static void inputWinNumbers(String message) {
//        System.out.println(message);
//        int winNumCount = 1;
//        List<LottoGame> lottoGames = InputScanner.userLottoInput(winNumCount);
//        winNumbers.addAll(lottoGames.get(0).getNumbers());
//    }
//
//    public static void inputBonusBall(String message) {
//        int tempBonusBall = InputScanner.userNumberInput(message);
//        if (winNumbers.getNumbers().contains(tempBonusBall)){
//            throw new IllegalArgumentException("보너스 볼이 당첨번호와 중복됩니다.");
//        }
//        if (tempBonusBall < 1 || tempBonusBall > 45){
//            throw new IllegalArgumentException("보너스 볼은 1~45 사이의 수여야 합니다.");
//        }
//
//        bonusBall = LottoNumbers.getLottoNumbers().get(tempBonusBall - 1);
//    }

}
