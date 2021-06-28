package abstractionsEx.GreedyTimes2;

public class Cash extends Bag {

    private String currency;
    private long quantity;

    public Cash(String currency, long quantity) {
        this.currency = currency;
        this.quantity = quantity;
    }

    public void addCash(Bag bag) {
        if (freeSpaceIsAvailable(bag)
                && bag.countAsset(bag.gems) >= bag.countAsset(bag.cash) + this.quantity) {
            bag.cash.putIfAbsent(this.currency, 0L);
            bag.cash.put(this.currency, bag.cash.get(this.currency) + this.quantity);
            bag.totalQuantity += this.quantity;
        }
    }

    protected boolean freeSpaceIsAvailable(Bag bag) {
        return bag.totalQuantity + this.quantity <= bag.capacity;
    }
}
