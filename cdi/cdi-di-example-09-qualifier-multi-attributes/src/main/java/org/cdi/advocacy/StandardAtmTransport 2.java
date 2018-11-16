package org.cdi.advocacy;


@Transport(type=TransportType.STANDARD, priorityLevel=1)
public class StandardAtmTransport implements ATMTransport {
	
	public void communicateWithBank(byte[] datapacket) {
		System.out.println("communicating with bank via Standard transport");
	}
}
