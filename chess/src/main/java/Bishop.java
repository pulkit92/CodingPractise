public class Bishop extends Piece {
  public Bishop(boolean isWhite) {
    super(isWhite);
  }

  @Override public boolean canMove(Board board, Spot start, Spot end) {
    if (Math.abs(start.getY() - end.getY()) == Math.abs(start.getX() - end.getX())) {
      return true;
    }
    return false;
  }
}
