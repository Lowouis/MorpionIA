package main;
import players.*;
import plays.*;
import games.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

//CLASSE PERMETTANT DE LANCER UNE INSTANCE DE JEU AU CHOIX
//EN FONCTION DE DEUX JOUEURS D'INTERFACE PLAYER INSTANCIANT
//SOIT UNE ENTREE AU CLAVIER PAR UN HUMAIN, UN "BOT" ALEATOIRE, OU UNE INTELLIGENCE ARTIFICIELLE NEGAMAX

public class Demo{

  public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);

    Player P1 = new NegamaxPlayer();
    Player P2 = new Human("Humain", scanner);
    //Player P2 = new Human("Humain", scanner);
    //Player P3 = new NegamaxPlayer();


    System.out.println("BIENVENUE sur nos jeux de plateau, veuillez entrer au clavier '1' pour jouer au morpion ou '2' pour le jeu de Nim.");
    String k = scanner.next();
    int select = Integer.parseInt(k);

    if(select == 2){
      System.out.println("Combien d'allumettes maximum sur le plateau ? : ");
      String a = scanner.next();
      System.out.println("Combien d'allumettes a retirer maximum par joueur ? : ");
      String b = scanner.next();

      int maxSize = Integer.parseInt(a);
      int allowedMatches = Integer.parseInt(b);

      Nim Nim = new Nim(P1,P2,maxSize,maxSize,allowedMatches);
      Orchestrator orchestrator = new Orchestrator(Nim);
      orchestrator.play();
    }
    if(select == 1){
      TicTacToe TicTacToe = new TicTacToe(P1,P2);
      Orchestrator orchestrator = new Orchestrator(TicTacToe);
      orchestrator.play();
    }
    scanner.close();


  }


}
