package org.sose.travelprovider.backend;

import java.util.HashMap;
import java.util.Hashtable;

import org.osgi.framework.BundleContext;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.sose.hotelprovider.service.consumer.HotelConsumerEndpointInterface;
import org.sose.hotelprovider.service.provider.HotelProviderEndpointInterface;
import org.sose.messagetypes.BookingInformation;
import org.sose.messagetypes.RoomReservation;
import org.sose.travelprovider.service.consumer.TravelConsumerEndpointInterface;

public class TravelProviderBackend implements HotelConsumerEndpointInterface,
		EventHandler {

	private HotelProviderEndpointInterface hotelProvider;

	private EventAdmin ea;

	private TravelConsumerEndpointInterface customer;

	public synchronized void bindHotelProvider(
			HotelProviderEndpointInterface srv) {
		System.out.println("Hotel provider bound");
		this.hotelProvider = srv;

	}

	public synchronized void unbindHotelProvider(
			HotelProviderEndpointInterface srv) {
		if (this.hotelProvider == srv) {
			System.out.println("Hotel provider unbound");
			this.hotelProvider = null;
		}
	}

	public synchronized void bindConsumer(TravelConsumerEndpointInterface srv) {
		System.out.println("Travel customer bound");
		this.customer = srv;
	}

	public synchronized void unbindConsumer(TravelConsumerEndpointInterface srv) {
		if (this.customer == srv)
			this.customer = null;
	}

	synchronized public void bindEventAdmin(EventAdmin ea) {
		System.out.println("EventAdmin bound");
		this.ea = ea;
	}

	synchronized public void unbindEventAdmin(EventAdmin ea) {
		if (this.ea == ea) {
			this.ea = null;
		}
	}

	public void receiveBookingInformation(BookingInformation inf) {
		System.out.println("receiveBookingInformation called");

		if (this.ea != null) {
			HashMap<String, Object> m = new HashMap<String, Object>();
			m.put("bookinginformation", inf);
			Event event = new Event(
					"org/sose/travelprovider/bookinginformation", m);
			ea.postEvent(event);
			System.out.println("Event posted: " + event.toString());
		}

	}

	public void handleEvent(Event event) {
		System.out.println("TravelProviderBackend received event: "
				+ event.getTopic());

		if (event.getTopic().equalsIgnoreCase(
				"org/sose/travelprovider/travelinformation")) {
			System.out.println("Travel information available. ");
			RoomReservation res = new RoomReservation();
			res.setDate("13 Mar 2013");
			res.setRooms(5);
			res.setId("TRIP-ID-"+(int) (Math.random()*1000));
			hotelProvider.receiveRoomReservation(res);
		}
	}

	protected void activate(BundleContext context) {
		System.out.println(this.getClass().getName() + " activated.");

		System.out.println("customer: " + this.customer);
		System.out.println("hotel provider: " + this.hotelProvider);
		System.out.println("event admin: " + this.ea);

		/*
		 * Now we can register our event subscriptions..
		 */
		String[] topics = new String[] { 
				"org/sose/travelprovider/travelinformation",
				"org/sose/travelprovider/payment",
				"org/sose/travelprovider/acceptance",
				"org/sose/travelprovider/rejection"
		};
		Hashtable<String, String[]> ht = new Hashtable<String, String[]>();
		ht.put(EventConstants.EVENT_TOPIC, topics);
		context.registerService(EventHandler.class.getName(), this, ht);

	}
	
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub

	}

}
