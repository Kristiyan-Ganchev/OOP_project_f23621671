package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.CommandProcessor;

import java.util.Map;

public class HelpCommand implements Command{
    @Override
    public void runCommand(String input) {
        System.out.println("The following commands are supported:");
        for (CommandEnums command : CommandEnums.values()) {
            System.out.println(command.getDescText());
        }
    }
}
