package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.CommandProcessor;

public class CloseCommand implements Command{
    @Override
    public void runCommand(String input[]) {
        if(!CommandProcessor.getCurrentFile().equals("")){
            CommandProcessor.clearBooks();
            System.out.println("Successfully closed "+CommandProcessor.getCurrentFile());
            CommandProcessor.setCurrentFile("");
        }
        else System.out.println("No file loaded!");
    }
}
