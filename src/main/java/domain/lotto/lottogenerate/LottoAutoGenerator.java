package domain.lotto.lottogenerate;

import domain.Buyer;
import domain.lotto.Lotto;
import domain.lotto.LottoFront;
import domain.lotto.LottoNum;
import domain.lotto.LottoNums;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoAutoGenerator implements LottoGenerator {
    @Override
    public List<Lotto> generate(Buyer buyer) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < buyer.getAutoLottoCount(); i++) {
            Lotto lotto = new Lotto();
            lotto.getLotto().addAll(getRandomNums());
            lottos.add(lotto);
        }

        return lottos;
    }

    private List<LottoNum> getRandomNums() {
        Random random = new Random();
        List<LottoNum> randomNums = new ArrayList<>();
        for (int i = 0; i < LottoFront.LOTTOS_SIZE; i++) {
            randomNums.add(LottoNums.getLottoNumList().get(random.nextInt(45) + 1));
        }
        return randomNums;
    }
}
