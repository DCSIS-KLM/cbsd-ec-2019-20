package org.sose.travelprovider.service.provider;

import org.sose.messagetypes.AcceptanceMessage;
import org.sose.messagetypes.Payment;
import org.sose.messagetypes.RejectionMessage;
import org.sose.messagetypes.TravelInformation;

public interface TravelProviderEndpointInterface {
	void receiveTravelInformation(TravelInformation info);
	void receiveRejection(RejectionMessage msg);
	void receiveAcceptance(AcceptanceMessage msg);
	void receivePayment(Payment msg);
}
