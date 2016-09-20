package subscription;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class SubscriptionHandler {

	public String sendGETRequest(String eventUrl) throws Exception{
		int success = 0;
		
		URL urlObject = new  URL(eventUrl);
		
		HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();

		// optional default is GET
		connection.setRequestMethod("GET");

		success = connection.getResponseCode();

		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		return response.toString();
	}

	public static JSONObject getEventJSONObject(String eventJSONString) throws JSONException {
		JSONObject jsonObject = new JSONObject(eventJSONString);		
		return jsonObject;
	}

	public JSONObject handleEvent(JSONObject eventJSONObject) throws JSONException {
		
		//get subscription type from event json object
		String subscriptionType = eventJSONObject.getString(JSONParameters.TYPE);
		
		//get handle event strategy on the basis of subscription type
		EventStrategy eventHandlerStrategy = getEventStrategy(subscriptionType);
		JSONObject responseJSON = null;
		SubscriptionService service = new SubscriptionService();
		//get the response json
		if(eventHandlerStrategy == null) {
			responseJSON = service.getResponseJSON(false, null, "UNRECOGNISED_SUBSCRIPTION_EVENT", "Unrecognised subscription event passed.");
		}
		else {
		//event is handled as per the event handler returned (according to the subscription event type)
			 responseJSON = eventHandlerStrategy.handleEvent(eventJSONObject);
		}
		return responseJSON;
		
		
	}

	private EventStrategy getEventStrategy(String subscriptionType) {
		EventStrategy eventStrategy = null;

		if(subscriptionType.equalsIgnoreCase(SubscriptionType.SUBSCRIPTION_ORDER.toString()))
			eventStrategy = new SubscriptionOrder();
		else if(subscriptionType.equalsIgnoreCase(SubscriptionType.SUBSCRIPTION_CHANGE.toString()))
			eventStrategy = new SubscriptionChange();
		else if(subscriptionType.equalsIgnoreCase(SubscriptionType.SUBSCRIPTION_CANCEL.toString()))
			eventStrategy = new SubscriptionCancel();
		else if(subscriptionType.equalsIgnoreCase(SubscriptionType.SUBSCRIPTION_NOTICE.toString()))
			eventStrategy = new SubscriptionNotice();
		
		return eventStrategy;
	}

	public JSONObject handleRequest(String eventUrl) {

		String eventJSONString;
		JSONObject eventJSON;
		JSONObject responseJSON;
		try {
			//send request
			eventJSONString = sendGETRequest(eventUrl);
			//get event json object
			eventJSON = getEventJSONObject(eventJSONString);
			//handle event
			responseJSON = handleEvent(eventJSON);
		} catch (Exception e) {
			SubscriptionService service = new SubscriptionService();
			responseJSON = service.getResponseJSON(false, null, "SUBSCRIPTION_ERROR", "Error occurred while creating subscription");
		}
		return responseJSON;
	}
	
}