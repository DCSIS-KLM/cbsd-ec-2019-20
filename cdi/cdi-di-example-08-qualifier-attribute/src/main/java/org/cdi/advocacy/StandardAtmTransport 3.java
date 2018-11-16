package org.cdi.advocacy;


@Transport(type=TransportType.STANDARD) // change from previous version
public class StandardAtmTransport implements ATMTransport {
	
	public void communicateWithBank(byte[] datapacket) {
		System.out.println("communicating with bank via Standard transport");
	}

}
