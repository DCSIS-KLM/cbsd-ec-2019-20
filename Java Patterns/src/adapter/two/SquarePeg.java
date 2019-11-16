package adapter.two;

/**
 * The SquarePeg Target/Adaptee class.
 */
public class SquarePeg implements ISquarePeg {
  @Override
  public void insert(String str) {
    System.out.println("SquarePeg insert(): " + str);
  }
}
