package domain.win;

import domain.lotto.LottoNum;

import java.util.ArrayList;
import java.util.List;

public class WinCondition {
    private List<LottoNum> lottoNums = new ArrayList<>();
    private int bonusBall = 0;

    public WinCondition(List<LottoNum> lottoNums, int bonusBall) {
        this.lottoNums = lottoNums;
        this.bonusBall = bonusBall;
    }
}
