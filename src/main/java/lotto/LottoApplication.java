package lotto;

import lotto.controller.LottoController;
import lotto.domain.lottogenerator.LottoGeneratorAuto;
import lotto.domain.lottogenerator.LottoGeneratorManual;
import lotto.service.LottoService;

import java.util.Arrays;

public class LottoApplication {

    public static void main(String[] args) {
        LottoService lottoService = new LottoService(Arrays.asList(new LottoGeneratorManual(), new LottoGeneratorAuto()));
        LottoController lottoController = new LottoController(lottoService);
        lottoController.run();
    }
}
