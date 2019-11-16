package adapter.one;

/**
 * Driver program using the Peg Adapter
 */
public class AdapterDriver {
  public static void main(String args[]) {

    // Create some pegs.
    RoundPeg roundPeg = new RoundPeg();
    SquarePeg squarePeg = new SquarePeg();

    // Do an insert using the square peg (standard).
    squarePeg.insert("I am a SquarePeg in a square hole.");

    // Now we'd like to do an insert using the round peg.
    // But this client only understands the insert()
    // method of pegs, not a insertIntoHole() method.
    // The solution: create an adapter that adapts
    // a square peg to a round peg!

    SquarePeg wannabeRound = new SquareToRoundPegAdapter(roundPeg);
    wannabeRound.insert("I am a SquarePeg in a round hole!");
  }
}
