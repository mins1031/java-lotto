package domain;

import domain.lotto.LottoInfo;

public class Buyer {
    public int totalBuyMoney;
    public int totalLottoCount;

    public Buyer(int totalBuyMoney) {
        this.totalBuyMoney = totalBuyMoney;
        this.totalLottoCount = totalBuyMoney / LottoInfo.LOTTO_PRICE;
    }


}
