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
        Random random = new Random();
        Set<Integer> temp = new HashSet<>();
        for (int i = 0 ; i < autoLottoCount; i++){
            LottoNumber lottoNumber = new LottoNumber();

            for (Integer integer : getRandomNumList()) {
                lottoNumber.add(integer);
            }

            /*for (int j = 0; j < 6; j++){
                lottoNumber.add(random.nextInt(45)+1);
            }*/
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
        //Collections.sort(nonDupList);

        return nonDupList;
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
