package org.cdi.advocacy;


@Transport(type=TransportType.JSON) // change from previous version	
public class JsonRestAtmTransport implements ATMTransport {

	public void communicateWithBank(byte[] datapacket) {
		System.out.println("communicating with bank via JSON REST transport");
	}

}
