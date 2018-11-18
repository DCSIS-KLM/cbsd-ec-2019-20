package org.sose.hotelprovider.service.consumer;

import org.sose.messagetypes.BookingInformation;

public interface HotelConsumerEndpointInterface {
	void receiveBookingInformation(BookingInformation inf);
}
