package levels;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
*This class is saving the current level to an object file
*
*/

public class MyObjectLevelSaver implements LevelSaver{

	@Override
	public void SaveLevel(Level level, OutputStream os) {
		
		try {
			ObjectOutputStream obs = new ObjectOutputStream(os);
			obs.writeObject(level);
			obs.close();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
}
