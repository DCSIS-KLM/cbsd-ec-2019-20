package org.cdi.advocacy;


@Transport(type=TransportType.JSON) 
public class JsonRestAtmTransport implements ATMTransport {

	public void communicateWithBank(byte[] datapacket) {
		System.out.println("communicating with bank via JSON REST transport");
	}

}
