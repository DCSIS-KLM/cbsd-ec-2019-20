package builder;

/**
 * Concrete Builder of the Builder Pattern
 */
public class TropicalShelterBuilder extends ShelterBuilder {
  @Override
  public void buildRoof() {
    shelterProduct.setRoof("palm tree leaves");       // The construction process may vary
  }                                                   // across the different Concrete Builders

  @Override
  public void buildStructure() {
    shelterProduct.setStructure("bamboo");
  }

  @Override
  public void buildFloor() {
    shelterProduct.setFloor("goat skin");
  }
}
