package decorator;

/**
 * Kind of Coffee
 */
public class SimpleCoffee extends Coffee {
  @Override
  public double getCost() {
    return 1;
  }

  @Override
  public String getIngredients() {
    return "Coffee";
  }
}