import chess.ChessPiece;

public class UI {
  public static void printBoard(ChessPiece[][] pieces) {
    for (int row = 0; row < pieces.length; row++) {
      System.out.print((8 - row) + " ");
      for (int column = 0; column < pieces.length; column++) {
        printPiece(pieces[row][column]);
      }
      System.out.println();
    }
    System.out.println("  a b c d e f g h");
  }

  private static void printPiece(ChessPiece piece) {
    System.out.print(piece == null ? "-" : piece);
    System.out.print(" ");
  }
}
