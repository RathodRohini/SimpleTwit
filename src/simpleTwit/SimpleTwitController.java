package simpleTwit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import twit.*;

@Controller
public class SimpleTwitController {

	List<TwitImplementation> twits = new ArrayList<TwitImplementation>();
	Map<String, List<String>> userTwits = new HashMap<String, List<String>>();

	@RequestMapping("/add/{userId}/{twit}")
	@ResponseBody
	public String addTwit(@PathVariable String userId, @PathVariable String twit) {

		TwitHandler handler = new TwitHandler();

		TwitImplementation createdTwit = handler.createTwit(twit);
		twits.add(createdTwit);

		List<String> tempTwits = new ArrayList<String>();

		if(userTwits.get(userId) != null)
			tempTwits = userTwits.get(userId);

		tempTwits.add(createdTwit.getTwitId());

		userTwits.put(userId, tempTwits);

		return "Twit added.";
	}

	@RequestMapping("/getTwits/{userId}")
	@ResponseBody
	public String getTwits(@PathVariable String userId) {

		List<String> twitIds = new ArrayList<String>();
		List<String> twits = new ArrayList<String>();

		if(userTwits.containsKey(userId))
			twitIds = userTwits.get(userId);

		for(int userTwitIndex = 0; userTwitIndex< twitIds.size(); userTwitIndex++) {
			for(int twitIndex = 0; twitIndex< this.twits.size(); twitIndex++) {
				if(this.twits.get(twitIndex).getTwitId().equalsIgnoreCase(twitIds.get(userTwitIndex)))
					twits.add(this.twits.get(twitIndex).getTwit());
			}

		}

		return twits.toString();

	}

}
