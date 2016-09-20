package subscription.implementations;

import subscription.interfaces.AddressInterface;
import account.AccountInterface;

public class SubscriptionUser implements AccountInterface {

	private String UUId;// account id corresponds to uuid here.
	private String fullName; //account name corresponds to full name here.
	private String email;
	private long phoneNumber;
	
	//variables specific to subscription user (creator)
	private AddressInterface address;
	private String firstName;
	private String lastName;
	private String language;
	private String openId;
	
	@Override
	public String getAccountId() {
		return UUId;
	}

	@Override
	public String getAccountname() {
		return fullName;
	}

	@Override
	public String getAccountEmail() {
		return email;
	}

	@Override
	public long getAccountPhoneNumber() {
		return phoneNumber;
	}
	
	public AddressInterface getAccountAddress() {
		return address;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public String getAccountOpenId() {
		return openId;
	}
	
	private SubscriptionUser(SubscriptionUserImplementationBuilder builder) {
		this.UUId = builder.UUId;
		this.fullName = builder.fullName;
		this.email = builder.email;
		this.phoneNumber = builder.phoneNumber;
		this.address = builder.address;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.language = builder.language;
		this.openId = builder.openId;
		
	}
	
	public static class SubscriptionUserImplementationBuilder {
		
		private String UUId;
		private String fullName;
		private String email;
		private long phoneNumber;
		
		private AddressInterface address;
		private String firstName;
		private String lastName;
		private String language;
		private String openId;
		
		public SubscriptionUserImplementationBuilder(String email) {
			this.email = email;			
		}
		
		public SubscriptionUserImplementationBuilder setAccountId(String accountId) {
			this.UUId = accountId;
			return this;
		}

		public SubscriptionUserImplementationBuilder setAccountname(String accountName) {
			this.fullName = accountName;
			return this;
		}

		public SubscriptionUserImplementationBuilder setAccountEmail(String email) {
			this.email = email;
			return this;
		}

		public SubscriptionUserImplementationBuilder setAccountPhoneNumber(long phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}
		
		public SubscriptionUserImplementationBuilder setAccountAddress(AddressInterface address) {
			this.address = address;
			return this;
		}
		
		public SubscriptionUserImplementationBuilder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		
		public SubscriptionUserImplementationBuilder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		
		public SubscriptionUserImplementationBuilder setLanguage(String language) {
			this.language = language;
			return this;
		}
		
		public SubscriptionUserImplementationBuilder setAccountOpenId(String openId) {
			this.openId = openId;
			return this;
		}
				
		public SubscriptionUser build() {
			return new SubscriptionUser(this);
		}
	}
}
