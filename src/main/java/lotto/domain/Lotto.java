package lotto.domain;

import lotto.scanner.InputScanner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {

    private static List<LottoNo> lottoNumberList = LottoNumbers.getInstance();

    private static List<int[]> lottoGames = new ArrayList<>();

    public Lotto() {
    }

    public static Lotto createLotto (String message, int manualCount) {

        System.out.println("input message: " + message);

        List<int[]> inputLottoNumbers = InputScanner.userLottoInput(manualCount);

        lottoGames.addAll(inputLottoNumbers);

        lottoValidate(numbers);

        return new Lotto(numbers);
    }

    private static void lottoValidate(List<int[]> inputLottoNumbers) {
        for (int[] lottoArr :inputLottoNumbers) {
            Stream.of(lottoArr).filter(x -> )
        }
        if (lottoNo < 1 || lottoNo > 45) {
            throw new IllegalArgumentException("1 ~ 45 이내의 숫자를 입력해야 합니다.");
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

