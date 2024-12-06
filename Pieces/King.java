package Pieces;

import Board.*;

public class King extends Piece {
  
  public King(Color color) {
    super("K", color);
  }

  // o rei se movimenta em apenas uma celula, para qualquer direção
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

    if (destination[0] == xOrigin+(1*xDiff)) {
      if (destination[1] == yOrigin+(1*yDiff)) {
        return true;
      } else if (destination[1] == yOrigin) {
        return true;
      }
    } else if (destination[1] == yOrigin+(1*yDiff)) {
      if (destination[0] == xOrigin+(1*xDiff)) {
        return true;
      } else if (destination[0] == xOrigin) {
        return true;
      }
    }

    return false;

  }
}


