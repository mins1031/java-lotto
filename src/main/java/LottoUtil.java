import domain.Lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoUtil {

    public static List<Integer> lottoNumberParser(String lottoInput){
        List<Integer> lotto = Stream.of(lottoInput.split("\\s*,\\s*"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return lotto;
    }

//    public static List<Lotto> autoNumCreate(int autoLottoCount) {
//        List<Lotto> autoLottoList = new ArrayList<>();
//
//        for (int i = 0 ; i < autoLottoCount; i++){
//            Lotto lottoNumber = new Lotto();
//            List<Integer> autoNumbers = getRandomNumList();
//            lottoNumber.addAll(autoNumbers);
//            autoLottoList.add(lottoNumber);
//        }
//
//        return autoLottoList;
//    }
//
//    public static List<Integer> getRandomNumList() {
//        Set<Integer> tempSet = new TreeSet<>();
//
//        while(tempSet.size() != 6) {
//            tempSet.add(new Random().nextInt(45) + 1);
//        }
//        List<Integer> nonDupList = new ArrayList<>(tempSet);
//
//        return nonDupList;
//    }

}
