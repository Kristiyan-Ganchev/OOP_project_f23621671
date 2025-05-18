package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Library;
import bg.tu_varna.sit.a1.f23621671.CurrentData;

public class CloseCommand implements Command {
    @Override
    public void runCommand(String input[]) {
        Library.getInstance().clearBooks();
        System.out.println("Successfully closed " + CurrentData.getInstance().getCurrentFile());
        CurrentData.getInstance().setCurrentFile("");
    }
}
