public class Queen extends Piece {
  public Queen(boolean isWhite) {
    super(isWhite);
  }

  @Override public boolean canMove(Board board, Spot start, Spot end) {
    return true;
  }
}
