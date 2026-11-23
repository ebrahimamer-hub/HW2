package il.ac.tau.cs.software1.inventory;

/*
 * A simple array-based Inventory (Question 6).
 */
public class NaiveInventory implements Inventory {

	private static final int INITIAL_CAPACITY = 100;
	private Collectible[] items;
	private int count;

	public NaiveInventory() {
		items = new Collectible[INITIAL_CAPACITY];	
		count = 0;
	}

	@Override
	public void collect(Collectible collectible) {
		if (count == items.length){
			Collectible[] newItems = new Collectible[items.length * 2];
			for( int i=0; i < items.length; i++){
				newItems[i] = items[i];
			}
			items = newItems;
		}
		items[count] = collectible;
		count++;
	}

	@Override
	public float getTotalWeight() {
		float total=0.0f;
		for ( int i=0; i<count; i++){
			total += items[i].getWeight();
		}
		return total;
	}

	@Override
	public int getCurrentCount() {
		return count;
	}

	// Returns the array of Collectibles that is stored in the field of this class
	public Collectible[] getCollArr() {
		return items;
	}
}
