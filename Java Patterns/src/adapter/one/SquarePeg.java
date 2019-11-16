package adapter.one;

/**
 * The SquarePeg class; this is the Target class.
 */
public class SquarePeg {
  /**
   * This is the interface that the client class knows about Pegs
   */
  public void insert(String str) {
    System.out.println("SquarePeg insert(): " + str);
  }
}
