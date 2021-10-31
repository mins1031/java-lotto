package domain.lotto;

import domain.parser.StringParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LottoMarket {
    private List<Lotto> lottos = new ArrayList<>();
    private static final int LOTTOS_SIZE = 6;
    public static final int LOTTO_PRICE = 1000;

    public List<Lotto> saveManualLottoNums(List<String> rawManualLottoNums) {
        List<Lotto> manualLottos = new ArrayList<>();
        for (String rawManualLottoNum : rawManualLottoNums) {
            Lotto lotto = new Lotto();
            lotto.addAll(toLottoNum(rawManualLottoNum));
            manualLottos.add(lotto);
        }
        lottos.addAll(manualLottos);
        return manualLottos;
    }

    public List<LottoNum> toLottoNum(String rawManualLottoNum) {
        return StringParser.parseInputLottoNums(rawManualLottoNum).stream()
                .map(raw -> LottoNums.getLottoNumList().get(raw))
                .collect(Collectors.toList());
    }

    public void generateAutoLottos(int autoLottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < autoLottoCount; i++) {
            Lotto lotto = new Lotto();
            lotto.getLotto().addAll(getRandomNums());
            lottos.add(lotto);
        }
        this.lottos.addAll(lottos);
    }

    private List<LottoNum> getRandomNums() {
        Random random = new Random();
        List<LottoNum> randomNums = new ArrayList<>();
        for (int i = 0; i < LOTTOS_SIZE; i++) {
            randomNums.add(LottoNums.getLottoNumList().get(random.nextInt(45) + 1));
        }
        return randomNums;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
