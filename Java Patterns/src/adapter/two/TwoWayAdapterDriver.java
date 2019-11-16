package adapter.two;

/**
 * Driver class for two way Peg Adapter.
 */
public class TwoWayAdapterDriver {
  public static void main(String args[]) {

    // Create some pegs.
    RoundPeg roundPeg = new RoundPeg();
    SquarePeg squarePeg = new SquarePeg();

    // Do an insert using the square peg.
    squarePeg.insert("I am a SquarePeg into a square hole.");

    // Create a two-way adapter and do an insert with it.
    ISquarePeg wannabeRound = new PegAdapter(roundPeg);
    wannabeRound.insert("I am a SquarePeg into a round hole!");

    // Do an insert using the round peg.
    roundPeg.insertIntoHole("I am a RoundPeg into a round hole.");

    // Create a two-way adapter and do an insert with it.
    IRoundPeg wannabeSquare = new PegAdapter(squarePeg);
    wannabeSquare.insertIntoHole("I am a RoundPeg into a square hole!");
  }
}
