package levels;

import java.io.OutputStream;

/**
*An interface for all the level savers, contains the SaveLevel function
*
*/

public interface LevelSaver{

	public void SaveLevel(Level level, OutputStream os);
}
