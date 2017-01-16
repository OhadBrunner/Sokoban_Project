package model;

import java.util.ArrayList;
import levels.Level;


/**
 *This class represent the game. the array list "levels" contains all the levels in numerical order (this is also the order we are loading the levels). 
 *The game knows what's the current level in each point.
 */

public class SokobanGame {
	private ArrayList<Level> levels = new ArrayList<Level>();
	private int currLevelNum;
		
	public void addLevel(Level level) {		
		levels.add(level);
	}
	public Level getLevel(int num) {                
		return levels.get(num);
	}
	public Level getCurrentLevel() {
		return levels.get(currLevelNum);
	}
	public void setCurrentLevel(int currLevelNum) {
		this.currLevelNum = currLevelNum;
	}
	public void moveToNextLevel() {
		currLevelNum++;
	}
	public boolean isLastLevel() {
		return currLevelNum == levels.size() - 1;
	}	
}
