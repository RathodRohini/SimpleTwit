package account;

public class AccountService {

	public AccountImplementation createAccount(AccountImplementation account) {
		
		AccountImplementation createdAccount = new AccountImplementation
				.AccountImplementationBuilder(account.getAccountId(), account.getAccountname(), account.getAccountEmail())
				.setAccountDescription(account.getAccountDescription())
				.setAccountPhoneNumber(account.getAccountPhoneNumber())
				.setAccountWebsite(account.getAccountWebsite())
				.setLocation(account.getLocation())
				.build();
		
		return createdAccount;
	}

	public void saveAccount(AccountImplementation createdAccount) {
		/*
		 * Data stored in db
		 */
	}

	public boolean validateUser() {

		//check if user is already present for
		
		return true;
	}

}
