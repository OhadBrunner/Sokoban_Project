package levels;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.InputStream;

/**
*This class loading a level from XML file
*
*/

public class MyXMLLevelLoader implements LevelLoader{

	@Override
	public Level loadLevel(InputStream is) {
		
		Level newLevel = null;
		
		XMLDecoder decoter = new XMLDecoder(new BufferedInputStream(is));
		
		newLevel = (Level)decoter.readObject();
		
		decoter.close();
		
		return newLevel;
	}
}
