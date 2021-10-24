package domain;

import domain.lotto.Lotto;
import domain.lotto.LottoMarket;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private int totalBuyMoney;
    private int totalLottoCount;
    private List<Lotto> buyLottos = new ArrayList<>();

    public Buyer(int totalBuyMoney) {
        this.totalBuyMoney = totalBuyMoney;
        this.totalLottoCount = totalBuyMoney / LottoMarket.LOTTO_PRICE;
    }

    public void addAll(List<Lotto> lottos) {
        buyLottos.addAll(lottos);
    }

    public int getTotalBuyMoney() {
        return totalBuyMoney;
    }

    public int getTotalLottoCount() {
        return totalLottoCount;
    }
}
