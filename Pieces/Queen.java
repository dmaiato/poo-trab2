package Pieces;

import Board.*;

public class Queen extends Piece {
  
  public Queen(Color color) {
    super("Q", color);
  }

  // rainhas se movimentam nas verticais, horizontais e diagonais. Não podem saltar peças
  @Override
  public boolean validMovement(int[] destination, Board board) {
    int xOrigin = this.position[0];
    int yOrigin = this.position[1];

    int xDiff = (xOrigin - destination[0] > 0 ? -1 : 1); 
    int yDiff = (yOrigin - destination[1] > 0 ? -1 : 1);

    if (board.getPiece(destination) != null) {
      if (board.getPiece(destination).getColor() == this.color) {
        return false;
      }
    }

    // movimento padrão de torre
    if (xOrigin == destination[0] || yOrigin == destination[1]) {
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
    
    // movimento padrão de bispo
    int y = yOrigin;
    for (int x = xOrigin+xDiff; x != destination[0]; x = x+(1*xDiff)) {
      y = y + yDiff;
      if (board.getPiece(x, y) != null) {
        if (board.getPiece(x, y) == this) continue;
        return false;
      }
    }

    int xAxis = xOrigin < destination[0] ? 1 : -1; // positivo de destino estiver à direita
    int yAxis = yOrigin < destination[1] ? 1 : -1; // positivo se destino estiver acima

    if (xAxis*(xOrigin - destination[0]) == yAxis*(yOrigin - destination[1])) {
      return true;
    } else {
      return false;
    }   
  }
}

