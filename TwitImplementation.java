package twit;

import java.security.Timestamp;

public class TwitImplementation implements TwitInterface {


	private String twitId;
	private String twit;
	private java.sql.Timestamp timeStamp;
	
	@Override
	public void setTwitId(String id) {
		this.twitId = id;
	}

	@Override
	public String getTwitId() {
		return this.twitId;
	}

	@Override
	public void setTwit(String twit) {
		this.twit = twit;
	}

	@Override
	public String getTwit() {
		return this.twit;
	}

	@Override
	public void setTime(java.sql.Timestamp time) {
		this.timeStamp = time;
	}

	@Override
	public java.sql.Timestamp getTime() {
		return this.timeStamp;
	}

	public TwitImplementation(String id, String twit, java.sql.Timestamp timestamp2) {
		this.twitId = id;
		this.twit = twit;
		this.timeStamp = timestamp2;
	}

	
}
