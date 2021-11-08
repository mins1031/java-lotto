package lotto.domain;

import lotto.validator.WinningLottoValidator;

public class WinLotto {
    private Lotto winLotto;
    private LottoNumber bonusBall;

    private WinLotto(Lotto winLotto, LottoNumber bonusBall) {
        this.winLotto = winLotto;
        this.bonusBall = bonusBall;
    }

    public static WinLotto of (Lotto winLotto, LottoNumber bonusBall) {
        WinningLottoValidator.validate(winLotto, bonusBall);
        return new WinLotto(winLotto, bonusBall);
    }

    public Lotto getWinLotto () {
        return this.winLotto;
    }
}
