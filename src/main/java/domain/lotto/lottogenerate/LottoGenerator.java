package domain.lotto.lottogenerate;

import domain.Buyer;
import domain.lotto.Lotto;

import java.util.List;

public interface LottoGenerator {
    List<Lotto> generate(Buyer buyer);
}
