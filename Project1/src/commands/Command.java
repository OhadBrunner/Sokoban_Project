package commands;

/**
*This interface contains the execute function for all the commands
*
*/

public interface Command {

	public void execute(String... args); // accepts unlimited number of arguments
	
}
