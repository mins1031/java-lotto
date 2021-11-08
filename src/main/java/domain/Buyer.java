package domain;

import domain.lotto.Lotto;
import domain.lotto.LottoMarket;
import domain.money.Money;
import exception.lotto.InputLottoTypeException;
import exception.lotto.OutRangeInputManualLottoCount;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private Money money;
    private int totalLottoCount;
    private int manualLottoCount;
    private int autoLottoCount;

    private List<Lotto> buyLottos = new ArrayList<>();

    public Buyer(String rawBuyMoney) {
        this.money = new Money(rawBuyMoney);
        this.totalLottoCount = money.getBuyMoney() / LottoMarket.LOTTO_PRICE;
    }

    public void defineAllLottoCountTypes(String rawManualLottoCount) {
        int realManualLottoCount = toIntegerOfManualLottoCount(rawManualLottoCount);
        this.manualLottoCount = realManualLottoCount;
        this.autoLottoCount = totalLottoCount - realManualLottoCount;
    }

    private int toIntegerOfManualLottoCount(String rawManualLottoCount) {
        try {
            int manualLottoCount = Integer.parseInt(rawManualLottoCount);
            validateManualLottoCount(manualLottoCount, totalLottoCount);
            return manualLottoCount;
        } catch (NumberFormatException e) {
            throw new InputLottoTypeException();
        }
    }

    private void validateManualLottoCount(int manualLottoCount, int totalLottoCount) {
        if (manualLottoCount < LottoMarket.LOTTO_MIN_NUMBER || manualLottoCount > totalLottoCount) {
            throw new OutRangeInputManualLottoCount();
        }
    }

    public void addAll(List<Lotto> lottos) {
        buyLottos.addAll(lottos);
    }

    public Money getBuyMoney() {
        return money;
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
