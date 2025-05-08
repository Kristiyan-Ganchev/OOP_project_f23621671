package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.CommandProcessor;
import bg.tu_varna.sit.a1.f23621671.Files.WriteToFile;

public class SaveAsCommand implements Command{
    @Override
    public void runCommand(String input) {
        if(!CommandProcessor.getCurrentFile().equals("")){
            WriteToFile.Write(input,CommandProcessor.toContent(),false);
            System.out.println("Succesfully saved "+ input);
        }
        else System.out.println("No file loaded!");
    }
}
