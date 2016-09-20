package subscription.implementations;

import subscription.interfaces.MarketplaceInterface;

public class Marketplace implements MarketplaceInterface {

	private String baseURL;
	private String partner;

	public Marketplace(String baseURL, String partner) {
		this.baseURL = baseURL;
		this.partner = partner;
	}
	
	@Override
	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}

	@Override
	public String getBaseURL() {
		return this.baseURL;
	}

	@Override
	public void setPartner(String partner) {
		this.partner = partner;
	}

	@Override
	public String getPartner() {
		return this.partner;
	}

}
