package strategy;

/**
 * Driver class to test the Strategy pattern
 */
class StrategyExample {
  public static void main(String[] args) {
    Calculator calculator = new Calculator();

    // Three contexts following different strategies
    calculator.setStrategy(new Add());
    int resultA = calculator.executeStrategy(3, 4);
    System.out.println("Result A : " + resultA);

    calculator.setStrategy(new Subtract());
    int resultB = calculator.executeStrategy(3, 4);
    System.out.println("Result B : " + resultB);

    calculator.setStrategy(new Multiply());
    int resultC = calculator.executeStrategy(3, 4);
    System.out.println("Result C : " + resultC);
  }
}