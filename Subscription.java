package subscription.implementations;

import subscription.SubscriptionType;
import subscription.interfaces.MarketplaceInterface;
import subscription.interfaces.PayloadInterface;
import subscription.interfaces.SubscriptionInterface;
import account.AccountInterface;

public class Subscription implements SubscriptionInterface {

	private SubscriptionType type;
	private MarketplaceInterface marketplace;
	private AccountInterface creator;
	private PayloadInterface payload;
	
	public Subscription(SubscriptionType type,
			MarketplaceInterface marketplace, AccountInterface creator,
			PayloadInterface payload) {
		this.type = type;
		this.marketplace = marketplace;
		this.creator = creator;
		this.payload = payload;
	}

	@Override
	public void setSubscriptionType(SubscriptionType type) {
		this.type = type;
	}

	@Override
	public SubscriptionType getSubscriptionType() {
		return this.type;
	}

	@Override
	public void setMarketplace(MarketplaceInterface marketplace) {
		this.marketplace = marketplace;
	}

	@Override
	public MarketplaceInterface getMarketplace() {
		return this.marketplace;
	}

	@Override
	public void setCreator(AccountInterface account) {
		this.creator = account;
	}

	@Override
	public AccountInterface getCreator() {
		return this.creator;
	}

	@Override
	public void setPayload(PayloadInterface payload) {
		this.payload = payload;
	}

	@Override
	public PayloadInterface getPayload() {
		return this.payload;
	}

}
