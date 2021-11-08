package lotto.domain.previous;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.List;

public class PreviousLottoResult {

    private final double benefitRate;
    private final int [] matchArray;
    private final PreviousLotto lotto;
    private final PreviousLottoGame winningLotto;
    private final LottoNumber bonusBall;

    private PreviousLottoResult(PreviousLotto lotto, String winningLotto, int bonusBall) {
        this.lotto = lotto;
        this.winningLotto = PreviousLottoGame.parseLottoNumber(winningLotto);
        this.bonusBall = LottoNumbers.getNumber(bonusBall);
        this.matchArray = calculateMatch();
        this.benefitRate = calculateBenefitRate();
    }

    private int [] calculateMatch() {
        int [] matchArray = new int[PreviousRank.size()];
        int [] manualMatch = calculateMatch(lotto.getManualLottoGames());
        int [] autoMatch = calculateMatch(lotto.getAutoLottoGames());

        for (int i = 0; i < PreviousRank.size(); ++i) {
            matchArray[i] = manualMatch[i] + autoMatch[i];
        }

        return matchArray;
    }

    private int [] calculateMatch(List<PreviousLottoGame> lottoGameList) {
        int [] matchArray = new int[PreviousRank.size()];

        for (PreviousLottoGame lottoGame : lottoGameList) {
            int match = lottoGame.countMatch(winningLotto);

            if (match == PreviousRank.FIVE && lottoGame.getNumbers().contains(bonusBall)) {
                ++matchArray[PreviousRank.BONUS];
            } else {
                ++matchArray[match];
            }
        }

        return matchArray;
    }

    private double calculateBenefitRate() {
        double benefit = matchArray[PreviousRank.THREE] * 5_000 +
                matchArray[PreviousRank.FOUR] * 50_000 +
                matchArray[PreviousRank.FIVE] * 1_500_000 +
                matchArray[PreviousRank.BONUS] * 30_000_000 +
                matchArray[PreviousRank.SIX] * 2_000_000_000;

        return benefit / lotto.getMoney().getMoney();
    }

    public static PreviousLottoResult of(PreviousLotto lotto, String winningLotto, int bonusBall) {
        return new PreviousLottoResult(lotto, winningLotto, bonusBall);
    }

    public void print() {
        String result =  "당첨 통계\n" + "---------\n" +
                    "3개 일치 (5,000원)- " + matchArray[PreviousRank.THREE] + "개\n" +
                    "4개 일치 (50,000원)- " + matchArray[PreviousRank.FOUR] + "개\n" +
                    "5개 일치 (1,500,000원)- " + matchArray[PreviousRank.FIVE] + "개\n" +
                    "5개 일치, 보너스 볼 일치 (30,000,000원)- " + matchArray[PreviousRank.BONUS] + "개\n" +
                    "6개 일치 (2,000,000,000원)- " + matchArray[PreviousRank.SIX] + "개\n" +
                    "총 수익률은 " + (Math.floor(benefitRate * 100) / 100.0) + "입니다.\n";

        System.out.println(result);
    }

    public int[] getMatchArray() {
        return matchArray;
    }

    public double getBenefitRate() {
        return this.benefitRate;
    }
}
