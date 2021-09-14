package domain;

import java.util.List;

public class LottoResult {

    private int [] winNumbers = new int[6];
    private int bonusBall;

    private int matchThree;
    private int matchFour;
    private int matchFive;
    private int matchBounus;
    private int matchSix;

    private int benefitRate;

    public LottoResult() {
    }

    public LottoResult(int[] winNumbers, int bonusBall) {
        this.winNumbers = winNumbers;
        this.bonusBall = bonusBall;
    }

    public void winResult(List<LottoNumber> lottoList){

        for (LottoNumber list: lottoList) {
            int sameCount = 0;
            int bonusCount = 0;
            for (int winNum: winNumbers) {
                if (list.getLottoNumber().contains(winNum)) {
                    sameCount++;
                } else if (list.getLottoNumber().contains(bonusBall)){
                    bonusCount++;
                }
            }
            checkMatchCount(sameCount,bonusCount);
        }
    }

    public void checkMatchCount(int sameCount, int bonusCount){
        //switch문 사용에 대해 여줘볼것.
        if (sameCount == 3){
            this.matchThree++;
        } else if (sameCount == 4){
            this.matchFour++;
        } else if (sameCount == 5){
            if (bonusCount == 1){
                this.matchBounus++;
            } else {
                this.matchFive++;
            }
        } else if (sameCount == 6){
            this.matchSix++;
        }
    }

    public int[] getWinNumbers() {
        return winNumbers;
    }

    public void setWinNumbers(int[] winNumbers) {
        this.winNumbers = winNumbers;
    }

    public int getBonusBall() {
        return bonusBall;
    }

    public void setBonusBall(int bonusBall) {
        this.bonusBall = bonusBall;
    }

    @Override
    public String toString() {
        return "3개 일치 (5000원)- " + matchThree + "개\n" +
                "4개 일치 (50000원)- " + matchFour + "개\n" +
                "5개 일치 (1500000원)- " + matchFive + "개\n" +
                "5개 일치, 보너스 볼 일치(30000000원)- " + matchBounus + "개\n" +
                "6개 일치 (2000000000원)- " + matchSix + "개\n" ;
    }
}
