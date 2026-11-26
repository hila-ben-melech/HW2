package il.ac.tau.cs.software1.inventory;

/*
 * A simple array-based Inventory (Question 6).
 */
public class NaiveInventory implements Inventory {

	private static final int INITIAL_CAPACITY = 100;
	private Collectible[] collArr;
	private int currentCount;

	public NaiveInventory() {
		collArr = new Collectible[INITIAL_CAPACITY];
		currentCount = 0;
	}

	@Override
	public void collect(Collectible collectible) {
		if (collArr.length == currentCount) {
			Collectible[] newCollArr = new Collectible[collArr.length * 2];
			for (int i = 0; i < currentCount; i++) {
				newCollArr[i] = collArr[i];
			}
			collArr = newCollArr;
		}
		collArr[currentCount] = collectible;
		currentCount++;
	}

	@Override
	public float getTotalWeight() {
		float weightSum = 0;
		for (int i = 0; i < currentCount; i++) {
			weightSum += collArr[i].getWeight();
		}
		return weightSum;
	}

	@Override
	public int getCurrentCount() {
		return currentCount;
	}

	// Returns the array of Collectibles that is stored in the field of this class
	public Collectible[] getCollArr() {
		return collArr;
	}
}
