package Pieces;

import Board.*;

public class Bishop extends Piece {
  
  public Bishop(Color color) {
    super("B", color);
  }

  // bispos se movimentam nas diagonais. Não podem saltar peças
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


