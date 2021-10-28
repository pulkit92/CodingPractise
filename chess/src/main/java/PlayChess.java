public class PlayChess {
  public static void main(String args[]) throws Exception {
    Game game = new Game();
    Player p1 = new Player1(true);
    Player p2 = new Player1(true);

    game.initialize(p1, p2);
    game.playerMove(p1, 1, 2, 3, 4);
    Spot boxes[][] = game.getBoard().boxes;
    for (int i = 0; i < boxes.length; i++) {
      for (int j = 0; j < boxes[0].length; j++) {
        if (boxes[i][j].getPiece() != null) {
          System.out.println("x postion " +
              boxes[i][j].getX() + " y postion " + boxes[i][j].getY() + "  Piece name "
              + boxes[i][j].getPiece().getClass().getName());
        } else {
          System.out.println("x postion " +
              boxes[i][j].getX() + " y postion " + boxes[i][j].getY() + "  Piece name "
              + null);
        }
      }
    }
  }

}
