package domain.lotto.lottogenerate;

import domain.Buyer;
import domain.lotto.Lotto;
import domain.lotto.LottoNum;
import domain.lotto.LottoNums;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.stream.Collectors;

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
        TreeSet<Integer> treeSet = new TreeSet<>();

        while (treeSet.size() != 6) {
            treeSet.add(LottoNums.getLottoNumList().get(random.nextInt(45) + 1).getNum());
        }

        return treeSet.stream()
                .map(raw -> LottoNums.getLottoNumList().get(raw))
                .collect(Collectors.toList());
    }
}
