package Pieces;

import Board.*;

public class Knight extends Piece {
  
  public Knight(Color color) {
    super("N", color); // K is reserved for King
  }

  // cavalos só podem se movimentar em L, em qualquer direção. Podem saltar qualquer peça
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

    if (destination[0] == xOrigin+(2*xDiff)) {
      if (destination[1] == yOrigin+(1*yDiff)) {
        return true;
      }
    } else if (destination[0] == xOrigin+(1*xDiff)) {
      if (destination[1] == yOrigin+(2*yDiff)) {
        return true;
      }
    }

    return false;
  }
}

