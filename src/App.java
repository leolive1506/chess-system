import chess.ChessMath;

public class App {
    public static void main(String[] args) throws Exception {
        ChessMath chessMatch = new ChessMath();
        UI.printBoard(chessMatch.getPieces());
    }
}
