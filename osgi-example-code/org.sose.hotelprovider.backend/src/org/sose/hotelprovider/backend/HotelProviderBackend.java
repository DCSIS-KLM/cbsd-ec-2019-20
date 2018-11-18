package org.sose.hotelprovider.backend;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.sose.hotelprovider.service.consumer.HotelConsumerEndpointInterface;
import org.sose.messagetypes.BookingInformation;
import org.sose.messagetypes.RoomReservation;

public class HotelProviderBackend implements EventHandler {

	private HotelConsumerEndpointInterface consumer;
	private EventAdmin ea;

	synchronized public void bindEventAdmin(EventAdmin ea) {
		this.ea = ea;
	}
	
	synchronized public void unbindEventAdmin(EventAdmin ea) {
		if(this.ea == ea) {
			this.ea = null;
		}
	}

	synchronized public void bindConsumer(HotelConsumerEndpointInterface srv) {
		System.out.println("Hotel consumer bound");
		this.consumer = srv;
	}
	
	synchronized public void unbindConsumer(HotelConsumerEndpointInterface srv) {
		System.out.println("Hotel consumer unbound");
		if(this.consumer == srv) {
			srv = null;
		}
	}

	public void handleEvent(Event event) {
		System.out.println(this.getClass().getName() + " received event " + event.getTopic());
		
		if(event.getTopic().equalsIgnoreCase("org/sose/hotelprovider/reservation")) {
			RoomReservation res = (RoomReservation) event.getProperty("reservation");
			System.out.println("Handling room reservation " + res.getId() + " " + res.getDate() + " for " + res.getRooms() + " rooms.");

			// Make a callback using method in HotelConsumerEndpointInterface
			BookingInformation inf = new BookingInformation();
			inf.setId(res.getId());
			int roomsBooked = (int) (Math.random()*res.getRooms());
			inf.setRoomsBooked(roomsBooked);
			consumer.receiveBookingInformation(inf);
		}
	}

	protected void activate(BundleContext context) {

		System.out.println(this.getClass().getName() + " started");

		String[] topics = new String[] {"org/sose/hotelprovider/reservation"};
		Hashtable ht = new Hashtable();
		ht.put(EventConstants.EVENT_TOPIC, topics);
		context.registerService(EventHandler.class.getName(), this, ht);
	}

}
