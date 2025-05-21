package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Exceptions.NoDataException;
import bg.tu_varna.sit.a1.f23621671.Files.WriteToFile;
import bg.tu_varna.sit.a1.f23621671.Files.ReadFromFile;

/**
 * Command implementation for removing a user from the system.
 * This class handles the "users remove" command functionality.
 * <p>
 * It searches for a user by username in the "Data/users.txt" file and removes them if found.
 * The command does not require the password or access level to match.
 */
public class UsersRemoveCommand implements Command {

    /**
     * Executes the "users remove" command.
     * <ul>
     *     <li>Reads all users from the "Data/users.txt" file.</li>
     *     <li>Filters out the user with a matching username.</li>
     *     <li>Overwrites the file with the updated user list.</li>
     * </ul>
     *
     * @param input The command arguments: {@code input[0]} is the username of the user to remove.
     * @throws NoDataException If the specified user does not exist.
     */
    @Override
    public void runCommand(String[] input) throws NoDataException {
        String[] users = ReadFromFile.readFile("Data/users.txt").split("\n");
        StringBuilder tempFile = new StringBuilder();
        boolean userExists = false;
        for (String user : users) {
            String[] userData = user.split(" ");
            if (!(input[0].equals(userData[0]))) {
                tempFile.append(user + "\n");
            } else userExists = true;
        }
        WriteToFile.Write("Data/users.txt", tempFile.toString(), false);
        if (userExists)
            System.out.println("User removed!");
        else throw new NoDataException("User doesn't exist!");
    }
}
