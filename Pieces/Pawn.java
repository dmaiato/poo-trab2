package Pieces;

import Board.*;

public class Pawn extends Piece {

  boolean firstMovement = true;
  
  public Pawn(Color color) {
    super("P", color);
  }

  // Peões só podem se movimentar em linha reta, e capturar nas diagonais
  @Override
  public boolean validMovement(int[] destination, Board board) {
    int x = destination[0];
    int y = destination[1];

    int diff = (this.getColor() == Color.WHITE) ? 1 : -1; // peças pretas movem pra baixo, e brancas pra cima
    int first = (this.getColor() == Color.WHITE) ? 1 : -1;

    // confere se não há nenhuma peça aliada no destino
    if (board.getPiece(destination) != null) {
      if (board.getPiece(destination).getColor() == this.color) {
        return false;
      }
    }

    // movimento de captura
    if (this.position[1] - y == diff) {
      if (this.position[0] - x == 1 || this.position[0] - x == -1) { // checa se moveu para o lado
        if (board.getPiece(destination) != null) {
          if (board.getPiece(destination).getColor() == this.color) {
            return false;
          }
          this.firstMovement = false;
          return true;
        }
      }
    }

    // movimento padrão, possibilita saltar duas casas no primeiro movimento
    if (this.firstMovement) {
      if (this.position[1] - y == diff+first && this.position[0] - x == 0) { // moveu em y mas não em x
        this.firstMovement = false;
        if (board.getPiece(destination) != null) return false;
        else return true;
      }
    }
    if (this.position[1] - y == diff && this.position[0] - x == 0) {
      this.firstMovement = false;
      if (board.getPiece(destination) != null) return false;
      else return true;
    }

    return false;
  }
}
