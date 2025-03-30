package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.CommandProcessor;
import bg.tu_varna.sit.a1.f23621671.Files.WriteToFile;

public class SaveAsCommand implements Command{
    @Override
    public void runCommand(String input) {
        if(!CommandProcessor.currentFile.equals("")){
            StringBuilder content=new StringBuilder();
            for (Book book: CommandProcessor.books) {
                content.append(book.toWrite());
            }
            content.setLength(content.length()-1);
            WriteToFile.Write(input,content.toString());
            System.out.println("Succesfully saved "+ input);
        }
        else System.out.println("No file loaded!");
    }
    @Override
    public void description(){
        System.out.println("saveas <file>\t  saves the currently open file in <file>");
    }
}
