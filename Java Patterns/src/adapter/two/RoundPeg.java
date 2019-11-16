package adapter.two;

/**
 * The RoundPeg Target/Adaptee class.
 */
public class RoundPeg implements IRoundPeg {
  @Override
  public void insertIntoHole(String msg) {
    System.out.println("RoundPeg insertIntoHole(): " + msg);
  }
}
