package players;
import java.util.Random;
import games.*;


public class NegamaxPlayer implements Player{

  public NegamaxPlayer(){}

  public int evaluate(Game G){
    if (G.getWinner() == G.getCurrentPlayer() && G.getWinner() != null){
      return 1;
    }
    if (G.getWinner() != null){
      return -1;
    }
    if (G.isOver() == true){
      return 0;
    }
    else{
      int resultat = -10;
      for(int i=0;i< G.validMoves().size();i++){
        Game copyRecursive = G.copy();
        int coup = copyRecursive.validMoves().get(i);
        copyRecursive.execute(coup);
        int indice = -this.evaluate(copyRecursive);
        if (resultat < indice){resultat = indice;}
    }
    return resultat;
  }
}

    public int chooseMove(Game G){
      Integer meilleureIndice = null;
      Integer meilleurCoup = null;
      for (int i=0;i< G.validMoves().size();i++){
        Game copy = G.copy();
        int coup = copy.validMoves().get(i);
        copy.execute(coup);
        int indice = -this.evaluate(copy);
        if(meilleureIndice == null || meilleureIndice < indice){
          meilleurCoup = coup;
          meilleureIndice = indice;
        }
      }
      return meilleurCoup;
      }

    public String toString(){
    return "Intelligence Artificiel : " + this.hashCode();
    }
}
