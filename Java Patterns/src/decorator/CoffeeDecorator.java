package decorator;

/**
 * Abstract decorator class - note that it extends the Coffee abstract class
 */
public abstract class CoffeeDecorator extends Coffee {
  protected final Coffee decoratedCoffee;

  /**
   * Wraps a Coffee object inside an object of one of
   * CoffeeDecorator's subclasses
   */
  public CoffeeDecorator(Coffee decoratedCoffee) {
    this.decoratedCoffee = decoratedCoffee;
  }

  /**
   * Provides the wrapper with the Coffee interface and delegates
   * its methods to the wrapped Coffee object.
   */
  @Override
  public double getCost() {
    return decoratedCoffee.getCost();
  }

  @Override
  public String getIngredients() {
    return decoratedCoffee.getIngredients();
  }
}