package bg.tu_varna.sit.a1.f23621671.Commands;

public class ExitCommand implements Command{
    @Override
    public void runCommand(String input,StringBuilder output,StringBuilder filename) {
        System.out.print("Exiting the program...");
        System.exit(0);
    }
}
