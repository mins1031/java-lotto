package domain.lotto;

import domain.parser.StringParser;
import exception.lotto.InputLottoNumsException;

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

    public static List<LottoNum> toLottoNum(String rawManualLottoNum) {
        TreeSet<Integer> treeSet = new TreeSet<>(StringParser.parseInputLottoNums(rawManualLottoNum));
        if (treeSet.size() != 6) {
            throw new InputLottoNumsException();
        }
        return treeSet.stream()
                .map(raw -> LottoNums.getLottoNumList().get(raw))
                .collect(Collectors.toList());
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
