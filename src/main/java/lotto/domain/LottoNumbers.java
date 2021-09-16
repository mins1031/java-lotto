package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    private static List<LottoNo> lottoNumberList = new ArrayList<>();

    private static void init(){
        for (int i = 1; i< 46; i++){
            lottoNumberList.add(new LottoNo(i));
        }
    }

    public static List<LottoNo> getInstance(){
        if (lottoNumberList.size() == 0) {
            init();
        }

        return lottoNumberList;
    }
}
