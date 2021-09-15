public class ExceptionHandler {
    public static void validateLottoCount (int totalLottoCount, int manualLottoCount) {
        if (totalLottoCount < manualLottoCount) {
            System.out.println("최대 구매 갯수를 초과하여 입력하였습니다.");
            System.exit(1);
        }
    }

    public static void generateInputError(){
        System.out.println("잘못된 입력입니다. 프로그램을 다시 실행해주세요");
        System.exit(1);
    }
}
