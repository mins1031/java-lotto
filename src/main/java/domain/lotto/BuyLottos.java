package domain.lotto;

import domain.parser.StringParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BuyLottos {
    private List<Lotto> lottoNums = new ArrayList<>();

    public void saveManualLottoNums(List<String> rawManualLottoNums) {
        List<Lotto> manualLottos = new ArrayList<>();
        for (String rawManualLottoNum : rawManualLottoNums) {
            Lotto lotto = new Lotto();
            lotto.addAll(StringParser.parseInputLottoNums(rawManualLottoNum).stream()
                    .map(raw -> LottoNums.getLottoNumList().get(raw))
                    .collect(Collectors.toList()));
            manualLottos.add(lotto);
        }
        lottoNums.addAll(manualLottos);
    }

    public List<Lotto> getLottoNums() {
        return lottoNums;
    }
}
