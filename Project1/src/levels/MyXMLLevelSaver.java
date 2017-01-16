package levels;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.OutputStream;

/**
*This class is saving the current level to XML file
*
*/

public class MyXMLLevelSaver implements LevelSaver{

	@Override
	public void SaveLevel(Level level, OutputStream os) {
		
		XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(os));
		
		encoder.writeObject(level);
		
		encoder.close();
	}
}
