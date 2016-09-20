package subscription.interfaces;

import subscription.SubscriptionType;
import account.AccountInterface;

public interface SubscriptionInterface {
	public void setSubscriptionType(SubscriptionType type);
	public SubscriptionType getSubscriptionType();
	public void setMarketplace(MarketplaceInterface marketplace);
	public MarketplaceInterface getMarketplace();
	public void setCreator(AccountInterface account);
	public AccountInterface getCreator();
	public void setPayload(PayloadInterface payload);
	public PayloadInterface getPayload();
}
