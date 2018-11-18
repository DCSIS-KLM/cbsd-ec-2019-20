package org.sose.travelprovider.service.consumer;

import org.sose.messagetypes.Invoice;
import org.sose.messagetypes.Quote;

public interface TravelConsumerEndpointInterface {
	public void receiveQuote(Quote q);
	public void receiveInvoice(Invoice i);
}
