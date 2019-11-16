package builder;

public class PolarShelterBuilder extends ShelterBuilder {
  @Override
  public void buildRoof() {                       // Build the different parts of the Shelter
    shelterProduct.setRoof("ice dome");
  }

  @Override
  public void buildStructure() {                  // The construction of the Shelter parts
    shelterProduct.setStructure("ice blocks"); // depends on the type of Shelter being built
  }

  @Override
  public void buildFloor() {                      // The construction process in a real-life
    shelterProduct.setFloor("caribou skin");   // example may be more complex.
  }
}