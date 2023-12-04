package boardgame;

public class Piece {
  protected Position position;
  private Board board;
  
  public Piece(Board board) {
    this.board = board;
    // peça não foi colocada no tabuleiro ainda
  }

  protected Board getBoard() {
    return board;
  }
  
}
