package domain;

import domain.lotto.LottoInfo;

public class Buyer {
    private int totalBuyMoney;
    private int totalLottoCount;

    public Buyer(int totalBuyMoney) {
        this.totalBuyMoney = totalBuyMoney;
        this.totalLottoCount = totalBuyMoney / LottoInfo.LOTTO_PRICE;
    }

    public int getTotalBuyMoney() {
        return totalBuyMoney;
    }

    public int getTotalLottoCount() {
        return totalLottoCount;
    }
}
