/*
 * Program by:Michael Sago
 */

import java.util.Scanner;
public class Project3 {
	
	public static void main(String[] args) {
		
		int r = 3;
		int c = 0;
		
		WumpusWorld wumpusWorld = new WumpusWorld();
		boolean playGame = true;
		Scanner input = new Scanner(System.in);
		
		System.out.println("*******************************************************************\n" +
							"WELCOME TO WUMPUS WORLD \n" +
							"The name of the game is to explore through this WORLD using the\n" +
							"keys provided. The key is to find the GOLD before you find the \n" +
							"monster WUMPUS!! There are also other PITS you can fall in and \n" +
							"don't expect to get out of those. There are also litlle hints \n" +
							"placed around each PIT and WUMPUS. If near a pit it will breezy \n" +
							"and when near a WUMPUS it might get a little smelly. There is also \n" +
							"a cheat to see the board. \n" +
							"*******************************************************************\n\n");
		
		//While loop to iterate through game
		//until pit, wumpus or gold is found
		while(playGame) {
			
			System.out.println("Please enter a move command: \n" + 
			"(N) - to move up one space \n" +
			"(S) - to move down one space \n" +
			"(E) - to move right one space \n" +
			"(W) - to move left one space \n" +
			"(C) - to see current state of whole board --CHEATER--");
			
			String userInput = input.next();
			
			switch(userInput){
			
			//Enter N to move North one square
			case "N":
			case "n":
				
				if(r - 1 >= 0) {
					wumpusWorld.moveUser(r, c, r - 1, c);
					r--;
				}
				else
					System.out.println("****Sorry you tried to move off the board!**** \n");
				
				break;
				
			//Enter S to move down one square
			case "S":
			case"s":
				
				if(r + 1 <= 3) {
					wumpusWorld.moveUser(r, c, r + 1, c);
					r++;
				}
				else
					System.out.println("****Sorry you tried to move off the board!**** \n");
				
				break;
			
			//Enter E to move Right one square
			case "E":
			case "e":
				
				if(c + 1 <= 3) {
					wumpusWorld.moveUser(r, c, r, c + 1);
					c++;
				}
				else
					System.out.println("****Sorry you tried to move off the board!**** \n");
				
				break;
			
			//Enter to move left one square
			case "W":
			case "w":
				
				if(c - 1 >= 0) {
					wumpusWorld.moveUser(r, c, r, c - 1);
					c--;
				}
				else
					System.out.println("****Sorry you tried to move off the board!**** \n");
				break;
			
			//Use to see Whole Board
			case "C":
			case "c":
				wumpusWorld.showBoard();
				break;
			}//end switch statement
			
			
			//If else statement to see if game is over or not
			if(wumpusWorld.checkGame(r, c)) {
				continue;
			}
			else
				playGame = false;
			
		}//End game while loop
		
	}

}
