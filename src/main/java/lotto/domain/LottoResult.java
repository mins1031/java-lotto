package lotto.domain;

public class LottoResult {

    private final double benefitRate;
    private final int [] matchArray;
    private final Lotto lotto;
    private final LottoGame winningLotto;
    private final LottoNumber bonusBall;

    private LottoResult (Lotto lotto, String winningLotto, int bonusBall) {
        this.lotto = lotto;
        this.winningLotto = LottoGame.parseLottoNumber(winningLotto);
        this.bonusBall = LottoNumbers.getLottoNumbers().get(bonusBall - 1);
        this.matchArray = calculateMatch();
        this.benefitRate = calculateBenefitRate();
    }

    private int [] calculateMatch () {
        int [] matchArray = new int[8];

        for (LottoGame lottoGame : lotto.getManualLottoGames()) {
            int match = lottoGame.countMatch(winningLotto);

            if (match == LottoMatch.FIVE && lottoGame.getNumbers().contains(bonusBall)) {
                ++matchArray[LottoMatch.BONUS];
            } else {
                ++matchArray[match];
            }
        }

        return matchArray;
    }

    private double calculateBenefitRate () {
        double benefit = matchArray[LottoMatch.THREE] * 5_000 +
                matchArray[LottoMatch.FOUR] * 50_000 +
                matchArray[LottoMatch.FIVE] * 1_500_000 +
                matchArray[LottoMatch.BONUS] * 30_000_000 +
                matchArray[LottoMatch.SIX] * 2_000_000_000;

        return benefit / lotto.getMoney().getMoney();
    }

    public static LottoResult of (Lotto lotto, String winningLotto, int bonusBall) {
        return new LottoResult(lotto, winningLotto, bonusBall);
    }

    public void print() {
        String result =  "당첨 통계\n" + "---------\n" +
                    "3개 일치 (5,000원)- " + matchArray[LottoMatch.THREE] + "개\n" +
                    "4개 일치 (50,000원)- " + matchArray[LottoMatch.FOUR] + "개\n" +
                    "5개 일치 (1,500,000원)- " + matchArray[LottoMatch.FIVE] + "개\n" +
                    "5개 일치, 보너스 볼 일치 (30,000,000원)- " + matchArray[LottoMatch.BONUS] + "개\n" +
                    "6개 일치 (2,000,000,000원)- " + matchArray[LottoMatch.SIX] + "개\n" +
                    "총 수익률은 " + (Math.floor(benefitRate * 100) / 100.0) + "입니다.\n";

        System.out.println(result);
    }
}
