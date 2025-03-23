package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.CommandProcessor;
import bg.tu_varna.sit.a1.f23621671.Files.ReadFromFile;

public class OpenCommand implements Command{
    @Override
    public void runCommand(String input,StringBuilder output,StringBuilder filename) {
        output.append(ReadFromFile.readFile(input));
        //OPRAVI GO TOVA TUPANAREEE <3

        CommandProcessor.content.append(ReadFromFile.readFile(input));

        filename.setLength(0);
        filename.append(input);
        System.out.println("Successfuly opened "+input);
    }
}
