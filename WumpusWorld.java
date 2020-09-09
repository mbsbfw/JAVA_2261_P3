
public class WumpusWorld {	
	
	Square[][] board = new Square[4][4];
	
	WumpusWorld() {
		
		//For Loop to initialize board
		for(int i = 0; i < board.length; i++) { 
			for(int j = 0; j < board[i].length; j++) { 
				board[i][j] = new Square();
			}
		}
		
		//Set user in bottom left of grid
		board[3][0].setUser(true);
		
		//Randomly place gold on the board
		int count = 0;
		while(count == 0) {
			int row = (int)(Math.random() * 4);
			int col = (int)(Math.random() * 4);
			
			if(board[row][col].getUser() != true)
				board[row][col].setGold(true);
				count++;
		}
		
		//Randomly place 3 Pits on the board 
		int countP = 0;
		while(countP < 3) {
			int row = (int)(Math.random() * 4);
			int col = (int)(Math.random() * 4);
			
			if(board[row][col].getUser() != true && board[row][col].getGold() != true 
					&& board[row][col].getPit() != true) {
				
				board[row][col].setPit(true);
				countP++;
				
				for(int i = row - 1; i <= row + 1; i++) {
					for(int j = col - 1; j <= col + 1; j++) {
						if(i == row && j == col)
							continue;
						if(i < 0 || i > 3)
							continue;
						if(j < 0 || j > 3)
							continue;

						board[i][j].setBreeze(true);
					}
				}
			}
		}
		
		//Randomly place one Wumpus on the board 
		int countW = 0;
		while(countW == 0) {
			int row = (int)(Math.random() * 4);
			int col = (int)(Math.random() * 4);

			if(board[row][col].getUser() != true && board[row][col].getGold() != true  
					&& board[row][col].getPit() != true){
				
				board[row][col].setWumpus(true);
				countW++;
				
				for(int i = row - 1; i <= row + 1; i++) {
					for(int j = col - 1; j <= col + 1; j++) {
						if(i == row && j == col)
							continue;
						if(i < 0 || i > 3)
							continue;
						if(j < 0 || j > 3)
							continue;

						board[i][j].setStinch(true);
					}//end inner for loop
				}//end outer loop
			}
		}//end while loop	
	}
	
	//Get user new coordinates and move
	public void moveUser(int oldR, int oldC, int newR, int newC) {
		
		board[newR][newC].setUser(true);
		board[oldR][oldC].setUser(false);
	}
	
	public boolean checkGame(int r, int c) {
		
		for(int i = 0; i < board.length; i++) { 
			for(int j = 0; j < board[i].length; j++) { 
				
				//If gold is found print statement and end game
				if(board[r][c].getGold()) {
					System.out.println("--You found the GOLD CONGRATULATIONS-- \n");
					return false;	
				}
				
				//If wumpus is found print statement and end game
				if(board[r][c].getWumpus()) {
					System.out.println("--You found the WUMPUS and he ended your game-- \n");
					return false;
				}
				
				//If pit is found print statement and end game
				if(board[r][c].getPit()) {
					System.out.println("You found a PIT and can't climb your way out --GAME OVER-- \n");
					return false;
				}
				
				//If breeze and stinch are found print statement 
				//and continue game
				if(board[r][c].getBreeze() && board[r][c].getStinch()) {
					System.out.println("--It is BREEZY and STINKY "
							+ "Be CAREFUL there may be a pit and a WUMPUS near by-- \n");
					return true;
				}
				
				//If breeze is found print statement 
				//and continue game
				if(board[r][c].getBreeze()) {
					System.out.println("--It is BREEZY out here continue on-- \n");
					return true;
				}
				
				//If stinch is found print statement 
				//and continue game
				if(board[r][c].getStinch()) {
					System.out.println("--It is STINKY out here.--\n"
							+  "--Be careful there is a Wumpus lurking but you may continue-- \n");
					return true;
				}
				
				
			}//end inner for loop
		}//end outer for loop

		return true;
	}
		
	public void showBoard() {
		
		System.out.println("U = User/You \n" +
				"G = Gold \n" +
				"P = Pit \n" +
				"W = Wumpus \n" +
				"B = Breeze \n" +
				"S = Stinch \n" +
				"* = Empty space \n");
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.print("|" + " ");
				
				//If statements to find and show all pieces on the board
				if(board[i][j].getUser() == true) 
					System.out.print("U");
				
				if(board[i][j].getGold() == true) 
					System.out.print("G");
				
				if(board[i][j].getPit() == true)  
					System.out.print("P");
				
				if(board[i][j].getWumpus() == true)  
					System.out.print("W");	
				
				if(board[i][j].getBreeze() && board[i][j].getWumpus() != true 
						&& board[i][j].getUser() != true && board[i][j].getPit() != true)
					System.out.print("B");	
				
				if(board[i][j].getStinch() && board[i][j].getWumpus() != true 
						&& board[i][j].getUser() != true && board[i][j].getPit() != true)
					System.out.print("S");
				
				if(board[i][j].getGold() != true && board[i][j].getUser() != true 
						&& board[i][j].getPit() != true && board[i][j].getWumpus() != true
						&& board[i][j].getBreeze() != true && board[i][j].getStinch() != true) 
						System.out.print("*");
					
			}//end inner loop
			
			System.out.println("|");
		}//end outer loop
		
		System.out.println("\n");
	}
}

