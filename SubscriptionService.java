package subscription;

import java.util.Iterator;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import account.AccountInterface;

import subscription.implementations.*;
import subscription.interfaces.*;

public class SubscriptionService {

	public SubscriptionInterface createOnOrderSubscription(JSONObject eventObject) throws JSONException {
		// TODO Auto-generated method stub
		
		SubscriptionInterface subscription = null;
		
		if(eventObject != null) {
			//create new marketplace
			JSONObject marketObject =  eventObject.getJSONObject(JSONParameters.MARKETPLACE);
			MarketplaceInterface marketplace = createMarketplace(marketObject);
			
			//create creator
			JSONObject creatorObject = eventObject.getJSONObject(JSONParameters.CREATOR);
			AccountInterface creator = createCreator(creatorObject);
			
			//create payload
			JSONObject payloadObject = eventObject.getJSONObject(JSONParameters.PAYLOAD);
			PayloadInterface payload = createPayload(payloadObject);

			subscription = new Subscription(SubscriptionType.SUBSCRIPTION_ORDER, marketplace, creator, payload);
			
		}
		
		return subscription;
	}

	private PayloadInterface createPayload(JSONObject payloadObject) throws JSONException {
		
		PayloadInterface payload = null;
		
		if(payloadObject != null) {
			//create account object
			SubscriptionAccountInterface account = createPayloadAccount(payloadObject.getJSONObject(JSONParameters.ACCOUNT));
			//create company object
			CompanyInterface company = createCompany(payloadObject.getJSONObject(JSONParameters.COMPANY));
			//create order account
			OrderInterface order = createOrder(payloadObject.getJSONObject(JSONParameters.ORDER));
			//create notice account
			PayloadNoticeInterface notice = createNotice(payloadObject.getJSONObject(JSONParameters.NOTICE));		
			//create payload object
			payload = new Payload(account, order, company, notice);
		}
		
		return payload;
	}

	private PayloadNoticeInterface createNotice(JSONObject noticeObject) throws JSONException {
		// TODO Auto-generated method stub
		
		PayloadNoticeInterface notice = null;
		if(notice != null) {
			notice = new PayloadNotice(noticeObject.getString(JSONParameters.TYPE), noticeObject.getString(JSONParameters.MESSAGE));
		}
		
		return notice;
	}

	private OrderInterface createOrder(JSONObject orderObject) throws JSONException {
		
		OrderInterface order = null;
		if(orderObject != null) {
			//create item
			ItemInterface item = createItem(orderObject.getJSONObject(JSONParameters.ITEM));
			order = new Order(orderObject.getString(JSONParameters.EDITIONCODE), orderObject.getString(JSONParameters.PRICINGDURATION), item);
		}
		
		return order;
	}

	private ItemInterface createItem(JSONObject itemObject) throws JSONException {
		
		ItemInterface item = null;
		if(itemObject != null){
			item = new Item(itemObject.getLong(JSONParameters.QUANTITY), itemObject.getString(JSONParameters.UNIT));
		}
		
		return item;
	}

	private CompanyInterface createCompany(JSONObject companyObject) throws JSONException {

		CompanyInterface company = null;
		if(companyObject != null) {
			company = new Company(companyObject.getString(JSONParameters.COUNTRY), companyObject.getString(JSONParameters.NAME), companyObject.getString(JSONParameters.WEBSITE), companyObject.getString(JSONParameters.UUID));
		}
		
		return company;
	}

	private SubscriptionAccountInterface createPayloadAccount(
			JSONObject accountObject) throws JSONException {

		SubscriptionAccountInterface subscriptionAccountObject = null;
		if(accountObject != null) {
			//initialize with a random number as account identifier
			String accountIdentifier = String.valueOf(Math.random());
			//if account identifier is present already in the json then overwrite random value generated
			if(accountObject.getString(JSONParameters.ACCOUNTIDENTIFIER) != null)
				accountIdentifier = accountObject.getString(JSONParameters.ACCOUNTIDENTIFIER);
			subscriptionAccountObject = new SubscriptionAccount(accountIdentifier, accountObject.getString(JSONParameters.STATUS));
		}
		
		return subscriptionAccountObject;
	}

	private AccountInterface createCreator(JSONObject creator) throws JSONException {

		SubscriptionUser creatorObject = null;
		if(creator != null) {
			//get the address object
			AddressInterface address = createAddress(creator.getJSONObject(JSONParameters.ADDRESS));
			
			creatorObject = 
					new SubscriptionUser.SubscriptionUserImplementationBuilder(creator.getString(JSONParameters.EMAIL))
			.setAccountAddress(address)
			.setAccountId(creator.getString(JSONParameters.UUID))
			.setAccountname(creator.getString(JSONParameters.FULLNAME))
			.setAccountOpenId(creator.getString(JSONParameters.OPENID))
			.setAccountPhoneNumber(creator.getLong(JSONParameters.PHONENUMBER))
			.setFirstName(creator.getString(JSONParameters.FIRSTNAME))
			.setLanguage(creator.getString(JSONParameters.LANGUAGE))
			.setLastName(creator.getString(JSONParameters.LASTNAME))
			.build();
			
		}
		
		return creatorObject;
	}

	private AddressInterface createAddress(JSONObject addressObject) throws JSONException {
		
		AddressInterface address = new Address.AddressBuilder(addressObject.getString(JSONParameters.CITY), addressObject.getString(JSONParameters.COUNTRY), addressObject.getString(JSONParameters.STREET1), addressObject.getLong(JSONParameters.ZIP))
				.setFirstName(addressObject.getString(JSONParameters.FIRSTNAME))
				.setLastName(addressObject.getString(JSONParameters.LASTNAME))
				.setFullName(addressObject.getString(JSONParameters.FULLNAME))
				.setStreet2(addressObject.getString(JSONParameters.STREET2))
				.setState(addressObject.getString(JSONParameters.STATE))
				.build();
				
		return address;
	}

	private Marketplace createMarketplace(JSONObject marketObject) throws JSONException {

		Marketplace marketplaceObject = null;
		if(marketObject != null) {
			marketplaceObject = new Marketplace(marketObject.getString(JSONParameters.BASEURL), marketObject.getString(JSONParameters.PARTNER));
		}
		
		return marketplaceObject;
	}

	public JSONObject getResponseJSON(boolean success, String accountIdentifier, String errorCode, String message) {
		// TODO Auto-generated method stub
		JSONObject responseJSON = new JSONObject();
		try {
			if(success) {
				responseJSON.append(JSONParameters.SUCCESS, "true");
				if(accountIdentifier != null)
					responseJSON.append(JSONParameters.ACCOUNTIDENTIFIER, accountIdentifier);
				if(message != null)
					responseJSON.append(JSONParameters.MESSAGE, message);
			}
			else {

				responseJSON.append(JSONParameters.SUCCESS, "false");
				if(errorCode != null)
					responseJSON.append(JSONParameters.ERRORCODE, errorCode);
				if(message != null)
					responseJSON.append(JSONParameters.MESSAGE, message);
			}
		}
		catch (JSONException e) {
			responseJSON = null;
		}
		
		return responseJSON;
	}

	public void cancelSubscription(JSONObject eventObject) throws JSONException {
		
		List<SubscriptionInterface> subscriptions;
		//get subscriptions from storage
		subscriptions = getSubscriptions();
		cancelSubscription(subscriptions, eventObject);
		
	}

	private void cancelSubscription(List<SubscriptionInterface> subscriptions,
			JSONObject eventObject) {

		String accountIdentifier;
		try {
			accountIdentifier = eventObject
					.getJSONObject(JSONParameters.PAYLOAD)
					.getJSONObject(JSONParameters.ACCOUNT)
					.getString(JSONParameters.ACCOUNTIDENTIFIER);
			
			getSubscription(accountIdentifier, subscriptions);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}

	private List<SubscriptionInterface> getSubscriptions() {
		
		//get subscriptions from the storage

		/*
		 * Method not implemented.
		 */
		
		
		return null;
	}

	private void getSubscription(String accountIdentifier,
			List<SubscriptionInterface> subscriptions) {

		Iterator<SubscriptionInterface> iterator = subscriptions.iterator();
		while (iterator.hasNext()) {
		    SubscriptionInterface subscription = iterator.next();
		    if (isAccountIdentifierSame(accountIdentifier, subscription)) {
		        iterator.remove();
		    }
		}
	}

	private boolean isAccountIdentifierSame(String accountIdentifier,
			SubscriptionInterface subscription) {

		if(subscription.getPayload().getAccount().getAccountIdentifier().equalsIgnoreCase(accountIdentifier))
			return true;
		return false;
	}

	public String validateSubscriptionForCreation(JSONObject eventObject) throws Exception {
		
		List<SubscriptionInterface> subscriptions = getSubscriptions();
		String userId = eventObject
				.getJSONObject(JSONParameters.CREATOR)
				.getString(JSONParameters.UUID);
		//validate for user already present
		if(validateUserPresent(subscriptions, userId)){
			return String.valueOf(SubscriptionErrorCode.USER_ALREADY_EXISTS);
		}
		//validate for max users reached
		if(validateMaxUserReached()) {
			return String.valueOf(SubscriptionErrorCode.MAX_USERS_REACHED);
		}
		return null;
	}

	private boolean validateMaxUserReached() {
		/*
		 * Method not implemented.
		 * Logic:
		 * get all the users from db for the application.
		 * check for user limit against max user property.
		 */
		return false;
	}

	private boolean validateUserPresent(
			List<SubscriptionInterface> subscriptions, String userId) {

		for(SubscriptionInterface subscription : subscriptions) {
			String uuid = subscription.getCreator().getAccountId();
			if(uuid.equalsIgnoreCase(userId))
				return true;
		}
		return false;
	}

}
