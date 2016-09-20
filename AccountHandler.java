package account;

public class AccountHandler {


	public static AccountImplementation createAccount(AccountImplementation account) {

		AccountService service = new AccountService();
		//Validate user. Check if user already present for that user id
		boolean userValid = service.validateUser();
		if(userValid) {
		//	create account
			AccountImplementation createdAccount = service.createAccount(account);
	//save account
			service.saveAccount(createdAccount);
			return createdAccount;
		}
		return null;
	}
}