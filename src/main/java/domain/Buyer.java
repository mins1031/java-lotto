package domain;

import domain.lotto.LottoMarket;

public class Buyer {
    private int totalBuyMoney;
    private int totalLottoCount;

    public Buyer(int totalBuyMoney) {
        this.totalBuyMoney = totalBuyMoney;
        this.totalLottoCount = totalBuyMoney / LottoMarket.LOTTO_PRICE;
    }

    public int getTotalBuyMoney() {
        return totalBuyMoney;
    }

    public int getTotalLottoCount() {
        return totalLottoCount;
    }
}
