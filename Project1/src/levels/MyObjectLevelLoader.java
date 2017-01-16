package levels;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
*This class loading a level from an object file
*
*/

public class MyObjectLevelLoader implements LevelLoader{

	@Override
	public Level loadLevel(InputStream is) {

		Level newLevel = null;
		
		try {
			ObjectInputStream ois = new ObjectInputStream(is);
			
			newLevel = (Level)ois.readObject();
			ois.close();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}

		return newLevel;
	}
}
