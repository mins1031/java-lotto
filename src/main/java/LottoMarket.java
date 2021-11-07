import domain.Buyer;
import domain.lotto.Lotto;
import domain.lotto.LottoNum;
import domain.lotto.lottogenerate.LottoAutoGenerator;
import domain.lotto.lottogenerate.LottoGenerator;
import domain.lotto.lottogenerate.LottoManualGenerator;
import domain.money.BuyMoney;
import domain.win.WinCondition;
import domain.win.WinResult;
import scanner.InputUtil;
import scanner.OutputUtil;

import java.util.Arrays;
import java.util.List;

public class LottoMarket {

    public static void main(String[] args) {
        List<LottoGenerator> lottoGenerators = Arrays.asList(new LottoManualGenerator(), new LottoAutoGenerator());
        BuyMoney buyMoney = new BuyMoney(InputUtil.inputTotalBuyMoney());
        Buyer buyer = new Buyer(buyMoney);

        int manualLottoCount = InputUtil.inputManualLottoCount(buyer.getTotalLottoCount());
        buyer.defineAllLottoCountTypes(manualLottoCount);

        List<Lotto> buyLottos = buyer.getBuyLottos();
        lottoGenerators.stream().forEach(generator -> buyLottos.addAll(generator.generate(buyer)));

        OutputUtil.informBuyLottosCount(buyer);
        OutputUtil.informBuyLottoNums(buyLottos);

        WinCondition winCondition = new WinCondition(
                LottoNum.toLottoNum(InputUtil.inputWinNums()),
                InputUtil.inputBonusBall()
        );

        WinResult winResult = new WinResult();
        winResult.checkLottosResult(winCondition, buyer.getBuyLottos(), buyer.getBuyMoney().getTotalBuyMoney());
        OutputUtil.informWinStatistics(winResult);
    }
}
