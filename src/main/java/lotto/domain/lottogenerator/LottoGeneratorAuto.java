package lotto.domain.lottogenerator;

import lotto.domain.gambler.Gambler;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.lotto.LottoNo.lottoNoBox;


public class LottoGeneratorAuto implements LottoGenerator {
    private static final int LOTTO_NO_PICK_FROM_INDEX = 0;

    @Override
    public List<Lotto> generate(Gambler gambler) {
        return IntStream.range(0, gambler.calculateAutoLottoCount())
                .mapToObj(count -> createLottoAuto())
                .collect(Collectors.toList());
    }

    private static Lotto createLottoAuto() {
        List<LottoNo> lotto = new ArrayList<>(pickSixRandomNo());
        return Lotto.of(lotto);
    }

    private static List<LottoNo> pickSixRandomNo() {
        List<LottoNo> lotto = new ArrayList<>(lottoNoBox.values());
        Collections.shuffle(lotto);
        lotto = lotto.subList(LOTTO_NO_PICK_FROM_INDEX, Lotto.LOTTO_SIZE);
        return lotto;
    }
}
