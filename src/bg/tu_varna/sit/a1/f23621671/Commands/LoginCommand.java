package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.CurrentData;
import bg.tu_varna.sit.a1.f23621671.Exceptions.AccessDeniedException;
import bg.tu_varna.sit.a1.f23621671.Exceptions.UserNotFoundException;
import bg.tu_varna.sit.a1.f23621671.Files.ReadFromFile;
import bg.tu_varna.sit.a1.f23621671.Users.AccessLevel;
import bg.tu_varna.sit.a1.f23621671.Users.User;


import java.io.File;
import java.util.Scanner;

/**
 * Command implementation for user login.
 * Prompts the user to enter a username and password,
 * verifies the credentials against a stored users file,
 * and updates the current user in the application context if successful.
 *
 * @throws AccessDeniedException if a user is already logged in.
 * @throws UserNotFoundException if the provided username/password do not match any user.
 */
public class LoginCommand implements Command {
    /**
     * Runs the login command by prompting for username and password,
     * authenticating against stored users,
     * and setting the current user on success.
     *
     * @param input the command arguments (ignored)
     * @throws AccessDeniedException if a user is already logged in.
     * @throws UserNotFoundException if login credentials are invalid.
     */
    @Override
    public void runCommand(String input[]) throws AccessDeniedException, UserNotFoundException {
        if (!CurrentData.getInstance().getCurrentUser().getAccessLevel().equals(AccessLevel.NONE)) {
            throw new AccessDeniedException("Already logged in!");
        }
        Scanner scanner = new Scanner(System.in);
        String[] users = ReadFromFile.readFile("Data" + File.separator + "users.txt").split("\n");
        System.out.println("Input username:");
        String username = scanner.nextLine();
        System.out.println("Input password:");
        String password = scanner.nextLine();

        for (String user : users) {
            String[] userData = user.split(" ");
            if (username.equals(userData[0]) && password.equals(userData[1])) {
                System.out.println("Welcome " + username + "!");
                CurrentData.getInstance().setCurrentUser(new User(username, password, AccessLevel.valueOf(userData[2].trim())));
                break;
            }
        }
        if (CurrentData.getInstance().getCurrentUser().getAccessLevel().equals(AccessLevel.NONE))
            throw new UserNotFoundException("Username or password is wrong");
    }
}

