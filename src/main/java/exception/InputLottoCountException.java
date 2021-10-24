package exception;

public class InputLottoCountException extends RuntimeException{
    private static final String WRONG_COUNT_MESSAGE = "로또 번호는 6개를 입력해야 합니다.";

    public InputLottoCountException() {
        super(WRONG_COUNT_MESSAGE);
    }
}
