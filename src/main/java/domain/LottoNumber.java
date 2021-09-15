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
