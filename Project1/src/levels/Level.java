package levels;


import java.io.Serializable;
import objects.Cell;
import objects.SokobanPlayer;

/**
 * This class represent a level in the game
 */

public class Level implements Serializable{
    
	private static final long serialVersionUID = 1L;
	private int rows;
	private int cols;
	private int numOfBoxes;
	private int boxesOnTargets;
	private SokobanPlayer player;
	private int steps;
        
	Cell[][] levelMatrix = null;
	
    public Level() {}
	
	public Level(int rows, int cols) {
		this.setRows(rows);
		this.setCols(cols);
		levelMatrix = new Cell[rows][cols];
		this.setNumOfBoxes(0);
		this.setBoxesOnTargets(0);
	}
	
	
	public Cell[][] getLevelMatrix() {
		return levelMatrix;
	}

	public void setLevelMatrix(Cell[][] levelMatrix) {
		this.levelMatrix = levelMatrix;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}
	
	
	public int getNumOfBoxes() {
		return numOfBoxes;
	}

	public void setNumOfBoxes(int numOfBoxes) {
		this.numOfBoxes = numOfBoxes;
	}

	public int getBoxesOnTargets() {
		return boxesOnTargets;
	}

	public void setBoxesOnTargets(int boxesOnTargets) {
		this.boxesOnTargets = boxesOnTargets;
	}

	public void setPlayer(SokobanPlayer player) {
		this.player = player;
	}

	public SokobanPlayer getPlayer() {
		return player;
	}

	public boolean isCompleted() {
		return boxesOnTargets == numOfBoxes;
	}

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}
	
}

