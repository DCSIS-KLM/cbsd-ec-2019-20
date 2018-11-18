package org.sose.travelprovider.frontend;

import java.util.HashMap;
import java.util.Hashtable;

import org.osgi.framework.BundleContext;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.sose.messagetypes.AcceptanceMessage;
import org.sose.messagetypes.BookingInformation;
import org.sose.messagetypes.Payment;
import org.sose.messagetypes.Quote;
import org.sose.messagetypes.RejectionMessage;
import org.sose.messagetypes.TravelInformation;
import org.sose.travelprovider.service.consumer.TravelConsumerEndpointInterface;
import org.sose.travelprovider.service.provider.TravelProviderEndpointInterface;

public class TravelProviderFrontEnd implements TravelProviderEndpointInterface, EventHandler {

	private EventAdmin ea = null;
	private TravelConsumerEndpointInterface consumer = null;
	
	synchronized public void bindEventAdmin(EventAdmin ea) {
		System.out.println("EventAdmin bound for " + this.getClass().getName());
		this.ea = ea;
	}
	
	synchronized public void unbindEventAdmin(EventAdmin ea) {
		if(this.ea == ea) {
			this.ea = null;
		}
	}

	synchronized public void bindConsumer(TravelConsumerEndpointInterface srv) {
		this.consumer = srv;
	}
	
	synchronized public void unbindConsumer(TravelConsumerEndpointInterface srv) {
		if(this.consumer == srv) {
			this.consumer = null;
		}
	}
	
	public void receiveTravelInformation(TravelInformation info) {
		System.out.println("receiveTravelInformation called.");
		System.out.println("Destination is " + info.getDestination());
		
		HashMap<String,Object> m = new HashMap<String,Object>();
		m.put("travelinformation", info);
		Event event = new Event("org/sose/travelprovider/travelinformation", m) ;
		System.out.println("Publishing event: " + event.toString());
		ea.sendEvent(event);
	}

	public void receiveRejection(RejectionMessage msg) {
		System.out.println("receiveRejection called");
		
		HashMap<String,Object> m = new HashMap<String,Object>();
		m.put("rejection", msg);
		Event event = new Event("org/sose/travelprovider/rejection", m);
		ea.postEvent(event);
		System.out.println("Event posted: " + event.toString());
	}

	public void receiveAcceptance(AcceptanceMessage msg) {
		System.out.println("receiveAcceptance called");
		
		if(this.ea != null) {
			HashMap<String,Object> m = new HashMap<String,Object>();
			m.put("acceptance", msg);
			Event event = new Event("org/sose/travelprovider/acceptance", m);
			ea.postEvent(event);
			System.out.println("Event posted: " + event.toString());
		}
		
	}

	public void receivePayment(Payment msg) {
		System.out.println("receivePayment called");
		
		HashMap<String, Object> m = new HashMap<String, Object>();
		m.put("payment", msg);
		Event event = new Event("org/sose/travelprovider/payment", m);
		ea.postEvent(event);
		System.out.println("Event posted: " + event.toString());
	}

	public void handleEvent(Event event) {
		System.out.println("TravelProviderFrontend received event: " + event.getTopic());
		
		if(event.getTopic().equalsIgnoreCase("org/sose/travelprovider/bookinginformation")) {
			BookingInformation inf = (BookingInformation) event.getProperty("bookinginformation");
			System.out.println("BookinInformation received: " + inf.getId() + " with " + inf.getRoomsBooked() + " rooms booked ");

			// Travel provider consumer callback..			
			Quote q = new Quote();
			q.setId(inf.getId());
			q.setSum(inf.getRoomsBooked()*500);
			consumer.receiveQuote(q);
		}
		
	}

	protected void activate(BundleContext context) {

		System.out.println(this.getClass().getName() + " activated");

		String[] topics = new String[] {"org/sose/travelprovider/bookinginformation"};
		Hashtable<String, String[]> ht = new Hashtable<String, String[]>();
		ht.put(EventConstants.EVENT_TOPIC, topics);
		context.registerService(EventHandler.class.getName(), this, ht);
	}

}
