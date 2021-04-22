package plays;
import games.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Orchestrator{

  protected Game Game;

  public Orchestrator(Game Game){
    this.Game = Game;
  }

  public void play(){

      while(this.Game.isOver() == false){
        System.out.println("C'est a " + this.Game.getCurrentPlayer() + " de jouer");
        System.out.println(this.Game.situationToString());
        this.Game.execute(this.Game.getCurrentPlayer().chooseMove(Game));
      }
      if(this.Game.getWinner() != null){
        System.out.println("Le gagnant est " + this.Game.getWinner().toString());
      }
      else{
        System.out.println("Pas de gagnant la partie est nulle");
      }
      System.out.println(this.Game.situationToString());
    }
  }
