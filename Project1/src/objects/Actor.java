package objects;

import java.io.Serializable;


/**
 * Actor class is the general class for all the actors in the game
 *
 */
public abstract class Actor implements Serializable {

	private static final long serialVersionUID = 1L;
	Position agentPosition;

	public Actor() {}
	
	public Actor(Position pos) {
		agentPosition = pos;
	}
	
	public Position getAgentPosition() {
		return agentPosition;
	}

	public void setAgentPosition(Position agentPosition) {
		this.agentPosition = agentPosition;
	}
	
}

