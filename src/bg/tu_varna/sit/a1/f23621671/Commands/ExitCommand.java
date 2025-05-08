package bg.tu_varna.sit.a1.f23621671.Commands;

public class ExitCommand implements Command{
    @Override
    public void runCommand(String input) {
        System.out.print("Exiting the program...");
        System.exit(0);
    }
}
