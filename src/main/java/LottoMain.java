import domain.LottoNumber;

import java.util.List;
import java.util.Scanner;

public class LottoMain {

    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("구매금액을 입력해 주세요.");

        int totalAmount = scan.nextInt();
        int totalLottoCount = totalAmount / LOTTO_PRICE;
        List<LottoNumber> lottoList = LottoUtil.manualNumCreate();


//        String str = "1,23,55,4,10";
//        String[] arr = str.split(", ");
//        List<String[]> list = new ArrayList<>();
//
//        list.add(arr);

    }
}
