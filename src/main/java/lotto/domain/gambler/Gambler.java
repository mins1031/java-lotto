package lotto.domain.gambler;

import lotto.domain.lotto.Lotto;

import java.util.List;

public class Gambler {
    private final BettingMoney bettingMoney;
    private final List<String> manualLottosNumber;

    public Gambler(BettingMoney bettingMoney, List<String> manualLottosNumber) {
        this.bettingMoney = bettingMoney;
        this.manualLottosNumber = manualLottosNumber;
    }

    public int calculateAutoLottoCount() {
        int canBuyLottoCount = bettingMoney.getBettingMoney() / Lotto.LOTTO_PRICE;
        return canBuyLottoCount - calculateManualLottoCount();
    }

    public int calculateManualLottoCount() {
        return manualLottosNumber.size();
    }

    public List<String> getManualLottosNumber() {
        return manualLottosNumber;
    }

    public BettingMoney getBettingMoney() {
        return bettingMoney;
    }
}
