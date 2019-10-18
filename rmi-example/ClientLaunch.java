import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientLaunch {
    public static void main(String[] args) {
	String host = (args.length < 1) ? null : args[0];
	try {
	    Registry registry = LocateRegistry.getRegistry(host);
	    TestString stub = (TestString) registry.lookup("Test1");
	    String response = stub.getTestString();
	    System.out.println("\nTest string is: " + response);
	} catch (Exception e) {
	    System.err.println("Client exception: " + e.toString());
	    e.printStackTrace();
	}
    }
}
