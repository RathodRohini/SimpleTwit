package subscription.interfaces;

import subscription.AccountStatus;

public interface SubscriptionAccountInterface {
	public void setAccountIdentifier(String accountIdentifier);
	public String getAccountIdentifier();
	public void setStatus(AccountStatus status);
	public AccountStatus getStatus();
}
