package lotto;

import lotto.controller.LottoController;
import lotto.domain.lottogenerator.LottoGenerator;
import lotto.domain.lottogenerator.LottoGeneratorAuto;
import lotto.domain.lottogenerator.LottoGeneratorManual;
import lotto.service.LottoFactoryService;

import java.util.Arrays;
import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        List<LottoGenerator> lottoGenerators = Arrays.asList(
                new LottoGeneratorManual(),
                new LottoGeneratorAuto()
        );
        LottoFactoryService lottoFactoryService = new LottoFactoryService(lottoGenerators);
        LottoController lottoController = new LottoController(lottoFactoryService);
        lottoController.run();
    }
}
