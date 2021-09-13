import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LottoUtil {

    public static List<String> manualNumCreate(){
        List<String> lottoList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualLottoCount = scan.nextInt();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i=0 ; i < manualLottoCount ; i++ ){
            lottoList.add(scan.next());
        }

        return lottoList;
    }

}
