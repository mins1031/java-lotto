import domain.LottoNumber;
import domain.LottoResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class LottoMain {

    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("구매금액을 입력해 주세요.");
        int totalAmount = scan.nextInt();
        int totalLottoCount = totalAmount / LOTTO_PRICE;

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualLottoCount = scan.nextInt();
        scan.nextLine();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<LottoNumber> lottoList = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            String manualNum = scan.nextLine();
            lottoList.add(LottoUtil.lottoNumberParser(manualNum));
        }

        int autoLottoCount = totalLottoCount - manualLottoCount;

        // merge auto
        lottoList.addAll(LottoUtil.autoNumCreate(autoLottoCount));

        //print
        System.out.println("수동으로 " + manualLottoCount + "장, 자동으로 " + autoLottoCount + "개를 구매했습니다");
        for (LottoNumber lottoNumber : lottoList) {
            System.out.println(lottoNumber);
        }

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        int [] winNumbers = Stream.of(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusBall = scan.nextInt();

        LottoResult lottoResult = new LottoResult(winNumbers,bonusBall);
        lottoResult.winResult(lottoList);

        System.out.println("");
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(lottoResult.toString());


    }
}
