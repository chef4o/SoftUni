package abstractionsEx.GreedyTimes2;

public class Gem extends Bag {

    private String gemName;
    private long quantity;

    public Gem(String gemName, long quantity) {
        this.gemName = gemName;
        this.quantity = quantity;
    }

    void addGem(Bag bag) {
        if (freeSpaceIsAvailable(bag)
                && bag.countAsset(bag.gems) + this.quantity <= bag.totalGold) {
            bag.gems.putIfAbsent(this.gemName, 0L);
            bag.gems.put(this.gemName, bag.gems.get(this.gemName) + this.quantity);
            bag.totalQuantity += this.quantity;
        }
    }

    protected boolean freeSpaceIsAvailable(Bag bag) {
        return bag.totalQuantity + this.quantity <= bag.capacity;
    }
}
