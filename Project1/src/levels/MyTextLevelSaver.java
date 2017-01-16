package levels;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
*This class is writing a level to a text file
*
*/

public class MyTextLevelSaver implements LevelSaver{

	@Override
	public void SaveLevel(Level level, OutputStream os) {
	
		PrintWriter writer = null;
				
		try {
			writer = new PrintWriter(new OutputStreamWriter(os));
			LevelDisplayer displayer = new LevelDisplayer();
			String str = displayer.displayLevel(level);						
			writer.write(str);												
		}
		finally {
			writer.close();
		}
	}
}
