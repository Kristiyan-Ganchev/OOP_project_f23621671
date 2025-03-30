package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.CommandProcessor;
import bg.tu_varna.sit.a1.f23621671.Files.WriteToFile;

public class SaveCommand implements Command{

    @Override
    public void runCommand(String input) {
        if(!CommandProcessor.currentFile.equals("")){
            StringBuilder content=new StringBuilder();
            for (Book book: CommandProcessor.books) {
                content.append(book.toWrite());
            }
            content.setLength(content.length()-1);
            WriteToFile.Write(CommandProcessor.currentFile,content.toString());
            System.out.println("Succesfully saved "+ CommandProcessor.currentFile);}
        else System.out.println("No file loaded!");
    }
    @Override
    public void description(){
        System.out.println("save\t\t\t  saves the currently open file");
    }
}
