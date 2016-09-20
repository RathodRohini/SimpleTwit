package subscription.implementations;

import subscription.interfaces.ItemInterface;

public class Item implements ItemInterface {

	private long quantity;
	private String unit;
	
	public Item(long quantity, String unit) {
		super();
		this.quantity = quantity;
		this.unit = unit;
	}

	@Override
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	@Override
	public long getQuantity() {
		return this.quantity;
	}

	@Override
	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public String getUnit() {
		return this.unit;
	}

}