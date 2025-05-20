package bg.tu_varna.sit.a1.f23621671.Commands;

/**
 * Command implementation to exit the program.
 * When executed, it prints a message and terminates the application.
 */
public class ExitCommand implements Command {
    /**
     * Executes the exit command, printing a message and stopping the JVM.
     *
     * @param input the command arguments (ignored)
     */
    @Override
    public void runCommand(String input[]) {
        System.out.print("Exiting the program...");
        System.exit(0);
    }
}
