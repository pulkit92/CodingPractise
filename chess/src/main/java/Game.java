import java.util.ArrayList;
import java.util.List;

public class Game {
  private Player[] players;
  private Board board;
  private Player currentTurn;

  public Board getBoard() {
    return board;
  }

  private GameStatus status;
  private List<Move> movesPlayed;

  public void initialize(Player p1, Player p2) {
    players = new Player[2];
    movesPlayed = new ArrayList<>();
    players[0] = p1;
    players[1] = p2;

    board = new Board();

    if (p1.isWhite()) {
      this.currentTurn = p1;
    } else {
      this.currentTurn = p2;
    }

    movesPlayed.clear();
  }

  public boolean isEnd() {
    return this.status != GameStatus.ACTIVE;
  }



  public void setStatus(GameStatus status) {
    this.status = status;
  }

  public boolean playerMove(Player player, int startX,
      int startY, int endX, int endY) throws Exception {
    Spot startBox = board.getSpot(startX, endX);
    Spot endBox = board.getSpot(startY, endY);
    Move move = new Move(player, startBox, endBox);
    return this.makeMove(move, player);
  }

  private boolean makeMove(Move move, Player player) {
    if (move.getStart() == null) {
      return false;
    }
    if (move.getPlayer() != currentTurn) {
      return false;
    }
    if (move.getPieceMoved().isWhite() != player.isWhite()) {
      return false;
    }
    if (!move.getPieceMoved().canMove(board, move.getStart(), move.getEnd())) {
      return false;
    }

    Piece destPiece = move.getEnd().getPiece();
    if (destPiece != null) {
      destPiece.setKilled(true);
      move.setPieceKilled(destPiece);
    }
    movesPlayed.add(move);

    // move piece from the stat box to end box
    move.getEnd().setPiece(move.getStart().getPiece());
    move.getStart().setPiece(null);

    if (destPiece != null && destPiece instanceof King) {
      if (player.isWhite()) {
        this.setStatus(GameStatus.WHITE_WIN);
      } else {
        this.setStatus(GameStatus.BLACK_WIN);
      }
    }

    // set the current turn to the other player
    if (this.currentTurn == players[0]) {
      this.currentTurn = players[1];
    } else {
      this.currentTurn = players[0];
    }
    return true;

  }
}
