package org.sose.hotelprovider.service.provider;

import org.sose.messagetypes.RoomReservation;

public interface HotelProviderEndpointInterface {
	void receiveRoomReservation(RoomReservation res);
}
