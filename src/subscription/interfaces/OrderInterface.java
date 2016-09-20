package subscription.interfaces;


public interface OrderInterface {
	public String getEditionCode();
	public void setEditionCode(String editionCode);
	public String getPricingDuration();
	public void setPricingDuration(String pricingDuration);
	public ItemInterface getItem();
	public void setItem(ItemInterface item);
}
