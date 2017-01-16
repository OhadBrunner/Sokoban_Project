package commands;

/**
*When the user asks for exit, the CLI stop with it's loop and doesn't ask for another command.
*
*/

public class ExitCommand implements Command{
	private CLI cli;
	
	public ExitCommand(CLI cli) {
		this.cli = cli;
	}

	@Override
	public void execute(String... args) {        			
		cli.setIsGameFinished(true);
	}
}
