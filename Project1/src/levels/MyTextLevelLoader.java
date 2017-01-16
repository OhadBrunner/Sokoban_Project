package levels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import objects.Cell;
import objects.Position;
import objects.SokobanBox;
import objects.SokobanPlayer;
import objects.SokobanTarget;
import objects.SokobanWall;

/**
*This class is loading a level in the shape of a text and make it a level object by initial it in a matrix that contains Cells.
*
*/

public class MyTextLevelLoader implements LevelLoader{

	@Override
	public Level loadLevel(InputStream is) {

		int cols = 0;
		int rows = 0;
		
		BufferedReader br = null;		
		String line;
		Level newLevel = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(is));
			ArrayList<String> lines = new ArrayList<String>();
	
			while ((line = br.readLine()) != null) {
				rows++;
				cols = line.length(); 	
				lines.add(line);
			}
		
			newLevel = new Level(rows, cols);			
			Cell[][] mat = newLevel.getLevelMatrix();
			int num_Of_Boxes = newLevel.getNumOfBoxes();
		
			for (int i = 0; i < rows; i++) {
				line = lines.get(i);
				
				for (int j = 0; j < cols; j++) {
					char item = line.charAt(j);
										
					mat[i][j] = new Cell();
					
					switch (item) {
					case '#':
						SokobanWall wall = new SokobanWall(new Position(j, i));		                
						mat[i][j].actors.add(wall);
						break;
					case '@':
						SokobanBox box = new SokobanBox(new Position(j, i));
						mat[i][j].actors.add(box);
						newLevel.setNumOfBoxes(num_Of_Boxes++);
						break;
					case 'o':
						SokobanTarget target = new SokobanTarget(new Position(j, i));		                
						mat[i][j].actors.add(target);
		                break;
					case 'A':
						SokobanPlayer player = new SokobanPlayer(new Position(j, i));
						mat[i][j].actors.add(player);
						newLevel.setPlayer(player);
						break;
					case ' ':						
			            break; // a floor is a cell with no actors
			        default:
			        	throw new RuntimeException("Invalid character");			        	
					}
				}
			}					     
	    		 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
				e.printStackTrace(); 
				}
			}	 
		
		}	
		return newLevel;	
	}
}
