package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Files.ReadFromFile;
import bg.tu_varna.sit.a1.f23621671.Files.WriteToFile;
import bg.tu_varna.sit.a1.f23621671.Users.AccessLevel;

public class UsersAddCommand implements Command {
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
