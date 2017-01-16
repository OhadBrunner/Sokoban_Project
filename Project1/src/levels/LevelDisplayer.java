package levels;


/**
*This class is doing the interpretation from the object level to a string of chars, so the display command could manage to display the level to the user.
*
*/

import objects.Cell;

public class LevelDisplayer {
	
	public String displayLevel(Level level) {
		
		Cell[][] mat = level.getLevelMatrix();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				
				Cell cell = mat[i][j];
				
				if (cell.CheckIfFloor())
					sb.append(' ');
				else if (cell.CheckIfWall())
					sb.append('#');
				else if (cell.CheckIfBox())
					sb.append('@');
				else if (cell.CheckIfPlayer())
					sb.append('A');				
				else if (cell.CheckIfTarget())
					sb.append('o');
			}
			sb.append('\n');
		}
		return sb.toString();
	}
}
