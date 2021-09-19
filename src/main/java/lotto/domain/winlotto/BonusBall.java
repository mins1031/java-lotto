package lotto.domain.winlotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNo;
import lotto.validator.InputValidator;

import java.util.Objects;

public class BonusBall {
    private final LottoNo bonusBall;

    public BonusBall(LottoNo bonusBall) {
        this.bonusBall = bonusBall;
    }

    public static BonusBall of(String bonusBall) {
        InputValidator.validateNumber(bonusBall);
        LottoNo bonusBallLottoNo = LottoNo.toLottoNo(Integer.parseInt(bonusBall));
        return new BonusBall(bonusBallLottoNo);
    }

    public LottoNo getBonusBall() {
        return bonusBall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusBall bonusBall1 = (BonusBall) o;
        return Objects.equals(bonusBall, bonusBall1.bonusBall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusBall);
    }
}
