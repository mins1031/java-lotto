package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {

    private List<Integer> winNumbers = new ArrayList<>();
    private int bonusBall;

    private int matchThree;
    private int matchFour;
    private int matchFive;
    private int matchBonus;
    private int matchSix;

    private double benefitRate;

    public LottoResult() {
    }

    public LottoResult(List<Integer> winNumbers, int bonusBall) {
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
                this.matchBonus++;
            } else {
                this.matchFive++;
            }
        } else if (sameCount == 6){
            this.matchSix++;
        }
    }

    public void calculateBenefitRate(int totalAmount) {
        double totalBenefit = matchThree * 5_000 +
                matchFour * 50_000 +
                matchFive * 1_500_000 +
                matchBonus * 30_000_000 +
                matchSix * 2_000_000_000;

        this.benefitRate = totalBenefit / totalAmount;
    }

    @Override
    public String toString() {
        return "3개 일치 (5,000원)- " + matchThree + "개\n" +
                "4개 일치 (50,000원)- " + matchFour + "개\n" +
                "5개 일치 (1,500,000원)- " + matchFive + "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원)- " + matchBonus + "개\n" +
                "6개 일치 (2,000,000,000원)- " + matchSix + "개\n" +
                "총 수익률은 " + (Math.floor(benefitRate * 100) / 100.0) + "입니다.\n";
    }

    public List<Integer> getWinNumbers() {
        return winNumbers;
    }

    public void setWinNumbers(List<Integer> winNumbers) {
        this.winNumbers = winNumbers;
    }

    public int getBonusBall() {
        return bonusBall;
    }

    public void setBonusBall(int bonusBall) {
        this.bonusBall = bonusBall;
    }

    public int getMatchThree() {
        return matchThree;
    }

    public int getMatchFour() {
        return matchFour;
    }

    public int getMatchFive() {
        return matchFive;
    }

    public int getMatchBonus() {
        return matchBonus;
    }

    public int getMatchSix() {
        return matchSix;
    }

    public double getBenefitRate() {
        return benefitRate;
    }
}
