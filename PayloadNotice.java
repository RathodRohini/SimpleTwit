package subscription.implementations;

import subscription.SubscriptionNoticeType;
import subscription.interfaces.PayloadNoticeInterface;

public class PayloadNotice implements PayloadNoticeInterface {

	private SubscriptionNoticeType type;
	private String message;
	
	
	
	public PayloadNotice(String type, String message) {
		this.type = SubscriptionNoticeType.valueOf(type);
		this.message = message;
	}

	@Override
	public void setType(SubscriptionNoticeType type) {
		this.type = type;
	}

	@Override
	public SubscriptionNoticeType getType() {
		return this.type;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
