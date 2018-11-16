package org.cdi.advocacy;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

@Named("atm")
public class AutomatedTellerMachineImpl implements AutomatedTellerMachine {

	private ATMTransport transport;
	
	@Inject
	@Soap
	private ATMTransport soapTransport;

	// change from previous version
	@Inject
	@Json
	private ATMTransport jsonTransport;

	// change from previous version
	@Inject
	@Json
	private ATMTransport standardTransport;
	
    //These could be looked up in a DB, JNDI or a properties file.
    private boolean useJSON = true;
    private boolean behindFireWall = true;

    // change from previous version
    @PostConstruct
    protected void init() {
                	
    	//Look up values for useJSON and behindFireWall	
        if (!behindFireWall) {
            transport = standardTransport;
        } else {
            if (useJSON) {
                transport = jsonTransport;
            } else {
                transport = soapTransport;
            }
        }

    }

	public void deposit(BigDecimal bd) {
		System.out.println("deposit called");
		transport.communicateWithBank(null);
	}

	public void withdraw(BigDecimal bd) {
		System.out.println("withdraw called");
		transport.communicateWithBank(null);
	}

}
