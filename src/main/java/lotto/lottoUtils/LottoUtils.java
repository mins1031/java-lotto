package lotto.lottoUtils;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.WinLotto;

import java.util.List;

public class LottoUtils {
    public static void printLotto(List<LottoGenerator> lottoGenerators) {
        StringBuilder sb = new StringBuilder();
        for(LottoGenerator lottoGenerator : lottoGenerators) {
            sb.append(lottoGenerator.getType()).append("으로 ").append(lottoGenerator.getLottos().size()).append("장 ");
        }
        sb.append("구매했습니다.\n");
        for(LottoGenerator lottoGenerator : lottoGenerators) {
            sb.append(lottoGenerator);
        }
        System.out.println(sb);
    }

//    public static int rankCount(List<Lotto> lottos, WinLotto winLotto) {
//        for(Lotto lotto : lottos) {
//
//        }
//    }
}
