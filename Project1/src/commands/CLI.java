package commands;

import java.util.HashMap;
import java.util.Scanner;
import model.SokobanGame;
import policies.MySokobanPolicy;
import policies.SokobanPolicies;

/**
 *The CLI is the invoker. as long as the user doesn't ask for exit, the CLI continue with the loop, and activate the commands considering the user requests.
 *
 */

public class CLI {
	private HashMap<String, Command> commands = new HashMap<String, Command>();
	private SokobanGame game;
	private SokobanPolicies policy;
	private boolean isGameFinished;
	
	public CLI() {
		game = new SokobanGame();
		policy = new MySokobanPolicy(game);
		
		commands.put("Load", new LoadLevelCommand(game));
		commands.put("Display", new DisplayLevelCommand(game));
		commands.put("Move", new MoveCommand(game, policy));
		commands.put("Save", new SaveLevelCommand(game));
		commands.put("Exit", new ExitCommand(this));		
	}
	
	public void setIsGameFinished(boolean isGameFinished) {
		this.isGameFinished = isGameFinished;
	}
	
	public void start() {
		String commandLine = null;
		Command command = null;
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.print("Enter command: ");             
			commandLine = scanner.nextLine();                  
			String[] arr = commandLine.split(" ");             
			String commandName = arr[0];						 
			
			String[] args = null;
			if (arr.length > 1) { 			
				args = new String[arr.length - 1];
				System.arraycopy(arr, 1, args, 0, arr.length - 1);				
			}
			
			command = commands.get(commandName);								
			if (command == null)  {
				System.out.println("Invalid command");						 
			}
			else {
				command.execute(args);											
			}
			
		} while (!isGameFinished);							

		scanner.close();
	}
}
