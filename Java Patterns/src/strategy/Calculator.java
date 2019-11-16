package strategy;

/**
 * Class configured with a ConcreteStrategy object and maintains
 * a reference to a Strategy object. Depending on which strategy is
 * plugged in, it will execute a different operation.
 */
class Calculator {
  private Strategy strategy;

  /**
   * Plugs in a specific strategy to be used
   *
   * @param strategy The operator to be applied when executeStrategy() is called
   */
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  /**
   * Method that executes a different strategy depending on what strategy was
   * plugged in upon instantiation
   *
   * @param a First operand of the operation
   * @param b Second operand of the operation
   * @return result of the specific operation implemented by the strategy that
   * was plugged in when the Context object was created.
   */
  public int executeStrategy(int a, int b) {
    return this.strategy.execute(a, b);
  }
}