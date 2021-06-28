package abstractionsEx.GreedyTimes2;

import java.util.Comparator;
import java.util.TreeMap;

public class Bag {

    protected long capacity;
    protected long totalQuantity;
    protected long totalGold;
    protected boolean goldWasAdded = false;
    protected TreeMap<String, Long> gems;
    protected TreeMap<String, Long> cash;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.cash = new TreeMap<>(Comparator.reverseOrder());
        this.gems = new TreeMap<>(Comparator.reverseOrder());
    }

    public Bag() {
    }

    protected String sortedValues(TreeMap<String, Long> collection) {
        StringBuilder result = new StringBuilder();
        collection.entrySet().stream()
                .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                .forEach(i ->
                        result.append(String.format("##%s - %d",
                                i.getKey(), i.getValue()))
                                .append(System.lineSeparator()));
        return result.toString();
    }

    protected long countAsset(TreeMap<String, Long> asset) {
        return asset.values().stream()
                .mapToLong(Long::longValue)
                .sum();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        if (goldWasAdded || this.totalGold > 0) {
            output.append(String.format("<Gold> $%d", this.totalGold)).append(System.lineSeparator());
            output.append(String.format("##Gold - %d", this.totalGold)).append(System.lineSeparator());
        }
        if (!this.gems.isEmpty()) {
            output.append(String.format("<Gem> $%d", countAsset(this.gems))).append(System.lineSeparator());
            output.append(sortedValues(this.gems));
        }
        if (!this.cash.isEmpty()) {
            output.append(String.format("<Cash> $%d", countAsset(this.cash))).append(System.lineSeparator());
            output.append(sortedValues(this.cash));
        }
        return output.toString();
    }
}
