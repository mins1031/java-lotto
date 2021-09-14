package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {

    private List<Integer> lottoNumbers = new ArrayList<>();


    public LottoNumber() {
    }

    public void add(int lottoNumber){
        if (lottoNumbers.size() > 5){
            //에러만들예정
        }
        lottoNumbers.add(lottoNumber);
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
