package main;
import players.*;
import plays.*;
import games.*;
import gamestests.AbstractGameTests;
import gamestests.NimTests;
import gamestests.TicTacToeTests;
import playerstests.HumanTests;
import playerstests.RandomPlayerTests;
import playerstests.NegamaxPlayerTests;
import playstests.OrchestratorTests;

public class Test{

  public static void main(String[] args){

        boolean ok = true;

    		// Package "games"
    		AbstractGameTests abstractGameTester = new AbstractGameTests();
    		ok = ok && abstractGameTester.testGetCurrentPlayer();
    		ok = ok && abstractGameTester.testExecute();

    		NimTests nimTester = new NimTests();
    		ok = ok && nimTester.testGetInitialNbMatches();
    		ok = ok && nimTester.testGetCurrentNbMatches();
    		ok = ok && nimTester.testGetCurrentPlayer();
    		ok = ok && nimTester.testExecute();
    		ok = ok && nimTester.testIsValid();
    		ok = ok && nimTester.testValidMoves();
    		ok = ok && nimTester.testIsOver();
    		ok = ok && nimTester.testGetWinner();
    		ok = ok && nimTester.testCopy();

    		TicTacToeTests ticTacToeTester = new TicTacToeTests();
    		ok = ok && ticTacToeTester.testGetCurrentPlayer();
    		ok = ok && ticTacToeTester.testExecuteAndIsValid();
    		ok = ok && ticTacToeTester.testValidMoves();
    		ok = ok && ticTacToeTester.testWins();
    		ok = ok && ticTacToeTester.testGetWinner();
    		ok = ok && ticTacToeTester.testIsOver();
    		ok = ok & ticTacToeTester.testCopy();

    		// Package "players"
    		HumanTests humanTester = new HumanTests();
    		ok = ok && humanTester.silentTestChooseMove();

    		RandomPlayerTests randomTester = new RandomPlayerTests();
    		ok = ok && randomTester.testChooseMove();

    		NegamaxPlayerTests negamaxTester = new NegamaxPlayerTests();
    		ok = ok && negamaxTester.testEvaluate();
    		ok = ok && negamaxTester.testChooseMove();

    		// Package "orchestrator"
    		OrchestratorTests tester = new OrchestratorTests();
    		ok = ok && tester.silentTestPlay();

    		System.out.println(ok ? "All tests passed" : "At least one test failed");

  }


}
