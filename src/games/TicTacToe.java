package games;
import players.*;
import plays.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class TicTacToe extends AbstractGame{

  private Player[][]tableau;


  // CONTRUCTEUR D'UN OBJET "TICTACTOE" CONTENANT : DEUX JOUEURS, UN TABLEAU D'OBJET DE TYPE "PLAYER" DE 2 DIMENSIONS AVEC 3 SOUS-TABLEAU DE TAILLE 3 (VIDE PAR DEFAULT),
  // UN SWITCH(BOOLEAN) POUR SAVOIR C'EST A QUELLE JOUEUR DE JOUER.
  public TicTacToe(Player P1, Player P2){
    super(P1,P2);
    this.tableau = new Player[3][3];
  }

  // METHODE QUI EN FONCTION DU TOUR (JOUEUR 1 OU JOUEUR 2) PLACE UN OBJECT "PLAYER" DANS LE TABLEAU D'OBJET DE TYPE "PLAYER" AVEC LES INDICES RECUPERER PAR UN "INT COUP" :
  // L'ABSCICE  > COUP / 3 (QUOTIENT)
  // L'ORDONNEE > COUP % 3 (RESTE)
  // ELLE RETOURNE RIEN
  @Override
  public void doExecute(int coup){
    if(super.getCurrentPlayer().equals(this.P1)){
      this.tableau[coup/3][coup%3] = this.P1;
    }
    else{
      this.tableau[coup/3][coup%3] = this.P2;
    }
  }




  // CREE ET AFFICHE UNE LISTE DE COUPS VALIDE EN BOUCLANT SUR LA TAILLE DU TABLEAU D'OBJET "PLAYER" ET VERFIANT SI CHAQUE CASE DE SE TABLEAU EST "NULL"
  // ET AINSI AJOUTER L'INCREMENTEUR A LA LISTE "COUP_VALID"
  // ELLE RETOURNE UNE LISTE DE "INTEGER"
  public List<Integer> validMoves(){
    List<Integer> coup_valid = new ArrayList<>();
    for(int i=0;i<9;i++){
    	if(this.tableau[i/3][i%3] == null){
    		coup_valid.add(i);

    	}
    }
    return coup_valid;
  }

  // VERIFIE LA VALIDITE D'UN COUP, PAR DEUX ACTION, VERIFIANT QUE LE TABLEAU EST BIEN VIDE A L'ENDROIT OU LE JOUEUR SOUHAITE METTRE
  // SA CROIX OU SON ROND ET QUE LE COUP SOIT BIEN INCLUS DANS LE TABLEAU DONC ENTRE 0 ET 9 POUR NE PAS ETRE
  // "OUT OF RANGE" AUTREMENT UN MESSAGE D'ERREUR S'AFFICHE ET LE COUP EST REDEMANDER SANS CHANGER DE JOUEUR
  // ELLE RETOURNE UN BOOLEAN : FALSE SI LE COUP N'EST PAS VALIDE, TRUE S'IL EST.
  public boolean isValid(int coup){
    if(coup>=0 && coup<9 && this.tableau[coup/3][coup%3] == null){
      return true;
      }
    else{
      System.out.println("<ERREUR> : VEUILLEZ SELECTIONNEZ UN COUP DANS LE LISTE PROPOSE");
      return false;
      }
  }



  // ELLE RETOURNE UN BOOLEAN : FALSE SI TOUTE LA LIGNE(COLONNES ET DIAGONAL INCLUS) NE POSSEDE PAS L'OBJECT "P" DE TYPE PLAYER, TRUE SI LA LIGNE EST REMPLI DE SE MEME OBJET "P".
  public boolean wins(Player P,int row, int column, int deltaRow, int deltaColumn){
    if(this.tableau[row + deltaRow][column + deltaColumn] == P && this.tableau[row + 2*deltaRow][column + 2*deltaColumn] == P){
      return true;
    }
    else {
      return false;
    }
  }

  //
  // ELLE RETOURNE LE JOUEUR QUI A REMPLIS UNE LIGNE(COLONNES ET DIAGONAL INCLUS)
  @Override
  public Player getWinner(){
    // LIGNES TEST
    if (wins(this.P1,0,0,0,1) == true && this.tableau[0][0] == this.P1){
      return this.P1;
    }
    if (wins(this.P1,1,0,0,1) == true && this.tableau[1][0] == this.P1){
      return this.P1;
    }
    if (wins(this.P1,2,0,0,1) == true && this.tableau[2][0] == this.P1){
      return this.P1;
    }
    // COLONNES TEST
    if (wins(this.P1,0,0,1,0) == true && this.tableau[0][0] == this.P1){
      return this.P1;
    }
    if (wins(this.P1,0,1,1,0) == true && this.tableau[0][1] == this.P1){
      return this.P1;
    }
    if (wins(this.P1,0,2,1,0) == true && this.tableau[0][2] == this.P1){
      return this.P1;
    }
    // DIAGONALES TEST
    if (wins(this.P1,0,0,1,1) == true && this.tableau[0][0] == this.P1){
      return this.P1;
    }
    if(wins(this.P1,0,2,1,-1) == true && this.tableau[0][2] == this.P1){
      return this.P1;
    }

    // LIGNES TEST
    if (wins(this.P2,0,0,0,1) == true && this.tableau[0][0] == this.P2){
      return this.P2;
    }
    if (wins(this.P2,1,0,0,1) == true && this.tableau[1][0] == this.P2){
      return this.P2;
    }
    if (wins(this.P2,2,0,0,1) == true && this.tableau[2][0] == this.P2){
      return this.P2;
    }
    // COLONNES TEST
    if (wins(this.P2,0,0,1,0) == true && this.tableau[0][0] == this.P2){
      return this.P2;
    }
    if (wins(this.P2,0,1,1,0) == true && this.tableau[0][1] == this.P2){
      return this.P2;
    }
    if (wins(this.P2,0,2,1,0) == true && this.tableau[0][2] == this.P2){
      return this.P2;
    }
    // DIAGONAL TEST
    if (wins(this.P2,0,0,1,1) == true && this.tableau[0][0] == this.P2){
      return this.P2;
    }
    if (wins(this.P2,0,2,1,-1) == true && this.tableau[0][2] == this.P2){
      return this.P2;
    }
    else{return null;}
  }


  // REVOIS UN BOOLEAN EN SUIVANT CES REGLES QUE L'ONT VERIFIE :
  // 1 : SI ON A UN GAGNANT, ON REVOIE TRUE
  // 2 : SI LA PARTIE EST NULLE DONC QUE LA LISTE DE COUP VALID EST VIDE,  ON REVOIE TRUE
  // 3 : AUTREMENT ON REVOIE FALSE
  public boolean isOver(){
    if(getWinner() != null){
      return true;
    }
    if(validMoves().size() == 0){return true;}
    else{return false;}
  }

  //FONCTION REALISANT UNE COPIE COMPLETE DE L'OBJET TICTACTOE AINSI QUE METTANT A JOUR SES ARGUMENTS
  public Game copy(){
    TicTacToe copy = new TicTacToe(super.P1,super.P2);
    for (int i=0;i<3;i++){
      for (int j=0;j<3;j++){
        copy.tableau[i][j] = this.tableau[i][j];
      }
    }
    copy.currentPlayer = super.getCurrentPlayer();
    return copy;
  }


  // RETOURNE UN "STRING" QUI PRENDS L'ABSCICE ET L'ORDONNEE D'UN COUP
  public String moveToString(int coup){return coup + " : ["+ coup/3+" ; "+ coup%3 +"]";}


  // RETOURNE UNE STRING POUR L'AFFICHAGE COMPLET DU TABLEAU DES "X" OU DES "O" EN FONCTION DES OBJECTS P1 OU P2 DANS LE TABLEAU
  public String situationToString(){
    String chaine="";
    for(int i = 0; i < this.tableau.length ; i++){
      for(int j = 0 ; j < this.tableau[i].length ; j++){
        if(this.tableau[i][j] == this.P1){
          chaine += "  X  ";
        }
        if(this.tableau[i][j] == this.P2){
          chaine += "  O  ";
        }
        if(this.tableau[i][j] == null){
          chaine += "  .  ";
        }
      }
    chaine += System.lineSeparator() + System.lineSeparator();
    }
    return chaine;
  }


  }
