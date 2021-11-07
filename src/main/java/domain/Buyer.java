package domain;

import domain.lotto.Lotto;
import domain.money.BuyMoney;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private BuyMoney buyMoney;
    private int totalLottoCount;
    private int manualLottoCount;
    private int autoLottoCount;

    private List<Lotto> buyLottos = new ArrayList<>();

    public Buyer(BuyMoney buyMoney) {
        this.buyMoney = buyMoney;
        this.totalLottoCount = buyMoney.getTotalBuyMoney() / Lotto.LOTTO_PRICE;
    }

    public void defineAllLottoCountTypes(int manualLottoCount) {
        this.manualLottoCount = manualLottoCount;
        this.autoLottoCount = totalLottoCount - manualLottoCount;
    }

    public void addAll(List<Lotto> lottos) {
        buyLottos.addAll(lottos);
    }

    public BuyMoney getBuyMoney() {
        return buyMoney;
    }

    public int getTotalLottoCount() {
        return totalLottoCount;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    public int getAutoLottoCount() {
        return autoLottoCount;
    }

    public List<Lotto> getBuyLottos() {
        return buyLottos;
    }
}
