import domain.LottoNumber;

import java.util.*;

public class LottoUtil {

    public static LottoNumber lottoNumberParser(String lottoInput){
        LottoNumber lotto = new LottoNumber();

        for (String splitNum : lottoInput.split(", ")) {
            lotto.add(Integer.parseInt(splitNum));
        }

        return lotto;
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
        Set<Integer> tempSet = new TreeSet<>();

        while(tempSet.size() != 6) {
            tempSet.add(new Random().nextInt(45) + 1);
        }

        List<Integer> nonDupList = new ArrayList<>(tempSet);

        return nonDupList;
    }

}
