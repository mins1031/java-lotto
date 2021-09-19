package lotto.domain.lottogenerator;

import lotto.domain.gambler.Gambler;
import lotto.domain.lotto.Lotto;

import java.util.List;

public interface LottoGenerator {
    List<Lotto> generate(Gambler gambler);
}
