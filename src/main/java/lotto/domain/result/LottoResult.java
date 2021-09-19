package lotto.domain.result;

import lotto.util.StringUtils;

import java.util.Map;
import java.util.TreeMap;

public class LottoResult {
    private final TreeMap<Rank, Integer> ranks;

    public LottoResult(TreeMap<Rank, Integer> ranks) {
        this.ranks = ranks;
    }

    public long calculateTotalReward() {
        return ranks.entrySet().stream()
                .mapToLong(set -> set.getKey().getReward() * set.getValue())
                .sum();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Rank, Integer> rankIntegerEntry : ranks.entrySet()) {
            Rank rank = rankIntegerEntry.getKey();
            Integer count = rankIntegerEntry.getValue();
            stringBuilder.append(rank.toString()).append(" - ").append(count).append("개").append(StringUtils.LINE_SEPARATOR);
        }
        return stringBuilder.toString();
    }
}
