package Match;

import Pieces.*;

public class Player {

  private Color team;

  public Player(Color color) {
    this.team = color;
  }

  public Color getTeam() {
    return this.team;
  }
}
