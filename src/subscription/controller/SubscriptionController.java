package subscription.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.json.*;

import subscription.SubscriptionHandler;

@Controller
public class SubscriptionController {
	
	@RequestMapping("/test")
	public @ResponseBody String testURL() {
		return "test";
	}
	
	@RequestMapping("/json")
	public @ResponseBody String exampleJsonString() {
		String testJSONString = "{\"key1\":\"value1\", \"key2\":\"value2\"}"; 
		return testJSONString;
	}
	
	@RequestMapping("/event/{eventUrl}")
	public @ResponseBody JSONObject getEventUrl(@PathVariable String eventUrl) throws Exception {
		
		//OAuth
		
		
		/*
		 * handle request:
		 *1) GET to the unique URL given by AppDirect
		 *2) get event data
		 *3) Create corresponding subscription object in app
		 *4) send response data; 
		 */
		 
		SubscriptionHandler subscriptionHandler = new SubscriptionHandler();
		JSONObject responseJSON = subscriptionHandler.handleRequest(eventUrl);
		
		return responseJSON;
		
	}
	
}