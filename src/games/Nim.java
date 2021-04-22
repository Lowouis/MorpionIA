package games;
import players.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Nim extends AbstractGame{

    private int initSize;
    private int currentSize;
    private int allowedMatches;


    // CONSTRUCTEUR DE OBJECT "Nim" QUI PRENDS DEUX JOUEURS, UNE TAILLE INITIAL, LA TAILLE COURANTE, LE NOMBRE D'ALLUMETTES MAXIMUM QUE L'ONT RETIRER PAR TOUR
    public Nim(Player P1, Player P2, int initSize, int currentSize, int allowedMatches){
      super(P1,P2);
      this.initSize = initSize;
      this.currentSize = currentSize;
      this.allowedMatches=allowedMatches;
    }

    // GETTER QUI RENVOIE UN "INT" DE LA TAILLE INITIAL
    public int getInitialNbMatches(){return this.initSize;}

    // GETTER QUI RENVOIE UN "INT" DE LA TAILLE COURANTE
    public int getCurrentNbMatches(){return this.currentSize;}

    // SETTER QUI MODIFIE LA TAILLE COURANTE
    public void setCurrentSize(int currentSize){this.currentSize = currentSize;}


    // METHODE QUI CHANGE LA TAILLE COURANTE EN DEDUISANT LE COUT
    @Override
    public void doExecute(int coup){
      this.currentSize = this.currentSize - coup;
    }


    // METHODE QUI RENVOIE TRUE SI LE COUP EST INFERIEUR OU EGALE AU COUP MAXIMUM, ET QUE LE COUP NE SOIT PAS SUPERIEUR A LA TAILLE COURANTE
    public boolean isValid(int coup){

        if(coup <=this.allowedMatches && 0 < coup && this.currentSize >= coup){
          return true;
        }
        else{
          System.out.println("<ERREUR> : VEUILLEZ SELECTIONNEZ UN COUP DANS LE LISTE PROPOSE");
          return false;
        }
      }

      // METHODE QUI RENVOIE UNE LISTE DE "INTEGER" LES COUPS JOUABLE
      public List<Integer> validMoves(){
        ArrayList<Integer> coup_valid = new ArrayList<>();
        int i = 0;
        while(i < this.getCurrentNbMatches() && i < this.allowedMatches){
          i++;
          coup_valid.add(i);
        }
        return coup_valid;
      }

      // METHODE QUI RENVOIE TRUE SI LA TAILLE COURANTE EST A 0, FALSE AUTREMENT
      public boolean isOver(){
        if(this.currentSize == 0){
          return true;
        }
        else{return false;}
      }


      // METHODE QUI RENVOIE UN OBJET PLAYER P1 OU P2 EN FONCTION DU BOOLEAN TOURPAIR POUR RECUPERE LE GAGANANT, NULL AUTREMENT
      @Override
      public Player getWinner(){
        if(isOver() == true){
          return super.getCurrentPlayer();
        }
        else{
          return null;
        }
      }

      //FONCTION DE COPIE DU JEU EN COURS DE NIM
      public Game copy(){
        Nim copy = new Nim(super.P1,super.P2,this.getInitialNbMatches(),this.initSize,this.allowedMatches);
        copy.currentSize = this.getCurrentNbMatches();
        copy.currentPlayer = super.getCurrentPlayer();
        return copy;
      }

      // METHODE QUI RENVOIE UN "STRING" QUI AFFICHE DU NOMBRE DE L'ALLUMETTES
      public String situationToString(){
        String affiche="";
        for(int i=0;i < getCurrentNbMatches();i++){
          affiche += " | ";
        }
        return affiche;
      }

      // METHODE QUI RENVOIE UN "STRING" AVEC LE RESTE DES ALLUMETTES
      public String moveToString(int coup){
          return "";
      }
}
