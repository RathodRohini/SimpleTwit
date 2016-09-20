package subscription.implementations;

import subscription.interfaces.ItemInterface;
import subscription.interfaces.OrderInterface;

public class Order implements OrderInterface {

	private String editionCode;
	private String pricingDuration;
	private ItemInterface item;
	
	public Order(String editionCode, String pricingDuration, ItemInterface item) {
		this.editionCode = editionCode;
		this.pricingDuration = pricingDuration;
		this.item = item;
	}

	@Override
	public String getEditionCode() {
		return this.editionCode;
	}

	@Override
	public void setEditionCode(String editionCode) {
		this.editionCode = editionCode;
	}

	@Override
	public String getPricingDuration() {
		return this.pricingDuration;
	}

	@Override
	public void setPricingDuration(String pricingDuration) {
		this.pricingDuration = pricingDuration;
	}

	@Override
	public ItemInterface getItem() {
		return this.item;
	}

	@Override
	public void setItem(ItemInterface item) {
		this.item = item;
	}

}
