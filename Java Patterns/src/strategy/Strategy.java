package strategy;

/**
 * The classes that implement a concrete strategy should implement this.
 * The Calculator class uses this to use a concrete strategy.
 */
interface Strategy {
  /**
   * Method whose implementation varies depending on the strategy adopted.
   */
  int execute(int a, int b);
}