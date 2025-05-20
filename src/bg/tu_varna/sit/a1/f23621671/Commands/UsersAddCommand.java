package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Files.ReadFromFile;
import bg.tu_varna.sit.a1.f23621671.Files.WriteToFile;
import bg.tu_varna.sit.a1.f23621671.Users.AccessLevel;


/**
 * Command implementation for adding a new user to the system.
 * This class handles the "users add" command functionality.
 * <p>
 * It checks if the user with the specified username and password already exists
 * in the users file. If not, it appends the new user with {@link AccessLevel#USER}
 * access level to the file.
 */
public class UsersAddCommand implements Command {

    /**
     * Executes the "users add" command.
     * <ul>
     *     <li>Reads existing users from the "Data/users.txt" file.</li>
     *     <li>Checks for duplicates based on username and password.</li>
     *     <li>If the user does not exist, appends a new user with {@link AccessLevel#USER} to the file.</li>
     * </ul>
     *
     * @param input The command arguments: {@code input[0]} is the username, {@code input[1]} is the password.
     */
    @Override
    public void runCommand(String input[]) {
        boolean userExists = false;
        String[] users = ReadFromFile.readFile("Data/users.txt").split("\n");

        for (String user : users) {
            String[] userData = user.split(" ");
            if (input[0].equals(userData[0]) && input[1].equals(userData[1])) {
                System.out.println("User already exists");
                userExists = true;
                break;
            }
        }
        if (!userExists) {
            WriteToFile.Write("./Data/users.txt", "\n" + input[0] + " " + input[1] + " " + AccessLevel.USER, true);
            System.out.println("User added!");
        }
    }
}
