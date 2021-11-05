import domain.Buyer;
import domain.lotto.Lotto;
import domain.lotto.LottoFront;
import domain.lotto.lottogenerate.LottoAutoGenerator;
import domain.lotto.lottogenerate.LottoGenerator;
import domain.lotto.lottogenerate.LottoManualGenerator;
import domain.win.WinCondition;
import scanner.InputUtil;
import domain.win.WinResult;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMarket {

    public static void main(String[] args) {
        int totalBuyMoney = InputUtil.inputTotalBuyMoney();
        Buyer buyer = new Buyer(totalBuyMoney);
        buyer.defineLottoCounts(InputUtil.inputManualLottoCount(buyer.getTotalLottoCount()));

        List<LottoGenerator> lottoGenerators = Arrays.asList(new LottoManualGenerator(), new LottoAutoGenerator());
        List<Lotto> buyLottos = buyer.getBuyLottos();
        lottoGenerators.stream().forEach(generater -> buyLottos.addAll(generater.generate(buyer)));
        System.out.println("수동으로 " + buyer.getManualLottoCount() + "장, 자동으로 " + buyer.getAutoLottoCount() + "장을 구매했습니다.");

        LottoFront lottoFront = new LottoFront();
        for (Lotto lotto : buyLottos) {
            System.out.println(lotto.toString());
        }

        WinCondition winCondition = new WinCondition(
                lottoFront.toLottoNum(InputUtil.inputWinNums()),
                InputUtil.inputBonusBall()
        );

        WinResult winResult = new WinResult();
        winResult.checkLottosResult(winCondition, buyLottos, buyer.getTotalBuyMoney());
        System.out.println(winResult);
    }
}
