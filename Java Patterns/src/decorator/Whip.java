package decorator;

/**
 * Decorator that mixes Whip with coffee.
 * It is a subclass of CoffeeDecorator, and thus a subclass of Coffee.
 */
class Whip extends CoffeeDecorator {
  /**
   * When creating a decorated Coffee, pass a Coffee to be decorated
   * as a parameter. Note that this can be an already-decorated Coffee.
   */
  public Whip(Coffee decoratedCoffee) {
    super(decoratedCoffee);
  }

  /**
   * Overriding methods defined in the abstract superclass.
   * Enables to provide different behavior for decorated Coffee methods
   */
  @Override
  public double getCost() {
    return super.getCost() + 0.7;
  }

  @Override
  public String getIngredients() {
    return super.getIngredients() + ", Whip";
  }

  /**
   * May also add additional members for decorated-specific data or behaviour
   */
}