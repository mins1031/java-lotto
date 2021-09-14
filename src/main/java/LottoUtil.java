import domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoUtil {

    public static List<LottoNumber> lottoNumberParser(List<String> lottoInputList){
        List<LottoNumber> lottoList = new ArrayList<>();

        for (String lottoInput : lottoInputList) {
            LottoNumber lotto = new LottoNumber();

            for (String splitNum : lottoInput.split(", ")) {
                lotto.add(Integer.parseInt(splitNum));
            }
            lottoList.add(lotto);
        }

        return lottoList;
    }

//    public static List<LottoNumber> manualNumParser (List<String> manualList) {
//        List<LottoNumber> result = new ArrayList<>();
//
//        for (String manual : manualList) {
//            LottoNumber lotto = new LottoNumber();
//            lotto.addManual(manual.split(", "));
//            result.add(lotto);
//        }
//
//        return result;
//    }
}
