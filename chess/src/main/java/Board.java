public class Board {
  Spot boxes[][];

  public Board() {

    this.resetBoard();
  }

  private void resetBoard() {
    boxes = new Spot[8][8];
    boxes[0][0] = new Spot(0, 0, new Rook(true));
    boxes[0][1] = new Spot(0, 1, new Knight(true));
    boxes[0][2] = new Spot(0, 2, new Bishop(true));
    boxes[0][3] = new Spot(0, 2, new Queen(true));

    boxes[0][4] = new Spot(0, 2, new King(true));

    boxes[0][5] = new Spot(0, 2, new Bishop(true));
    boxes[0][6] = new Spot(0, 2, new Knight(true));
    boxes[0][7] = new Spot(0, 2, new Rook(true));

    boxes[1][0] = new Spot(1, 0, new Pawn(true));
    boxes[1][1] = new Spot(1, 1, new Pawn(true));
    boxes[1][2] = new Spot(1, 1, new Pawn(true));

    boxes[1][3] = new Spot(1, 1, new Pawn(true));
    boxes[1][4] = new Spot(1, 1, new Pawn(true));

    boxes[1][5] = new Spot(1, 1, new Pawn(true));
    boxes[1][6] = new Spot(1, 1, new Pawn(true));
    boxes[1][7] = new Spot(1, 1, new Pawn(true));

    //...

    // initialize black pieces
    boxes[7][0] = new Spot(7, 0, new Rook(false));
    boxes[7][1] = new Spot(7, 1, new Knight(false));
    boxes[7][2] = new Spot(7, 2, new Bishop(false));
    boxes[7][3] = new Spot(7, 2, new King(false));

    boxes[7][4] = new Spot(7, 2, new Queen(false));
    boxes[7][5] = new Spot(7, 2, new Bishop(false));
    boxes[7][6] = new Spot(7, 2, new Knight(false));
    boxes[7][7] = new Spot(7, 2, new Rook(false));


    //...
    boxes[6][0] = new Spot(6, 0, new Pawn(false));
    boxes[6][1] = new Spot(6, 1, new Pawn(false));
    boxes[6][2] = new Spot(6, 0, new Pawn(false));
    boxes[6][3] = new Spot(6, 1, new Pawn(false));
    boxes[6][4] = new Spot(6, 0, new Pawn(false));
    boxes[6][5] = new Spot(6, 1, new Pawn(false));
    boxes[6][6] = new Spot(6, 0, new Pawn(false));
    boxes[6][7] = new Spot(6, 1, new Pawn(false));
    //...

    // initialize remaining boxes without any piece
    for (int i = 2; i < 6; i++) {
      for (int j = 0; j < 8; j++) {
        boxes[i][j] = new Spot(i, j, null);
      }
    }
  }

  public Spot getSpot(int x, int y){
    if (x > 7 || y > 7) {
      return new Spot(0,0,null) ;
    }
    return boxes[x][y];
  }
}
