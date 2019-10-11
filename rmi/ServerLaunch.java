import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Simple test of RMI functionality.  This example is based on one
// at http://docs.oracle.com/javase/1.5.0/docs/guide/rmi/hello/hello-world.html

public class ServerLaunch {
    public static void main(String[] args) {
//        if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new SecurityManager());
//        }
	try {
	    // Create the remote object and get its stub
	    TestStringObject obj = new TestStringObject("Hello, happy world!");
	    TestString stub = (TestString) UnicastRemoteObject.exportObject(obj,0);
	    
	    // Find the registry and register the stub
	    Registry registry = LocateRegistry.getRegistry();
	    registry.bind("Test1", stub);

	    // Print ready message
	    System.err.println("Server ready");
	} catch (Exception e) {
	    System.err.println("Server exception: " + e.toString());
	    e.printStackTrace();
	}
    }
}
