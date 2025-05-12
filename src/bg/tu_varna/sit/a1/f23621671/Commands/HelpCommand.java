package bg.tu_varna.sit.a1.f23621671.Commands;

public class HelpCommand implements Command{
    @Override
    public void runCommand(String input[]) {
        System.out.println("The following commands are supported:");
        for (CommandEnums command : CommandEnums.values()) {
            System.out.println(command.getDescText());
        }
    }
}
