public class Pawn extends Piece {
  public Pawn(boolean isWhite) {
    super(isWhite);
  }

  @Override public boolean canMove(Board board, Spot start, Spot end) {

    if (end.getX() - start.getX() == 2 || end.getX() - start.getX() == 1) {
      return true;
    }
    return false;
  }
}
