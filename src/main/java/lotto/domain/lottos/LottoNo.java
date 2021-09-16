package lotto.domain.lottos;

public class LottoNo implements Comparable<LottoNo> {
    private int number ;

    public LottoNo(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return  Integer.toString(number);
    }

    @Override
    public int compareTo(LottoNo num) {
        return this.getNumber() - num.getNumber();
    }

}
