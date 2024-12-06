package Pieces;

import Board.*;

public class Rook extends Piece {
  
  public Rook(Color color) {
    super("R", color);
  }

  // torres se movimentam na vertical e horizontal. Não podem saltar peças
  @Override
  public boolean validMovement(int[] destination, Board board) {
    
    int xOrigin = this.position[0];
    int yOrigin = this.position[1];

    int xDiff = (xOrigin - destination[0] > 0 ? -1 : 1); 
    int yDiff = (yOrigin - destination[1] > 0 ? -1 : 1);

    // confere se não há nenhuma peça aliada no destino
    if (board.getPiece(destination) != null) {
      if (board.getPiece(destination).getColor() == this.color) {
        return false;
      }
    }

    // movimento padrão
    for (int x = xOrigin; x != destination[0]; x = x+(xDiff)) {
      if (board.getPiece(x, yOrigin) == this) continue;
      if (board.getPiece(x, yOrigin) != null) return false;
    }
    for (int y = yOrigin; y != destination[1]; y = y+(yDiff)) {
      if (board.getPiece(xOrigin, y) == this) continue;
      if (board.getPiece(xOrigin, y) != null) return false;
    }

    return true;
    
  }
}

