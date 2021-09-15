package lotto.domain.lottogenerator;

import lotto.domain.Customer;
import lotto.domain.Lotto;

import java.util.List;

public class LottoGame {
    private Customer customer;
    private LottoGenerator lottoGenerator;

    public LottoGame(Customer customer, LottoGenerator lottoGenerator) {
        this.customer = customer;
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> lottoGenerate() {
        return lottoGenerator.generator(customer);
    }
}
