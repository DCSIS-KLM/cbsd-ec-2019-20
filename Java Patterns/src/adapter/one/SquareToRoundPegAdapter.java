package adapter.one;

/**
 * The SquareToRoundPegAdapter class.
 * This is the Adapter class.
 * It adapts a SquarePeg to a RoundPeg.
 * Its interface is that of a SquarePeg.
 */
public class SquareToRoundPegAdapter extends SquarePeg {
  /**
   * The adapter contains the RoundPeg Adaptee
   */
  private RoundPeg roundPeg;

  /**
   * Upon creation, the Adapter is plugged into the RoundPeg Adaptee
   */
  public SquareToRoundPegAdapter(RoundPeg peg) {
    //the roundPeg is plugged into the adapter
    this.roundPeg = peg;
  }

  /**
   * The Adapter provides the Target's method and translates it
   * to the corresponding Adaptee's method call.
   */
  public void insert(String str) {
    //the roundPeg can now be inserted in the same manner as a squarePeg!
    roundPeg.insertIntoHole(str);
  }
}
