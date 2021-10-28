public class King extends Piece {
  public King(boolean isWhite) {
    super(isWhite);
  }

  @Override public boolean canMove(Board board, Spot start, Spot end) {
    return false;
  }
}
