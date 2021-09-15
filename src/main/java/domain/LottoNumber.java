package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {

    private List<Integer> lottoNumbers = new ArrayList<>();

    public LottoNumber() {
    }

    public void add(int lottoNumber){
        lottoNumbers.add(lottoNumber);
    }

    // 로또번호를 문자열로 받는 파싱 메서드 재활용을 위해 addAll로 생성.
    public void addAll(List<Integer> lottoNumber){
        lottoNumbers.addAll(lottoNumber);
    }

    public List<Integer> getLottoNumber() {
        return lottoNumbers;
    }

    public void setLottoNumber(List<Integer> lottoNumber) {
        this.lottoNumbers = lottoNumber;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
