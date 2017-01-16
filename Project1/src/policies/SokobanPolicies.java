package policies;

import model.SokobanGame;

/**
*This is an abstract class for all the possible policies
*
*/

public abstract class SokobanPolicies {	
	protected SokobanGame game;
	
	public abstract boolean makeMove(String move);
}
