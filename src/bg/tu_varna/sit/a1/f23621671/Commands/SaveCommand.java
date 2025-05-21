package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Library;
import bg.tu_varna.sit.a1.f23621671.CurrentData;
import bg.tu_varna.sit.a1.f23621671.Exceptions.NoDataException;
import bg.tu_varna.sit.a1.f23621671.Files.WriteToFile;


/**
 * Command implementation for saving the current state of the {@link Library}
 * to the currently opened file. This class handles the "save" functionality
 * and ensures that a file is open before proceeding.
 */
public class SaveCommand implements Command {

    /**
     * Executes the "save" command.
     * <ul>
     *     <li>Checks if a file is currently open using {@link CurrentData}.</li>
     *     <li>If a file is open, writes the current content of the {@link Library} to that file.</li>
     *     <li>Throws {@link NoDataException} if no file is open.</li>
     * </ul>
     *
     * @param input The command arguments (not used for this command).
     * @throws NoDataException if no file is currently open.
     */
    @Override
    public void runCommand(String[] input) throws NoDataException {
        if (CurrentData.getInstance().getCurrentFile().equalsIgnoreCase(""))
            throw new NoDataException("Must have file open to use command!");
        WriteToFile.Write(CurrentData.getInstance().getCurrentFile(), Library.getInstance().toContent(), false);
        System.out.println("Succesfully saved " + CurrentData.getInstance().getCurrentFile());
    }
}
