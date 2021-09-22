package lotto.domain.lottos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private static final List<LottoNumber> lottoNumbers = initLottoNumbers();

    private static List<LottoNumber> initLottoNumbers() {
        List<LottoNumber> initList = new ArrayList<>();

        for (int i = 1; i< 46; i++){
            initList.add(LottoNumber.from(i));
        }

        return Collections.unmodifiableList(initList);
    }

    public static List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
