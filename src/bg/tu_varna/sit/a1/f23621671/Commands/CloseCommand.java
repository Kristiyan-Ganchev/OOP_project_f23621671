package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.CommandProcessor;

public class CloseCommand implements Command{
    @Override
    public void runCommand(String input) {
        if(!CommandProcessor.currentFile.equals("")){
        CommandProcessor.books.clear();
        System.out.println("Successfully closed "+CommandProcessor.currentFile);
        CommandProcessor.currentFile="";}
        else System.out.println("No file loaded!");
    }
    @Override
    public void description(){
        System.out.println("close\t\t\t  closes currently opened file");
    }
}
