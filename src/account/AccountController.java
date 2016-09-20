package account;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountController {

	List<AccountImplementation> accounts = new ArrayList<AccountImplementation>();

	@PostConstruct
	public void init() {
		/*
		 * populated accounts with pre existing data to read.
		 */
		AccountImplementation createdAccount1 = new AccountImplementation
				.AccountImplementationBuilder("juli_roberts", "Julia", "juli_roberts@abc.com")
		.setAccountPhoneNumber(987654321)
		.setLocation("Pune")
		.build();

		AccountImplementation createdAccount2 = new AccountImplementation
				.AccountImplementationBuilder("pete", "Peter", "Pater_parker@abc.com")
		.setAccountPhoneNumber(987654321)
		.setLocation("Pune")
		.build();

		AccountImplementation createdAccount3 = new AccountImplementation
				.AccountImplementationBuilder("hp", "Harry potter", "hpotter@abc.com")
		.setAccountPhoneNumber(987654321)
		.setLocation("Pune")
		.build();

		accounts.add(createdAccount1);
		accounts.add(createdAccount2);
		accounts.add(createdAccount3);
	}

	/**
	 * This is actual implementation when UI will be implemented, since this accepts model
	 * creating account.
	 * Please user "/createAccount" url to test user creation with just username and password
	 */
	@RequestMapping("/create")
	@ResponseBody
	public AccountInterface createAccount(@RequestBody AccountImplementation account) {

		AccountHandler accounthandler = new AccountHandler();
		AccountInterface createdAccount = null;
		createdAccount = accounthandler.createAccount(account);

		return createdAccount;
	}

	/**
	 * Creates user
	 * @param username, userid and password
	 */

	@RequestMapping("/createAccount/{userName}/{userId}/{password}")
	@ResponseBody
	public String createAccount(@PathVariable String userName, @PathVariable String userId, @PathVariable String password) {

		AccountHandler accounthandler = new AccountHandler();

		String userPresent = "";
		boolean userPresentCheck = false;

		//check if user already present in temp storage
		for(int UserIndex = 0; UserIndex < accounts.size(); UserIndex++) {
			if(accounts.get(UserIndex).getAccountId().equalsIgnoreCase(userId)) {
				userPresent = ". User already present.";
				userPresentCheck = true;
				break;
			}
		}

		if(!userPresentCheck) {
			AccountImplementation createdAccount = new AccountImplementation
					.AccountImplementationBuilder(userId, userName, "dummyEmail@dummy.com")
			.setAccountDescription(userName+" account created.")
			.build();

			createdAccount = accounthandler.createAccount(createdAccount);

			if(createdAccount!=null){
				accounts.add(createdAccount);
				return "Account added succeessfully.";
			}

		}

		return "Error occurrred while creating account" +userPresent;
	}

	/*
	 * This is simple implementation for delete user.
	 * The actual product implementation must also authenticate user and delete accordingly.
	 */

	@RequestMapping("/deleteAccount/{userId}")
	@ResponseBody
	public String deleteAccount(@PathVariable String userId) {
		String success = "Error occurred while deleting user.";
		Iterator<AccountImplementation> iterator = accounts.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getAccountId().equalsIgnoreCase(userId)) {
				iterator.remove();
				success = "User deleted successfully.";
				break;
			}
		}

		return success;
	}

}