package exception.lotto;

public class InputLottoTypeException extends RuntimeException{
    private static final String WRONG_TYPE_MESSAGE = "로또 번호는 숫자를 입력해야 합니다.";

    public InputLottoTypeException() {
        super(WRONG_TYPE_MESSAGE);
    }
}
