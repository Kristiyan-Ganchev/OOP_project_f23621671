package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.CommandProcessor;
import bg.tu_varna.sit.a1.f23621671.Files.WriteToFile;

public class SaveCommand implements Command{

    @Override
    public void runCommand(String input) {
        if(!CommandProcessor.currentFile.equals("")){
            WriteToFile.Write(CommandProcessor.currentFile,CommandProcessor.content.toString());
            System.out.println("Succesfully saved "+ CommandProcessor.currentFile);}
        else System.out.println("No file loaded!");
    }
    @Override
    public void description(){
        System.out.println("save\t\t\t  saves the currently open file");
    }
}
