package Pieces;

import Board.Board;

public abstract class Piece {
  
  protected String name;
  protected Color color;
  protected int[] position;

  /**
   * cria a peça e denomina uma letra, sendo maiúscula para preta e minúscula para branca
   * @param name nome da peça (ex: P de pawn)
   * @param color cor da peça
   */
  public Piece(String name, Color color) {
    if (color == Color.WHITE) this.name = name.toLowerCase();
    else this.name = name.toUpperCase();
    this.color = color;
    this.position = new int[2];
  }

  public String getName() {
    return this.name;
  }

  public Color getColor() {
    return this.color;
  }

  public int[] getPosition() {
    return this.position;
  }

  public void updatePosition(int x, int y) {
    this.position[0] = x;
    this.position[1] = y;
  }

  public void updatePosition(int[] xypos) {
    this.position[0] = xypos[0];
    this.position[1] = xypos[1];
  }

  /**
   * validação de movimento, único para cada tipo
   * @param destiny destino final da peça
   * @param board instância do tabuleiro
   * @return retorna turue ou false dependendo das verificações
   */
  public abstract boolean validMovement(int[] destination, Board board);

  @Override
  public String toString() {
    return this.name;
  }
}