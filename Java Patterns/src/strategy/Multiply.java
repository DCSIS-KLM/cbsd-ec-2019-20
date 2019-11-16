package strategy;

/**
 * A concrete Strategy that implements a multiplication operation
 */
class Multiply implements Strategy {
  @Override
  public int execute(int a, int b) {
    System.out.println("Called Multiply's execute()");
    return a * b;   // Do a multiplication with a and b
  }
}