package org.sose.traveller;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.sose.messagetypes.Invoice;
import org.sose.messagetypes.Quote;
import org.sose.messagetypes.TravelInformation;
import org.sose.travelprovider.service.consumer.TravelConsumerEndpointInterface;
import org.sose.travelprovider.service.provider.TravelProviderEndpointInterface;

public class TravellerApplication implements BundleActivator, TravelConsumerEndpointInterface {

	private TravelProviderEndpointInterface service;
	
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		TravellerApplication.context = bundleContext;
		System.out.println("Traveller bundle started.");

	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		TravellerApplication.context = null;
	}

	public synchronized void bindService(TravelProviderEndpointInterface srv)  {
		System.out.println("Travel provider bound");
		this.service = srv;

		TravelInformation info = new TravelInformation();
		info.setDestination("Goa, India");
		
		if(service != null) {
			service.receiveTravelInformation(info);
		} else {
			System.out.println("Couldn't find TravelProvider service!");
		}


	}
	
	public synchronized void unbindService(TravelProviderEndpointInterface srv) {
		if(service == srv) {
			service = null;
		}
	}

	public void receiveQuote(Quote q) {
		System.out.println("Customer received quote for " + q.getSum());
	}

	public void receiveInvoice(Invoice i) {
		System.out.println("Customer received invoice for " + i.getSum());
	}
}
