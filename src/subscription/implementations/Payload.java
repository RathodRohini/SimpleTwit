package subscription.implementations;

import subscription.SubscriptionNoticeType;
import subscription.interfaces.CompanyInterface;
import subscription.interfaces.OrderInterface;
import subscription.interfaces.PayloadInterface;
import subscription.interfaces.PayloadNoticeInterface;
import subscription.interfaces.SubscriptionAccountInterface;

public class Payload implements PayloadInterface {

	private SubscriptionAccountInterface account;
	private OrderInterface order;
	private CompanyInterface company;
	private PayloadNoticeInterface notice;
	
	public Payload(SubscriptionAccountInterface account, OrderInterface order,
			CompanyInterface company, PayloadNoticeInterface notice) {
		this.account = account;
		this.order = order;
		this.company = company;
		this.notice = notice;
	}

	@Override
	public void setAccount(SubscriptionAccountInterface account) {
		this.account = account;
	}

	@Override
	public SubscriptionAccountInterface getAccount() {
		return this.account;
	}

	@Override
	public void setOrder(OrderInterface order) {
		this.order = order;
	}

	@Override
	public OrderInterface getOrder() {
		return this.order;
	}

	@Override
	public void setCompany(CompanyInterface company) {
		this.company = company;
	}

	@Override
	public CompanyInterface getCompany() {
		return this.company;
	}

	@Override
	public void setNotice(PayloadNoticeInterface notice) {
		this.notice = notice;
	}

	@Override
	public PayloadNoticeInterface getNotice() {
		return this.notice;
	}

}