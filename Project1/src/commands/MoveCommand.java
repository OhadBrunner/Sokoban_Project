package commands;

import objects.SokobanPlayer;
import policies.SokobanPolicies;
import levels.Level;
import model.SokobanGame;

/**
 *The move command is responsible to use the right policy for making the moves in the game.
 *It's also responsible to let the user know when he asks for an invalid move or when he finish a level or the game.
 */

public class MoveCommand implements Command{
	
	SokobanPolicies myPolicy;
	SokobanGame game;
	SokobanPlayer player;	
	
	public MoveCommand(SokobanGame game, SokobanPolicies policy) {	
		this.game = game;
		myPolicy = policy;		
	}
		
	@Override
	public void execute(String... args) {
		if (args == null)
		{
			System.out.println("You must specify direction");
			return;
		}		
		
		String move = args[0];
		Level level = game.getCurrentLevel();
								
		if (!(myPolicy.makeMove(move))) 
		{
			System.out.println("Impossible Move!");
			return;
		}
		
		level.setSteps(level.getSteps() + 1);
		
		if (level.isCompleted()) {
			if (game.isLastLevel()) {
				System.out.println("Game finished!");
			}
			else {
				System.out.println("Level finished! You did it with " + level.getSteps() + " steps. You have reached the next level.");
				game.moveToNextLevel();
				
			}			
		}
	}
}
