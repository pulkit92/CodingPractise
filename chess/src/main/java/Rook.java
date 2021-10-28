public class Rook extends Piece {
  public Rook(boolean isWhite) {
    super(isWhite);
  }

  @Override public boolean canMove(Board board, Spot start, Spot end) {
    if (start.getX() == end.getX() && Math.abs(start.getY() - end.getY()) > 0) {
      return true;
    }
    if (start.getY() == end.getY() && Math.abs(start.getX() - end.getX()) > 0) {
      return true;
    }
    return false;
  }
}
