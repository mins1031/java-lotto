import lotto.domain.BuyMoney;
import lotto.domain.LottoCalcurator;
import lotto.domain.WinInfo;
import lotto.domain.lottos.Lotto;
import lotto.domain.lottos.LottoInfo;
import lotto.exception.ExceptionHandler;
import lotto.scanner.InputScanner;

public class LottoMain {

    public static void main(String[] args) {

        BuyMoney totalAmount = BuyMoney.configPurchaseAmount("구매금액을 입력해 주세요.");

        LottoInfo lottoInfo = new LottoInfo(totalAmount);
        lottoInfo.calculateInitValue("수동으로 구매할 로또 수를 입력해 주세요.");

        Lotto lotto = new Lotto();
        lotto.createManualLotto("수동으로 구매할 번호를 입력해 주세요.",lottoInfo.getManualLottoCount());
        lotto.createAutoLotto(lottoInfo.getAutoLottoCount());
        lotto.print();

        WinInfo winInfo = new WinInfo();
        winInfo.inputWinNumbers("지난 주 당첨 번호를 입력해 주세요.");
        winInfo.inputBonusBall("보너스 볼을 입력해 주세요.");

        LottoCalcurator lottoCalcurator = new LottoCalcurator();


//
//        int autoLottoCount = totalLottoCount - manualLottoCount;
//
//        // merge auto
//        lottoList.addAll(LottoUtil.autoNumCreate(autoLottoCount));
//
//        //print
//        System.out.println("수동으로 " + manualLottoCount + "장, 자동으로 " + autoLottoCount + "개를 구매했습니다");
//        for (Lotto lottoNumber : lottoList) {
//            System.out.println(lottoNumber);
//        }
//
//        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
//        String inputWinNum = scan.nextLine();
//        List<Integer> winNumbers = LottoUtil.lottoNumberParser(inputWinNum);
//
//        System.out.println("보너스 볼을 입력해 주세요.");
//        int bonusBall = scan.nextInt();
//
//        LottoResult lottoResult = new LottoResult(winNumbers, bonusBall);
//        lottoResult.winResult(lottoList);
//        lottoResult.calculateBenefitRate(totalAmount);
//
//        System.out.println("");
//        System.out.println("당첨 통계");
//        System.out.println("---------");
//        System.out.println(lottoResult.toString());

    }
}
