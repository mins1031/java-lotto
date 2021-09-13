package domain;

public class LottoNumber {

    private Integer[] lottoNumbers = new Integer[6];
    private int inputSize = 0;

    public LottoNumber() {
    }

    public void add(int lottoNumber){
        if (inputSize > 5){
            //에러만들예정
        }
        lottoNumbers[inputSize] = lottoNumber;
        inputSize++;
    }

    public int size(){
        return this.inputSize;
    }

    public Integer[] getLottoNumber() {
        return lottoNumbers;
    }

    public void setLottoNumber(Integer[] lottoNumber) {
        this.lottoNumbers = lottoNumber;
    }
}
