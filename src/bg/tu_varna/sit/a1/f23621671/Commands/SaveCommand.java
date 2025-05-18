package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Library;
import bg.tu_varna.sit.a1.f23621671.CurrentData;
import bg.tu_varna.sit.a1.f23621671.Files.WriteToFile;

public class SaveCommand implements Command {

    @Override
    public void runCommand(String input[]) {
        WriteToFile.Write(CurrentData.getInstance().getCurrentFile(), Library.getInstance().toContent(), false);
        System.out.println("Succesfully saved " + CurrentData.getInstance().getCurrentFile());
    }
}
