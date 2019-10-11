package org.cdi.advocacy;

//change from previous version
@SuperFast @StandardFrameRelaySwitchingFlubber 
public class SuperFastAtmTransport implements ATMTransport {
    public void communicateWithBank(byte[] datapacket) {
        System.out.println("communicating with bank via the Super Fast transport " );
    }
}
