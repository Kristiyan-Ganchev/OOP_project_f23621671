package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.CommandProcessor;
import bg.tu_varna.sit.a1.f23621671.Files.ReadFromFile;

public class OpenCommand implements Command{
    @Override
    public void runCommand(String input) {
        CommandProcessor.content.append(ReadFromFile.readFile(input));
        CommandProcessor.currentFile=input;
        System.out.println("Successfuly opened "+input);
    }
    @Override
    public void description(){
        System.out.println("open <file>\t\t  opens <file>\n");
    }
}
