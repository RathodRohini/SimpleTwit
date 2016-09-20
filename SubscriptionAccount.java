package subscription.implementations;

import subscription.AccountStatus;
import subscription.interfaces.SubscriptionAccountInterface;

public class SubscriptionAccount implements
		SubscriptionAccountInterface {

	private String accountIdentifier;
	private AccountStatus status;
	
	public SubscriptionAccount(String accountIdentifier, String status) {
		this.accountIdentifier = accountIdentifier;
		this.status = AccountStatus.valueOf(status);
	}

	@Override
	public void setAccountIdentifier(String accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}

	@Override
	public String getAccountIdentifier() {
		return this.accountIdentifier;
	}

	@Override
	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	@Override
	public AccountStatus getStatus() {
		return this.status;
	}

}
