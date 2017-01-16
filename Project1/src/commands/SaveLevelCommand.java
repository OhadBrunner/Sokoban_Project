package commands;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import levels.LevelSaver;
import levels.MyObjectLevelSaver;
import levels.MyTextLevelSaver;
import levels.MyXMLLevelSaver;
import model.SokobanGame;

/**
*The save command saving the current level to a file
*
*/ 

public class SaveLevelCommand implements Command{
	
	
	HashMap<String, LevelSaver> levelsSavers;
	private SokobanGame game;
	
	public SaveLevelCommand(SokobanGame game) {
	
		this.game = game;
		levelsSavers = new HashMap<String, LevelSaver>();
		levelsSavers.put("txt", new MyTextLevelSaver());
		levelsSavers.put("obj", new MyObjectLevelSaver());
		levelsSavers.put("xml", new MyXMLLevelSaver());
	}
	
	private String getExtension(String fileName)
	{
		String extension = "";
	
		int i = fileName.lastIndexOf('.');
		if (i > 0) {
		    extension = fileName.substring(i+1);
		}
		return extension;
	}

	@Override
	public void execute(String... args) {
	
		String fileName = args[0];
		String st1 = getExtension(fileName);
		LevelSaver saver = levelsSavers.get(st1);			
		
		OutputStream ops =null;
		try {
			
			ops = new FileOutputStream(fileName);
			saver.SaveLevel(game.getCurrentLevel(), ops);
			ops.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return;	
	}
}
