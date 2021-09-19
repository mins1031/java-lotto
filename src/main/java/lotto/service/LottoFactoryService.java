package lotto.service;

import lotto.domain.gambler.Gambler;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.Lotto;
import lotto.domain.lottogenerator.LottoGenerator;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class LottoFactoryService {
    private final List<LottoGenerator> lottoGenerators;

    public LottoFactoryService(List<LottoGenerator> lottoGenerators) {
        this.lottoGenerators = lottoGenerators;
    }

    public Lottos createLottos(Gambler gambler) {
        List<Lotto> lottos = lottoGenerators.stream()
                .map(lottoGenerator -> lottoGenerator.generate(gambler))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }
}
