package bg.tu_varna.sit.a1.f23621671.Commands;

public class CloseCommand implements Command{
    @Override
    public void runCommand(String input, StringBuilder output,StringBuilder filename) {
        output.setLength(0);
        System.out.println("Successfully closed "+filename);
    }
}
