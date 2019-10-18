import java.rmi.RemoteException;

public class TestStringObject implements TestString {
    private String testString;

    TestStringObject (String testString) {
	this.testString = testString;
    }

    public String getTestString() throws RemoteException {
	return testString;
    }
}
