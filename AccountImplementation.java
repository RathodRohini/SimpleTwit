package account;

public class AccountImplementation implements AccountInterface {

	private String accountId;
	private String accountName;
	private String email;
	private long phoneNumber;
	private String location;
	private String description;
	private String website;
	
	@Override
	public String getAccountId() {
		return accountId;
	}
	@Override
	public String getAccountname() {
		return accountName;
	}
	@Override
	public String getAccountEmail() {
		return email;
	}
	@Override
	public long getAccountPhoneNumber() {
		return phoneNumber;
	}

	public String getLocation() {
		return location;
	}

	public String getAccountDescription() {
		return description;
	}

	public String getAccountWebsite() {
		return website;
	}

	private AccountImplementation(AccountImplementationBuilder builder) {
		this.accountId = builder.accountId;
		this.accountName = builder.accountName;
		this.email = builder.email;
		this.phoneNumber = builder.phoneNumber;
		this.location = builder.location;
		this.description = builder.description;
		this.website = builder.website;
	}
	
	public static class AccountImplementationBuilder {
		private String accountId;
		private String accountName;
		private String email;
		private long phoneNumber;
		private String location;
		private String description;
		private String website;
		
		public AccountImplementationBuilder(String accountId, String accountName, String email) {
			this.accountId = accountId;
			this.accountName = accountName;
			this.email = email;
		}
		
		public AccountImplementationBuilder setAccountId(String accountId) {
			this.accountId = accountId;
			return this;
		}
		public AccountImplementationBuilder setAccountname(String accountName) {
			this.accountName = accountName;
			return this;
		}
		public AccountImplementationBuilder setAccountEmail(String email) {
			this.email = email;
			return this;
		}
		public AccountImplementationBuilder setAccountPhoneNumber(long phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}
		public AccountImplementationBuilder setLocation(String location) {
			this.location = location;
			return this;
		}
		public AccountImplementationBuilder setAccountDescription(String description) {
			this.description = description;
			return this;
		}
		public AccountImplementationBuilder setAccountWebsite(String website) {
			this.website = website;
			return this;
		}
		
		public AccountImplementation build() {
			return new AccountImplementation(this);
		}

	}
	
}