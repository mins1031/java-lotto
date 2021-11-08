package domain.lotto;

import domain.parser.StringParser;
import exception.lotto.WrongInputNumsException;
import exception.lotto.OutsideInputNumException;

import java.util.List;
import java.util.Objects;
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

    public static List<LottoNum> toLottoNum(String rawLottoNum) {
        TreeSet<Integer> treeSet = new TreeSet<>(StringParser.parseInputLottoNums(rawLottoNum));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNum lottoNum = (LottoNum) o;
        return num == lottoNum.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
