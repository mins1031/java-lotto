package domain.lotto.lottogenerate;

import domain.Buyer;
import domain.lotto.Lotto;
import domain.lotto.LottoNum;
import domain.lotto.LottoNums;
import domain.parser.StringParser;
import exception.lotto.InputLottoNumsException;
import scanner.InputUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoManualGenerator implements LottoGenerator{
    @Override
    public List<Lotto> generate(Buyer buyer) {
        List<String> rawManualLottoNums = InputUtil.inputManualLottoNums(buyer.getManualLottoCount());
        List<Lotto> manualLottos = new ArrayList<>();

        for (String rawManualLottoNum : rawManualLottoNums) {
            Lotto lotto = new Lotto();
            lotto.addAll(toLottoNum(rawManualLottoNum));
            manualLottos.add(lotto);
        }

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
}
