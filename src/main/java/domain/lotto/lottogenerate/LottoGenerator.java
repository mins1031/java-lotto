package domain.lotto.lottogenerate;

import domain.lotto.Lotto;

import java.util.List;

public interface LottoGenerator {
    List<Lotto> generate(int generateCount);
}
