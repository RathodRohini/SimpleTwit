package subscription.interfaces;

import subscription.SubscriptionNoticeType;

public interface PayloadInterface {
	public void setAccount(SubscriptionAccountInterface account);
	public SubscriptionAccountInterface getAccount();
	public void setOrder(OrderInterface order);
	public OrderInterface getOrder();
	public void setCompany(CompanyInterface company);
	public CompanyInterface getCompany();
	public void setNotice(PayloadNoticeInterface notice);
	public PayloadNoticeInterface getNotice();
}