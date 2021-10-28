public class Knight extends Piece {
  public Knight(boolean isWhite) {
    super(isWhite);
  }

  @Override public boolean canMove(Board board, Spot start, Spot end) {
    if (end.getPiece().isWhite() == isWhite()) {
      return false;
    }
    int vertical = Math.abs(start.getX() - end.getX());
    int horizontal = Math.abs(start.getY() - end.getY());
    if (vertical * horizontal == 2) {
      return true;
    }
    return false;
  }
}
