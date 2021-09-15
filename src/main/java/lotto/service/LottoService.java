package lotto.service;

import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.WinLotto;
import lotto.domain.lottogenerator.LottoGame;
import lotto.domain.lottogenerator.LottoGenerator;
import lotto.util.StringUtils;
import lotto.view.InputView;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    private final List<LottoGenerator> lottoGenerators;

    public LottoService(List<LottoGenerator> lottoGenerators) {
        this.lottoGenerators = lottoGenerators;
    }

    public List<Lotto> createUserLottos(Customer customer) {
        return lottoGenerators.stream()
                .map(lottoGenerator -> new LottoGame(customer, lottoGenerator).lottoGenerate())
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public WinLotto createWinLotto() {
        String[] inputWinNumbers = StringUtils.splitByComma(InputView.inputWinNumber());
        return new WinLotto(inputWinNumbers, InputView.inputBonusBall());
    }
}
