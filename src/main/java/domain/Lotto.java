package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private List<LottoNo> numbers = new ArrayList<>();

    private Lotto(List<LottoNo> numbers) {
        this.numbers = numbers;
    }

    public static Lotto createLotto (List<String> numbers) {

        lottoValidate(numbers);

        return new Lotto(numbers);
    }

    private static void lottoValidate (List<String> numbers) {
        if (numbers.stream().distinct().collect(Collectors.toList()).size() != 6) {
            throw new IllegalArgumentException("6개의 숫자가 입력되어야 합니다.");
        }
    }

//    public void add(int lottoNumber){
//        lottoNumbers.add(lottoNumber);
//    }
//
//    // 로또번호를 문자열로 받는 파싱 메서드 재활용을 위해 addAll로 생성.
//    public void addAll(List<Integer> lottoNumber){
//        lottoNumbers.addAll(lottoNumber);
//    }
//
//    public List<Integer> getLottoNumber() {
//        return lottoNumbers;
//    }
//
//    public void setLottoNumber(List<Integer> lottoNumber) {
//        this.lottoNumbers = lottoNumber;
//    }

//    @Override
//    public String toString() {
//        return lottoNumbers.toString();
//    }
}
