package players;
import java.util.Scanner;
import games.*;

public class Human implements Player
{

  protected String name;
  protected Scanner scanner;

  public Human(String name, Scanner scanner){
    this.name = name;
    this.scanner = scanner;
  }

  public int chooseMove(Game G){
    
    if(G instanceof TicTacToe){
      System.out.println("Voici les coups valides : " + System.lineSeparator());
      for(Integer value : G.validMoves()){
        System.out.println(" " + G.moveToString(value) + " ");
    }

    }
    System.out.println("Entrez votre coup ? : ");
    String SCOUP = scanner.next();
    int coup = Integer.parseInt(SCOUP);

    while(G.isValid(coup) == false){
      System.out.println("Entrez votre coup ? : ");
      coup = Integer.parseInt(this.scanner.next());
      this.scanner.close();
    }


    return coup;
  }
  @Override
  public String toString(){return this.name;}

}
