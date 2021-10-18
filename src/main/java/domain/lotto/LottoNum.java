package domain.lotto;

public class LottoNum {
    private final int num;

    private LottoNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public static LottoNum of(int num) {
        return new LottoNum(num);
    }
}
