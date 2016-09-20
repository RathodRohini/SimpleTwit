package subscription;

import org.json.JSONException;
import org.json.JSONObject;

public interface EventStrategy {
	public JSONObject handleEvent(JSONObject eventObject) throws JSONException;
}