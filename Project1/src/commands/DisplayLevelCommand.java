package commands;

/**
*The display command. use the level displayer in order to display the level
*
*/

import levels.LevelDisplayer;
import model.SokobanGame;

public class DisplayLevelCommand implements Command{

	private SokobanGame game;
	public DisplayLevelCommand(SokobanGame game) {
		this.game = game;
	}	
	
	@Override
	public void execute(String... args) {
		LevelDisplayer displayer = new LevelDisplayer();
		String str = displayer.displayLevel(game.getCurrentLevel());
		System.out.println(str);
	}
}
