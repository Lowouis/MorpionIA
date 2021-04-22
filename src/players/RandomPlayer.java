package players;
import java.util.Random;
import games.*;


public class RandomPlayer implements Player{

  protected Random alea;

  public RandomPlayer(Random random){this.alea = random;}

  public int chooseMove(Game G){
    int size = G.validMoves().size();
    return G.validMoves().get(this.alea.nextInt(size));
  }

  public String toString(){
    return "Joueur aléatoire n° " + this.hashCode();
  }
}
