import domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoUtil {

    public static List<LottoNumber> manualNumCreate(){
        List<String> manualList = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualLottoCount = scan.nextInt();
        scan.nextLine();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i=0 ; i < manualLottoCount ; i++ ){
            manualList.add(scan.nextLine());
        }

        scan.close();

        return manualNumParser(manualList);
    }

    public static List<LottoNumber> manualNumParser (List<String> manualList) {
        List<LottoNumber> result = new ArrayList<>();

        for (String manual : manualList) {
            LottoNumber lotto = new LottoNumber();
            lotto.addManual(manual.split(", "));
            result.add(lotto);
        }

        return result;
    }
}
