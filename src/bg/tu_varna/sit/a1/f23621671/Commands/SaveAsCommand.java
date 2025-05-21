package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Library;
import bg.tu_varna.sit.a1.f23621671.Files.WriteToFile;

/**
 * Command implementation for saving the current state of the {@link Library}
 * to a specified file. This command is used to perform a "save as" operation,
 * which writes the book data to a user-defined file location.
 */
public class SaveAsCommand implements Command {

    /**
     * Executes the "save as" command.
     * - Saves the current book data from {@link Library} to the specified file.
     * - Overwrites the file if it already exists.
     *
     * @param input the command arguments, where input[0] is the target file path
     */
    @Override
    public void runCommand(String[] input) {
        WriteToFile.Write(input[0], Library.getInstance().toContent(), false);
        System.out.println("Succesfully saved " + input[0]);
    }
}
