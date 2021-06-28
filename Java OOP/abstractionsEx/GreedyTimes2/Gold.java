package abstractionsEx.GreedyTimes2;

public class Gold extends Bag {

    private long quantity;

    public Gold(long quantity) {
        this.quantity = quantity;
    }

    void addGold(Bag bag) {
        if (freeSpaceIsAvailable(bag)) {
            bag.totalGold += this.quantity;
            bag.totalQuantity += this.quantity;
            bag.goldWasAdded = true;
        }
    }

    private boolean freeSpaceIsAvailable(Bag bag) {
        return bag.totalQuantity + this.quantity <= bag.capacity;
    }
}
