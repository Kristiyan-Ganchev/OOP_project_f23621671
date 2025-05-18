package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.CurrentData;
import bg.tu_varna.sit.a1.f23621671.Exceptions.AccessDeniedException;
import bg.tu_varna.sit.a1.f23621671.Exceptions.UserNotFoundException;
import bg.tu_varna.sit.a1.f23621671.Files.ReadFromFile;
import bg.tu_varna.sit.a1.f23621671.Users.AccessLevel;
import bg.tu_varna.sit.a1.f23621671.Users.User;


import java.io.File;
import java.util.Scanner;

public class LoginCommand implements Command {
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

