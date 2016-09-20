package subscription;

import org.json.JSONException;
import org.json.JSONObject;

import subscription.interfaces.SubscriptionInterface;

public class SubscriptionOrder implements EventStrategy {

	@Override
	public JSONObject handleEvent(JSONObject eventObject) {

		//get attributes from json object and create corresponding subscription
		SubscriptionService service = new SubscriptionService();
		JSONObject success = null;
		try {
			//validate subscription for creation
			service.validateSubscriptionForCreation(eventObject);			
			
			//create subscription
			SubscriptionInterface subscription = service.createOnOrderSubscription(eventObject);
			/*add subscription to db 
			 * method not implemented
			 * service.saveSubscription
			 */
			//get json response on success
			success = service.getResponseJSON(true, subscription.getPayload().getAccount().getAccountIdentifier(), null, "Order succesfully placed.");
			
		} catch (Exception e) {
			//get error json response. This should return error as per the error code
			success = service.getResponseJSON(false, null, "SUBSCRIPTION_ORDER_ERROR", "Error occurred while creating subscription.");
		}
		
		return success;
		
	}

}