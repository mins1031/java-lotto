package lotto;

import lotto.domain.*;
import lotto.lottoUtils.LottoUtils;
import lotto.scanner.InputScanner;

import java.util.Arrays;
import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        Money money = Money.from(InputScanner.inputNumeric("구매 금액을 입력해주세요."));
        int manualLottoCount = InputScanner.inputNumeric("수동으로 구매할 로또 수를 입력해주세요.");
        List<String> manualLottoInputs = InputScanner.inputStrings("수동으로 구매할 번호를 입력해 주세요.", manualLottoCount);

        Customer customer = Customer.of(money, manualLottoInputs);
        List<LottoGenerator> lottoGenerators = Arrays.asList(
                new LottoGeneratorManual(customer),
                new LottoGeneratorAuto(customer)
        );

        LottoUtils.printLotto(lottoGenerators);

        String winLottoInput = InputScanner.inputString("지난 주 당첨 번호를 입력해 주세요.");
        int bonusBall = InputScanner.inputNumeric("보너스 볼을 입력해 주세요.");

        WinLotto winLotto = WinLotto.of(Lotto.parseLottoNumber(winLottoInput), LottoNumbers.getNumber(bonusBall));
        LottoResult lottoResult = LottoResult.of(lottoGenerators, winLotto);


    }
}
