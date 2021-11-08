package domain.lotto.lottogenerate;

import domain.Buyer;
import domain.lotto.Lotto;
import scanner.InputUtil;

import java.util.ArrayList;
import java.util.List;

public class LottoManualGenerator implements LottoGenerator {
    @Override
    public List<Lotto> generate(Buyer buyer) {
        List<String> rawManualLottoNums = InputUtil.inputManualLottoNums(buyer.getManualLottoCount());
        List<Lotto> manualLottos = new ArrayList<>();

        for (String rawManualLottoNum : rawManualLottoNums) {
            Lotto lotto = new Lotto();
            lotto.addAll(Lotto.toLottoNum(rawManualLottoNum));
            manualLottos.add(lotto);
        }
        return manualLottos;
    }
}
