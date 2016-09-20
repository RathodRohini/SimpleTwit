package subscription;

import org.json.JSONObject;

public class SubscriptionCancel implements EventStrategy {

	@Override
	public JSONObject handleEvent(JSONObject eventObject) {

		//get attributes from json object and create corresponding subscription
		SubscriptionService service = new SubscriptionService();
		JSONObject success = null;
		try {
			service.cancelSubscription(eventObject);
			success = service.getResponseJSON(true, null, null, "Subscription cancelled succcessfully");
		} catch (Exception e) {
			success = service.getResponseJSON(false, null, "SUBSCRIPTION_ORDER_ERROR", "Error occurred while creating subscription.");
		}

		return success;

	}

}
