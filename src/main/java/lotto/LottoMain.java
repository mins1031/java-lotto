package lotto;

import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.Lotto;
import lotto.scanner.InputScanner;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        Money money = Money.from(InputScanner.inputNumeric("구매 금액을 입력해주세요."));
        int manualLotto = InputScanner.inputNumeric("수동으로 구매할 로또 수를 입력해주세요.");

        Lotto lotto = Lotto.of(money, manualLotto);

        List<String> manualLottoInputs = InputScanner.inputStrings("수동으로 구매할 번호를 입력해 주세요.", manualLotto);
        lotto.buyLottoManual(manualLottoInputs);
        lotto.buyLottoAutomatic();

        lotto.print();

        String winningLottoInput = InputScanner.inputString("지난 주 당첨 번호를 입력해 주세요.");
        int bonusBall = InputScanner.inputNumeric("보너스 볼을 입력해 주세요.");

        LottoResult result = LottoResult.of(lotto, winningLottoInput, bonusBall);
        result.print();
    }
}
