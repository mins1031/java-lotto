package lotto.controller;

import lotto.domain.gambler.BettingMoney;
import lotto.domain.gambler.Gambler;
import lotto.domain.lotto.Lottos;
import lotto.domain.result.LottoResult;
import lotto.domain.winlotto.WinLotto;
import lotto.service.LottoFactoryService;
import lotto.util.StringUtils;
import lotto.validator.ManualLottoCountValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class LottoController {
    private final LottoFactoryService lottoFactoryService;

    public LottoController(LottoFactoryService lottoFactoryService) {
        this.lottoFactoryService = lottoFactoryService;
    }

    public void run() {
        Gambler gambler = makeGambler();
        Lottos lottos = lottoFactoryService.createLottos(gambler);

        OutputView.printLottoAmounts(gambler);
        OutputView.printLottos(lottos);

        WinLotto winLotto = makeWinLotto();

        LottoResult lottoResult = lottos.checkResult(winLotto);

        OutputView.printResult(gambler.getBettingMoney(), lottoResult);
    }

    private Gambler makeGambler() {
        int money = InputView.inputMoney();
        BettingMoney bettingMoney = BettingMoney.of(money);

        int manualLottoCount = InputView.inputManualLottoCount();
        ManualLottoCountValidator.validate(bettingMoney.getBettingMoney(), manualLottoCount);

        List<String> manualLottoNumberBundles = InputView.inputManualLottoNumbers(manualLottoCount);

        return new Gambler(bettingMoney, manualLottoNumberBundles);
    }

    private WinLotto makeWinLotto() {
        String inputWinNumber = InputView.inputWinNumber();
        String bonusBall = InputView.inputBonusBall();
        List<String> inputWinNumbers = Arrays.asList(StringUtils.splitByComma(inputWinNumber));
        return WinLotto.of(inputWinNumbers, bonusBall);
    }
}
