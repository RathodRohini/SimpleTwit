package twit;

import java.security.Timestamp;

public interface TwitInterface {
	
	public void setTwitId(String id);
	public String getTwitId();
	public void setTwit(String twit);
	public String getTwit();
	public void setTime(java.sql.Timestamp time);
	public java.sql.Timestamp getTime();
	
}