package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.CommandProcessor;
import bg.tu_varna.sit.a1.f23621671.Files.WriteToFile;

public class SaveAsCommand implements Command{
    @Override
    public void runCommand(String input[]) {
            WriteToFile.Write(input[0],CommandProcessor.toContent(),false);
            System.out.println("Succesfully saved "+ input[0]);
    }
}
