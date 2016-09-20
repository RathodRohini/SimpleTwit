package subscription.implementations;

import subscription.interfaces.CompanyInterface;

public class Company implements CompanyInterface {

	private String country;
	private String name;
	private String website;
	private String UUId;
	
	public Company(String country, String name, String website, String UUId) {
		this.country = country;
		this.name = name;
		this.website = website;
		this.UUId = UUId;
	}

	@Override
	public String getCountry() {
		return this.country;
	}

	@Override
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getWebsite() {
		return this.website;
	}

	@Override
	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String getUUId() {
		return this.UUId;
	}

	@Override
	public void setUUId(String UUId) {
		this.UUId = UUId;
	}

}
