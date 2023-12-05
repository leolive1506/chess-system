package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMath;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
  private ChessMath chessMath;

  public Pawn(Board board, Color color, ChessMath chessMath) {
    super(board, color);
    this.chessMath = chessMath;
  }

  @Override
  public String toString() {
    return "P";
  }

  @Override
  public boolean[][] possibleMoves() {
    boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
    Position p = new Position(0, 0);

    if (getColor() == Color.WHITE) {
      // uma acima
      p.setValues(position.getRow() - 1, position.getColumn());
      if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
        mat[p.getRow()][p.getColumn()] = true;
      }

      // primeiro movimento
      p.setValues(position.getRow() - 2, position.getColumn());
      Position p2 = new Position(position.getRow() - 1, position.getColumn());
      if (
        getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)
        && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)
        && getMoveCount() == 0
      ) {
        mat[p.getRow()][p.getColumn()] = true;
      }

      // diagonais
      p.setValues(position.getRow() - 1, position.getColumn() - 1);
      if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
        mat[p.getRow()][p.getColumn()] = true;
      }

      p.setValues(position.getRow() - 1, position.getColumn() + 1);
      if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
        mat[p.getRow()][p.getColumn()] = true;
      }

      // #specialMove enpassant white (linha 5)
      if (position.getRow() == 3) {
        Position left = new Position(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMath.getEnPassantVulnerable()) {
          mat[left.getRow() - 1][left.getColumn()] = true;
        }
        Position right = new Position(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMath.getEnPassantVulnerable()) {
          mat[right.getRow() - 1][right.getColumn()] = true;
        }
      }
    } else {
      // uma acima
      p.setValues(position.getRow() + 1, position.getColumn());
      if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
        mat[p.getRow()][p.getColumn()] = true;
      }

      // primeiro movimento
      p.setValues(position.getRow() + 2, position.getColumn());
      Position p2 = new Position(position.getRow() + 1, position.getColumn());
      if (
        getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)
        && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)
        && getMoveCount() == 0
      ) {
        mat[p.getRow()][p.getColumn()] = true;
      }

      // diagonais
      p.setValues(position.getRow() + 1, position.getColumn() - 1);
      if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
        mat[p.getRow()][p.getColumn()] = true;
      }

      p.setValues(position.getRow() + 1, position.getColumn() + 1);
      if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
        mat[p.getRow()][p.getColumn()] = true;
      }

      // #specialMove enpassant black (linha 4)
      if (position.getRow() == 4) {
        Position left = new Position(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMath.getEnPassantVulnerable()) {
          mat[left.getRow() + 1][left.getColumn()] = true;
        }
        Position right = new Position(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMath.getEnPassantVulnerable()) {
          mat[right.getRow() + 1][right.getColumn()] = true;
        }
      }
    }

    return mat;
  }  
}
