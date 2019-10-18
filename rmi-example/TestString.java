import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TestString extends Remote {
    String getTestString() throws RemoteException;
}
