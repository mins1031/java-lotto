package domain.lotto;

import domain.parser.StringParser;
import exception.lotto.InputLottoNumsException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoFront {
    private List<Lotto> lottos = new ArrayList<>();
    public static final int LOTTOS_SIZE = 6;
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
        TreeSet<Integer> treeSet = new TreeSet<>(StringParser.parseInputLottoNums(rawManualLottoNum));
        if (treeSet.size() != 6) {
            throw new InputLottoNumsException();
        }
        return treeSet.stream()
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
