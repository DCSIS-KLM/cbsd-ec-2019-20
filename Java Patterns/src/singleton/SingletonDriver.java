package singleton;

public class SingletonDriver {
  public static void main(String[] args) {

    // Get the only object available
    SingleObject object = SingleObject.getInstance();

    // Use the Singleton
    object.showMessage();

    // Check there is only one instance

    SingleObject objectTwo = SingleObject.getInstance();

    object.showMessage();
    objectTwo.showMessage();
  }
}