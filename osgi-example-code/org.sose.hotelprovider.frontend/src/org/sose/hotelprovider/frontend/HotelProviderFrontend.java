package org.sose.hotelprovider.frontend;

import java.util.HashMap;
import java.util.Hashtable;

import org.osgi.framework.BundleContext;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.sose.hotelprovider.service.provider.HotelProviderEndpointInterface;
import org.sose.messagetypes.RoomReservation;

public class HotelProviderFrontend implements HotelProviderEndpointInterface, EventHandler {

	private EventAdmin ea = null;
	
	synchronized public void bindEventAdmin(EventAdmin ea) {
		this.ea = ea;
	}
	
	synchronized public void unbindEventAdmin(EventAdmin ea) {
		if(this.ea == ea) {
			this.ea = null;
		}
	}
	

	public void handleEvent(Event event) {
		System.out.println(this.getClass().getName() + " received event " + event.getTopic());
	}

	public void receiveRoomReservation(RoomReservation res) {
		System.out.println("Room reservation received: " + res.getDate() + " for " + res.getRooms() + " rooms.");
		if(this.ea != null) {
			HashMap<String, Object> m = new HashMap<String,Object>();
			m.put("reservation", res);
			Event e = new Event("org/sose/hotelprovider/reservation", m);
			System.out.println("Send event " + e.getTopic());
			ea.postEvent(e);
		} else {
			System.err.println("EventAdmin not found for " + this.getClass().getName());
		}
	}

	protected void activate(BundleContext context) {

		System.out.println(this.getClass().getName() + " activated");

		String[] topics = new String[] {"org/sose/hotelprovider/*"};
		Hashtable<String, String[]> ht = new Hashtable<String, String[]>();
		ht.put(EventConstants.EVENT_TOPIC, topics);
		context.registerService(EventHandler.class.getName(), this, ht);
	}

}
