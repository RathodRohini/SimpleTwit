package subscription.interfaces;

import subscription.SubscriptionNoticeType;

public interface PayloadNoticeInterface {

	public void setType(SubscriptionNoticeType type);
	public SubscriptionNoticeType getType();
	public void setMessage(String message);
	public String getMessage();
	
}
