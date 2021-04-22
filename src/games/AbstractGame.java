package games;
import players.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

//CLASSE ABSTRAITE SE FAISANT ETENDRE PAR NIM ET TICTACTOE

public abstract class AbstractGame implements Game{

  protected Player P1;
  protected Player P2;
  protected Player currentPlayer;

  //CONSTRUCTEUR ETROITEMENT LIE A NIM ET TICTACTOE
  //CEUX-CI PRENANT CHACUN PRENANT DEUX JOUEUR ET LE JOUEUR COURANT
  protected AbstractGame(Player P1, Player P2){
    this.P1 = P1;
    this.P2 = P2;
    this.currentPlayer = this.P1;
  }

  //FONCTION DOEXECUTE ET EXECUTE FACTORISEES DANS LA CLASSE ABSTRAITE
  protected abstract void doExecute(int coup);

  //FONCTION QUI LANCE L'EXECUTION DU COUP ET CHANGE LE JOUEUR COURANT
  @Override
  public void execute(int coup){
    doExecute(coup);
      if(this.getCurrentPlayer().equals(this.P1)){
        this.currentPlayer = this.P2;
      }
      else{
        this.currentPlayer = this.P1;
      }
  }

  //ACCESSEUR PERMETTANT DE RECUPERER LE JOUEUR COURANT
  @Override
  public Player getCurrentPlayer(){
    return this.currentPlayer;
  }


}
