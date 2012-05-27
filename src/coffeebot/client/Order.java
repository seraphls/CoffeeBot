package coffeebot.client;

public class Order {
	public static final int MAX_ITEMS = 5;
	private Item order[] = new Item[MAX_ITEMS];
	private float totalCost;
	private int itemsInOrder;
	
	public Order() {
		for (int i = 0; i < MAX_ITEMS; i++) {
			order[i] = null;
		}
		totalCost = 0;
		itemsInOrder = 0;
	}
	
	public boolean addToOrder(Item newItem) {
		if (itemsInOrder < MAX_ITEMS) {
			order[itemsInOrder] = newItem;
			itemsInOrder++;
			return true;
		} else {
			return false;
		}
	}
	
	public void removeFromOrder(int i) {
		while (i < MAX_ITEMS - 1) {
			order[i] = order[i+1];
			i++;
		}
		order[i] = null;
	}

	public double getCost() {
		totalCost = 0;
		for (int i = 0; i < MAX_ITEMS && order[i] != null; i++) {
			totalCost += order[i].getCost();
		}
		
		return totalCost;
	}

	public String toString() {
		String orderString = "";
		for (int i = 0; i < MAX_ITEMS && order[i] != null; i++) {
			orderString += "Item " + i + ":\n" + order[i].toString() + "\n\n";
		}
		return orderString;
	}
}
