package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Library;
import bg.tu_varna.sit.a1.f23621671.Files.WriteToFile;

public class SaveAsCommand implements Command {
    @Override
    public void runCommand(String input[]) {
        WriteToFile.Write(input[0], Library.getInstance().toContent(), false);
        System.out.println("Succesfully saved " + input[0]);
    }
}
