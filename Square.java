
public class Square {
	private boolean user; 
	private boolean gold; 
	private boolean pit; 
	private boolean wumpus; 
	private boolean breeze; 
	private boolean stinch; 
	
	Square(){
		user = false;
		gold = false;
		pit = false;
		wumpus = false;
		breeze = false;
		stinch = false;
	}
	
	public boolean getUser() {
		return user;
	}
	
	public void setUser(boolean u) {
		user = u;
	}
	
	public boolean getGold() {
		return gold;
	}
	
	public void setGold(boolean g) {
		gold = g;
	}
	
	public boolean getPit() {
		return pit;
	}
	
	public void setPit(boolean p) {
		pit = p;
	}

	public boolean getWumpus() {
		return wumpus;
	}
	
	public void setWumpus(boolean w) {
		wumpus = w;
	}
	
	public boolean getBreeze() {
		return breeze;
	}
	
	public void setBreeze(boolean b) {
		breeze = b;
	}
	
	public boolean getStinch() {
		return stinch;
	}
	
	public void setStinch(boolean s) {
		stinch = s;
	}



}
