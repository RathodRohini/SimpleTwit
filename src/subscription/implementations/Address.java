package subscription.implementations;
import subscription.interfaces.AddressInterface;

public class Address implements AddressInterface {

	private String firstName;
	private String lastName;
	private String fullName;
	private String street1;
	private String street2;
	private long zip;
	private String city;
	private String state;
	private String country;
	
	private Address(AddressBuilder builder) {
		this.city = builder.city;
		this.country = builder.country;
		this.street1 = builder.street1;
		this.zip = builder.zip;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.fullName = builder.fullName;
		this.street2 = builder.street2;
		this.state = builder.state;
	}
	@Override
	public String getFirstName() {
		return this.firstName;
	}
	@Override
	public String getLastName() {
		return this.lastName;
	}
	@Override
	public String getFullName() {
		return this.fullName;
	}
	@Override
	public String getStreet1() {
		return this.street1;
	}
	@Override
	public String getStreet2() {
		return this.street2;
	}
	@Override
	public long getZip() {
		return this.zip;
	}
	@Override
	public String getCity() {
		return city;
	}
	@Override
	public String getState() {
		return this.state;
	}
	@Override
	public String getCountry() {
		return this.country;
	}

	public static class AddressBuilder {
		
		private String firstName;
		private String lastName;
		private String fullName;
		private String street1;
		private String street2;
		private long zip;
		private String city;
		private String state;
		private String country;
		
		public AddressBuilder(String city, String country, String street1, long zip) {
			this.city = city;
			this.country = country;
			this.street1 = street1;
			this.zip = zip;
		}

		public AddressBuilder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
	
		public AddressBuilder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public AddressBuilder setFullName(String fullName) {
			this.fullName = fullName;
			return this;
		}

		public AddressBuilder setStreet1(String street) {
			this.street1 = street;
			return this;
		}

		public AddressBuilder setStreet2(String street) {
			this.street2 = street;
			return this;
		}

		public AddressBuilder setCountry(String country) {
			this.country = country;
			return this;
		}

		public AddressBuilder setZip(long zip) {
			this.zip = zip;
			return this;
		}

		public AddressBuilder setCity(String city) {
			this.city = city;
			return this;
		}

		public AddressBuilder setState(String state) {
			this.state = state;
			return this;
		}

		public Address build() {
			return new Address(this);
		}
		
	}
	
}
