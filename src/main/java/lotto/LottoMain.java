package lotto;

import lotto.domain.Money;
import lotto.domain.lottos.Lotto;
import lotto.domain.lottos.LottoGame;
import lotto.scanner.InputScanner;
import lotto.util.LottoUtils;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        // 구매 금액 입력 및 저장
        Money money = Money.from(InputScanner.inputNumeric("구매 금액을 입력해주세요."));

        // 수동 구매 매수 입력 및 저장
        int manualLotto = InputScanner.inputNumeric("수동으로 구매할 로또 수를 입력해주세요.");

        // 로또 생성
        Lotto lotto = Lotto.of(money, manualLotto);

        // 수동 구매 번호 입력 및 저장
        List<String> lineInputs = InputScanner.inputStrings("수동으로 구매할 번호를 입력해 주세요.", manualLotto);

        // 수동 자동 로또 생성
        List<LottoGame> manual = LottoUtils.createManualLottoList(lineInputs);
        List<LottoGame> auto = LottoUtils.createAutoLottoList(lotto.getAutoLotto());



//        // 로또 출력
//        lotto.print();
//
//        // 당첨번호 및 보너스 볼
//        WinResult.inputWinNumbers("지난 주 당첨 번호를 입력해 주세요.");
//        WinResult.inputBonusBall("보너스 볼을 입력해 주세요.");

    }
}
