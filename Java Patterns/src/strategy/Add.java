package strategy;

/**
 * A concrete Strategy that implements a addition operation
 */
class Add implements Strategy {
  @Override
  public int execute(int a, int b) {
    System.out.println("Called Add's execute()");
    return a + b;  // Do an addition with a and b
  }
}
 