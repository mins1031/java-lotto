package lotto.controller;

import lotto.domain.Customer;
import lotto.domain.LottoManager;
import lotto.domain.Lottos;
import lotto.domain.WinLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        int money = InputView.inputMoney();
        int manualLottoCount = InputView.inputManualLottoCount();
        Customer customer = new Customer(money, manualLottoCount);

        String manualLottoNumbers = InputView.inputManualLottoNumbers(customer);
        customer.setManualLottoNumbers(manualLottoNumbers);

        Lottos lottos = new Lottos(lottoService.createUserLottos(customer));

        printLottos(customer, lottos);

        WinLotto winLotto = lottoService.createWinLotto();
        LottoManager lottoManager = new LottoManager(lottos, winLotto);
        lottoManager.checkLotto();
        OutputView.printResult(customer, lottoManager);
    }

    private void printLottos(Customer customer, Lottos lottos) {
        OutputView.printLottoAmounts(customer);
        OutputView.printLottos(lottos);
    }
}
