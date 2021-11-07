package domain.lotto;

import domain.parser.StringParser;
import exception.lotto.WrongInputNumsException;
import exception.lotto.OutsideInputNumException;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoNum {
    private final int num;

    private LottoNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public static LottoNum of(int num) {
        return new LottoNum(num);
    }

    public static List<LottoNum> toLottoNum(String rawManualLottoNum) {
        TreeSet<Integer> treeSet = new TreeSet<>(StringParser.parseInputLottoNums(rawManualLottoNum));
        verifyLottoNum(treeSet);

        return treeSet.stream()
                .map(raw -> LottoNums.getLottoNumList().get(raw))
                .collect(Collectors.toList());
    }

    private static void verifyLottoNum(TreeSet<Integer> treeSet) {
        if (treeSet.size() != 6) {
            throw new WrongInputNumsException();
        }

        if (treeSet.stream().filter(num -> num > 45 || num < 1).findAny().isPresent()) {
            throw new OutsideInputNumException();
        }
    }
}
