import java.util.Scanner;

public class LottoResult {

    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int totalAmount = scan.nextInt();
        //int totalLottoCount = totalAmount / LOTTO_PRICE;

        System.out.println(totalAmount);
        System.out.println(4000 / LOTTO_PRICE);

    }
}
