package factory;

/**
 * Shape Factory that creates different kinds of Shape objects
 * by calling its static factory method.
 */
public class ShapeFactory {
  /**
   * Constructor is made private to prevent instantiation
   */
  private ShapeFactory() {
  }

  /**
   * Static method to create objects
   * Change is required only in this function
   *
   * @param shapeType Variation factor of the Factory whose value determines
   *                  what kind of shape will be created
   * @return a Shape object whose type depends on the value of the variation factor
   */
  static public Shape getShape(String shapeType) {
    if (shapeType.equalsIgnoreCase("CIRCLE")) {
      return new Circle();
    } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
      return new Rectangle();
    } else if (shapeType.equalsIgnoreCase("SQUARE")) {
      return new Square();
    }
    return null;
  }
}