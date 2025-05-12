package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.CommandProcessor;
import bg.tu_varna.sit.a1.f23621671.Files.WriteToFile;

public class SaveCommand implements Command{

    @Override
    public void runCommand(String input[]) {
            WriteToFile.Write(CommandProcessor.getCurrentFile(),CommandProcessor.toContent(),false);
            System.out.println("Succesfully saved "+ CommandProcessor.getCurrentFile());
    }
}
