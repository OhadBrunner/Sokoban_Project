package policies;

import levels.Level;
import model.SokobanGame;
import objects.Cell;
import objects.Position;
import objects.SokobanBox;
import objects.SokobanPlayer;


/**
*This is our policy. all the moves in the game are taking considering this policy.
*The MakeMove function interpret the user request and use the makeMoveInDirection function in order to perform the moves on the game
*/

public class MySokobanPolicy extends SokobanPolicies {
			
	public MySokobanPolicy(SokobanGame game) {	
		this.game = game;		
	}
	
	private boolean makeMoveInDirection(Position nextPlayerPos, Position nextBoxPos) {		
		
		Level level = game.getCurrentLevel();
		Cell[][] mat = level.getLevelMatrix();
		SokobanPlayer player = level.getPlayer();
		Position playerPos = player.getAgentPosition();
		boolean canPlayerMove = true;
										
		if (mat[nextPlayerPos.getY()][nextPlayerPos.getX()].CheckIfWall())
			canPlayerMove = false;		
		
		else if (mat[nextPlayerPos.getY()][nextPlayerPos.getX()].CheckIfBox()){			
			if ((mat[nextBoxPos.getY()][nextBoxPos.getX()].CheckIfWall()) || mat[nextBoxPos.getY()][nextBoxPos.getX()].CheckIfBox())
				canPlayerMove = false;
			
			else { 
				if (mat[nextPlayerPos.getY()][nextPlayerPos.getX()].CheckIfTarget()) {	
					level.setBoxesOnTargets(level.getBoxesOnTargets() - 1);		
				}				
				
				if (mat[nextBoxPos.getY()][nextBoxPos.getX()].CheckIfTarget()) {	
					level.setBoxesOnTargets(level.getBoxesOnTargets() + 1);		
				}			
			
				SokobanBox box = mat[nextPlayerPos.getY()][nextPlayerPos.getX()].getBox();
				box.setAgentPosition(nextBoxPos);								
				mat[nextBoxPos.getY()][nextBoxPos.getX()].actors.add(box);
				mat[nextPlayerPos.getY()][nextPlayerPos.getX()].actors.remove(box);				
			}
		}	
		
		if (canPlayerMove) {
			player.setAgentPosition(nextPlayerPos);		
			mat[playerPos.getY()][playerPos.getX()].actors.remove(player);
			mat[nextPlayerPos.getY()][nextPlayerPos.getX()].actors.add(player);	
		}
		
		return canPlayerMove;
	}
		
	@Override
	public boolean makeMove(String move) {    
		Level level = game.getCurrentLevel();
		Position playerPos = level.getPlayer().getAgentPosition();
		
		if (move.equals("left")) {
			return makeMoveInDirection(new Position(playerPos.getX() - 1, playerPos.getY()), 
					new Position(playerPos.getX() - 2, playerPos.getY()));
		}
		else if (move.equals("right")) {
			return makeMoveInDirection(new Position(playerPos.getX() + 1, playerPos.getY()), 
					new Position(playerPos.getX() + 2, playerPos.getY()));
		}
		else if (move.equals("up")) {
			return makeMoveInDirection(new Position(playerPos.getX(), playerPos.getY() - 1), 
					new Position(playerPos.getX(), playerPos.getY() - 2));
		}
		else if (move.equals("down")) {
			return makeMoveInDirection(new Position(playerPos.getX(), playerPos.getY() + 1), 
					new Position(playerPos.getX(), playerPos.getY() + 2));
		}			
		return false;
	}
}
