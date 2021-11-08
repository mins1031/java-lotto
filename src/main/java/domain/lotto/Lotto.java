package domain.lotto;

import domain.parser.StringParser;
import exception.lotto.OutsideInputNumException;
import exception.lotto.WrongInputNumsException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {
    private List<LottoNum> lotto = new ArrayList<>();
    public static final int LOTTO_SIZE = 6;

    public List<LottoNum> getLotto() {
        return lotto;
    }

    public void addAll(List<LottoNum> lottoNums) {
        lotto.addAll(lottoNums);
    }

    public static List<LottoNum> toLottoNum(String rawLottoNum) {
        TreeSet<Integer> treeSet = new TreeSet<>(StringParser.parseInputLottoNums(rawLottoNum));
        verifyLottoNum(treeSet);

        return treeSet.stream()
                .map(raw -> LottoNums.getLottoNumList().get(raw))
                .collect(Collectors.toList());
    }

    private static void verifyLottoNum(TreeSet<Integer> treeSet) {
        if (treeSet.size() != LOTTO_SIZE) {
            throw new WrongInputNumsException();
        }

        if (treeSet.stream().filter(num -> num > LottoMarket.LOTTO_MAX_NUMBER || num < LottoMarket.LOTTO_MIN_NUMBER).findAny().isPresent()) {
            throw new OutsideInputNumException();
        }
    }

    @Override
    public String toString() {
        return "[" +
                lotto.get(0).getNum() + ", " +
                lotto.get(1).getNum() + ", " +
                lotto.get(2).getNum() + ", " +
                lotto.get(3).getNum() + ", " +
                lotto.get(4).getNum() + ", " +
                lotto.get(5).getNum() + "]"
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
