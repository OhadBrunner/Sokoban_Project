package commands;


import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import levels.Level;
import levels.LevelLoader;
import levels.MyObjectLevelLoader;
import levels.MyTextLevelLoader;
import levels.MyXMLLevelLoader;
import model.SokobanGame;

/**
*The load command loading a level from a file
*
*/ 
public class LoadLevelCommand implements Command{ 
		
	HashMap<String, LevelLoader> levelsLoaders;
	private SokobanGame game;
	
	public LoadLevelCommand(SokobanGame game) { 
		this.game = game;
		levelsLoaders = new HashMap<String, LevelLoader>();
		levelsLoaders.put("txt", new MyTextLevelLoader());
		levelsLoaders.put("obj", new MyObjectLevelLoader());
		levelsLoaders.put("xml", new MyXMLLevelLoader());
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
	
	public void execute(String... args) {		
		String fileName = args[0];
	
		String st1 = getExtension(fileName);
		LevelLoader loader = levelsLoaders.get(st1);			
		InputStream ips =null;
		
		try {
			ips = new FileInputStream(fileName);
			Level level = loader.loadLevel(ips);
			game.addLevel(level);											  
			     			
			ips.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return;
	}
}
