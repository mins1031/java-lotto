package lotto.domain;

import java.util.List;

public interface LottoGenerator {
    public void generate(Customer customer);

    public String getType();
    public List<Lotto> getLottos();
    public String toString();
}
