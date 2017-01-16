package objects;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * This class is for the cells in the level matrix. each cell is a list that contains Actors.
 *
 */

public class Cell implements Serializable {

	
	private static final long serialVersionUID = 1L;
	public ArrayList<Actor> actors = new ArrayList<Actor>();
	
	public Cell() {}
	
	
	public boolean CheckIfWall(){		
		for (Actor actor: actors) {
		   if (actor instanceof SokobanWall)
		        return true;
		}
		return false;		
	}
	
	public boolean CheckIfBox() {		
		for (Actor actor: actors) {
		   if (actor instanceof SokobanBox)
		        return true;
		}
		return false;		
	}
	
	public SokobanBox getBox() {
		for (Actor actor: actors) {
		   if (actor instanceof SokobanBox)
		        return (SokobanBox)actor;
		}
		return null;
	}
	
	public boolean CheckIfPlayer(){
		
		for (Actor actor: actors) {
		   if (actor instanceof SokobanPlayer)
		        return true;
		}
		return false;
		
	}
	
	public boolean CheckIfTarget(){
		
		for (Actor actor: actors) {
			   if (actor instanceof SokobanTarget)
			        return true;
			}
			return false;
		
	}
	
	public boolean CheckIfFloor() {
		return actors.size() == 0;
	}
	
}
