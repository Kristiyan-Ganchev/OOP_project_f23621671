package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Library;
import bg.tu_varna.sit.a1.f23621671.CurrentData;

/**
 * Command implementation to close the current library session.
 * Clears all books from the library and resets the current file reference.
 */
public class CloseCommand implements Command {
    /**
     * Executes the close command.
     * Clears all books in the library and resets the current file.
     *
     * @param input command arguments (not used)
     */
    @Override
    public void runCommand(String input[]) {
        Library.getInstance().clearBooks();
        System.out.println("Successfully closed " + CurrentData.getInstance().getCurrentFile());
        CurrentData.getInstance().setCurrentFile("");
    }
}
