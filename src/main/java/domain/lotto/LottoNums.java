package domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNums {
    private static final List<LottoNum> LOTTO_NUM_LIST = new ArrayList<>();

    static {
        LOTTO_NUM_LIST.add(null);
        for (int i = 1; i < 46; i++) {
            LOTTO_NUM_LIST.add(LottoNum.of(i));
        }
    }

    private LottoNums() {
    }

    public static List<LottoNum> getLottoNumList() {
        return LOTTO_NUM_LIST;
    }
}
