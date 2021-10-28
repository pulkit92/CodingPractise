public abstract class Piece {
  public boolean isWhite() {
    return isWhite;
  }

  public void setWhite(boolean white) {
    isWhite = white;
  }

  public boolean isKilled() {
    return killed;
  }

  public void setKilled(boolean killed) {
    this.killed = killed;
  }

  private boolean isWhite = false;
  private boolean killed = false;

  public Piece(boolean isWhite) {
    this.isWhite = isWhite;
  }

  public abstract boolean canMove(Board board,
      Spot start, Spot end);
}
