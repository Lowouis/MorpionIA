package games;
import players.*;
import java.util.*;

//INTERFACE IMPLEMENTEE PAR TICTACTOE ET NIM

public interface Game
{

public void execute(int coup);
public Player getCurrentPlayer();
public boolean isValid(int coup);
public List<Integer> validMoves();
public Player getWinner();
public boolean isOver();
public String moveToString(int coup);
public String situationToString();
public Game copy();

}
