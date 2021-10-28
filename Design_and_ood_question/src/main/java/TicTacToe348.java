public class TicTacToe348 {

 /* int a[][] = null;
  int currentplayer;
  int size;
  boolean gameFinished;

  public TicTacToe348(int n) {
    a = new int[n][n];
    currentplayer = 0;
    size = n;
    gameFinished = false;
  }

  */
  /**
   * Player {player} makes a move at ({row}, {col}).
   *
   * @param row    The row of the board.
   * @param col    The column of the board.
   * @param player The player, can be either 1 or 2.
   * @return The current winning condition, can be either: 0: No one wins. 1: Player 1 wins. 2: Player 2 wins.
   *//*
  public int move(int row, int col, int player) {
    if (gameFinished) {
      return 0;
    }
    if (currentplayer == player) {
      return 0;
    }
    if (row < 0 || row > size - 1 || col < 0 || col > size - 1) {
      return 0;
    }
    a[row][col] = player;
    if (checkRow(player) || checkColumn(player) || (row == col && checkDiagonal(player)) || (row + col == size - 1
        && checkAntiDiagonal(player))) {
      gameFinished = true;
      return player;
    }
    return 0;
  }

  private boolean checkRow(int player) {
    int row = 0;
    while (row < size) {
      boolean b = true;
      for (int i = 0; i < size; i++) {
        if (a[row][i] != player) {
          b = false;
          break;
        }
      }
      if (b) {
        return true;
      }
      row++;
    }
    return false;
  }

  private boolean checkColumn(int player) {
    int col = 0;
    while (col < size) {
      boolean b = true;

      for (int i = 0; i < size; i++) {
        if (a[i][col] != player) {
          b = false;
          break;
        }
      }
      if (b) {
        return true;
      }
      col++;
    }
    return false;
  }

  private boolean checkDiagonal(int player) {
    for (int i = 0; i < size; i++) {
      if (a[i][i] != player) {
        return false;
      }
    }
    return true;
  }

  private boolean checkAntiDiagonal(int player) {
    for (int i = 0; i < size; i++) {
      if (a[i][size - i - 1] != player) {
        return false;
      }
    }
    return true;
  }*/
  int x[];
  int y[];
  int diag = 0;
  int antDig = 0;
  boolean gameFinished;
  int currentplayer;
  int size;

  public TicTacToe348(int n) {
    x = new int[n];
    y = new int[n];
    size = n;

  }

  public int move(int row, int col, int player) {
    if (gameFinished) {
      return 0;
    }
    if (currentplayer == player) {
      return 0;
    }
    if (row < 0 || row > size - 1 || col < 0 || col > size - 1) {
      return 0;
    }
    int ply = (player == 1) ? 1 : -1;

    x[row] = x[row] + ply;
    y[col] = y[col] + ply;
    if (row == col) {
      diag = diag + ply;
    }
    if (row + col == size - 1) {
      antDig = antDig + ply;
    }
    if (Math.abs(x[row]) == size || Math.abs(y[col]) == size || Math.abs(diag) == size || Math.abs(antDig) == size) {
      gameFinished = true;
      return player;
    }
    currentplayer = player;
    return 0;
  }


  public static void main(String arrgs[]) {
    TicTacToe348 ticTacToe348 = new TicTacToe348(3);
    String s="pulkit";
    sss(s);
    System.out.println(s);
    System.out.println(ticTacToe348.move(0, 0, 1));
    System.out.println(ticTacToe348.move(0, 2, 2));

    System.out.println(ticTacToe348.move(2, 2, 1));

    System.out.println(ticTacToe348.move(1, 1, 2));
    System.out.println(ticTacToe348.move(2, 0, 1));
    System.out.println(ticTacToe348.move(1, 0, 2));
    System.out.println(ticTacToe348.move(2, 1, 1));

  }
  public static void sss(String s){
    s=s+"baj[ai";
  }

}
