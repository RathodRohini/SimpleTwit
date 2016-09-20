package twit;

import java.util.Date;

public class TwitHandler {

	public TwitImplementation createTwit(String twit) {
		
		TwitImplementation createdTwit = new TwitImplementation(String.valueOf(Math.random()), twit, new java.sql.Timestamp(new Date().getTime()));

		return createdTwit;
	}

}
