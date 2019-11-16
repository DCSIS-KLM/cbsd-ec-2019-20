package adapter.two;

/**
 * The PegAdapter class; this is a two-way adapter class.
 */
public class PegAdapter implements ISquarePeg, IRoundPeg {
  private RoundPeg roundPeg;
  private SquarePeg squarePeg;

  public PegAdapter(RoundPeg peg) {
    this.roundPeg = peg;
  }

  public PegAdapter(SquarePeg peg) {
    this.squarePeg = peg;
  }

  @Override
  public void insert(String str) {
    roundPeg.insertIntoHole(str);
  }

  @Override
  public void insertIntoHole(String msg) {
    squarePeg.insert(msg);
  }
}
