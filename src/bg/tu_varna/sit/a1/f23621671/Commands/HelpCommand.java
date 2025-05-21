package bg.tu_varna.sit.a1.f23621671.Commands;

/**
 * Command implementation that displays a list of all supported commands
 * with their descriptions.
 */
public class HelpCommand implements Command {
    /**
     * Executes the help command by printing all available commands
     * and their descriptions to the standard output.
     *
     * @param input the command arguments (ignored)
     */
    @Override
    public void runCommand(String[] input) {
        System.out.println("The following commands are supported:");
        for (CommandEnums command : CommandEnums.values()) {
            System.out.println(command.getDescText());
        }
    }
}
