package domain.lotto;

import domain.Buyer;
import domain.lotto.lottogenerate.LottoAutoGenerator;
import domain.lotto.lottogenerate.LottoGenerator;
import domain.lotto.lottogenerate.LottoManualGenerator;

import java.util.Arrays;
import java.util.List;

public class LottoMarket {
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    private static List<LottoGenerator> lottoGenerators = Arrays.asList(new LottoManualGenerator(), new LottoAutoGenerator());

    public static void generateLottos(Buyer buyer) {
        lottoGenerators.stream().forEach(generator -> buyer.getBuyLottos().addAll(generator.generate(buyer)));
    }
}
