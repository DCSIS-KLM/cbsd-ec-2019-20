package singleton;

public class SingleObject {
  /**
   * create an object of SingleObject embedded as a static member of the class itself
   */
  private static SingleObject instance;

  static {
    instance = new SingleObject();
  }

  /**
   * Make the constructor private so that this class cannot be instantiated
   */
  private SingleObject() {
  }

  /**
   * As the instance has already been created just return the reference.
   */
  public static SingleObject getInstance() {
    return instance;
  }

  public void showMessage() {
    System.out.println(this.hashCode());
  }
}