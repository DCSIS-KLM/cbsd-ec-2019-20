package decorator;

/**
 * Driver class for the Coffee Decorator example
 */
public class DecoratorDriver {

  public static final void main(String[] args) {
    Coffee c = new SimpleCoffee();
    print(c);

    print(new Milk(c));

    print(new Sprinkles(c));

    print(new Whip(c));

    // Note that you can also stack more than one decorator of the same type
    print(new Sprinkles(c));

    print(new Espresso());

    print(new Milk(c));
  }

  private static void print(Coffee c) {
    System.out.println("Cost: £" + c.getCost() + "; Ingredients: " + c.getIngredients());
  }
}