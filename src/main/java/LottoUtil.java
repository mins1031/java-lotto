import domain.LottoNumber;

import java.util.*;

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

    public static List<LottoNumber> autoNumCreate(int autoLottoCount) {
        List<LottoNumber> autoLottoList = new ArrayList<>();

        for (int i = 0 ; i < autoLottoCount; i++){
            LottoNumber lottoNumber = new LottoNumber();
            List<Integer> autoNumbers = getRandomNumList();

            for (Integer integer : autoNumbers) {
                lottoNumber.add(integer);
            }
            autoLottoList.add(lottoNumber);
        }
        return autoLottoList;
    }

    public static List<Integer> getRandomNumList() {
        Set<Integer> temp = new TreeSet<>();

        while(temp.size() != 6) {
            temp.add(new Random().nextInt(45) + 1);
        }

        List<Integer> nonDupList = new ArrayList<>(temp);

        return nonDupList;
    }

}
