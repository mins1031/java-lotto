import domain.Buyer;
import domain.lotto.Lotto;
import domain.lotto.LottoFront;
import domain.lotto.LottoNum;
import domain.lotto.lottogenerate.LottoAutoGenerator;
import domain.lotto.lottogenerate.LottoGenerator;
import domain.lotto.lottogenerate.LottoManualGenerator;
import domain.win.WinCondition;
import scanner.InputUtil;
import domain.win.WinResult;
import scanner.OutputUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMarket {

    public static void main(String[] args) {
        List<LottoGenerator> lottoGenerators = Arrays.asList(new LottoManualGenerator(), new LottoAutoGenerator());
        Buyer buyer = new Buyer(InputUtil.inputTotalBuyMoney());

        int manualLottoCount = InputUtil.inputManualLottoCount(buyer.getTotalLottoCount());
        buyer.defineLottoCounts(manualLottoCount);

        List<Lotto> buyLottos = buyer.getBuyLottos();
        lottoGenerators.stream().forEach(generator -> buyLottos.addAll(generator.generate(buyer)));
        OutputUtil.informLottoCount(buyer);
        OutputUtil.informBuyLottos(buyLottos);

        WinCondition winCondition = new WinCondition(
                LottoNum.toLottoNum(InputUtil.inputWinNums()),
                InputUtil.inputBonusBall()
        );

        WinResult winResult = new WinResult();
        winResult.checkLottosResult(winCondition, buyer.getBuyLottos(), buyer.getTotalBuyMoney());
        OutputUtil.informWinStatistics(winResult);
    }
}
