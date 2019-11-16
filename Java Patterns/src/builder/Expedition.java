package builder;

/**
 * Driver class for the Shelter Builder exercise
 */
public class Expedition {
  public static void main(String[] args) {
    Explorer explorer;
    Shelter hut, igloo;

    ShelterBuilder tropicalBuilder = new TropicalShelterBuilder();
    ShelterBuilder polarBuilder = new PolarShelterBuilder();

    explorer = new Explorer();

    explorer.setBuilder(tropicalBuilder);
    explorer.constructShelter();
    hut = explorer.getShelter();
    System.out.println(hut);

    explorer.setBuilder(polarBuilder);
    explorer.constructShelter();
    igloo = explorer.getShelter();
    System.out.println(igloo);
  }
}
