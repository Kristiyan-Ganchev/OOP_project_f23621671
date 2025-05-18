package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Exceptions.NoDataException;
import bg.tu_varna.sit.a1.f23621671.Files.WriteToFile;
import bg.tu_varna.sit.a1.f23621671.Files.ReadFromFile;

public class UsersRemoveCommand implements Command {
    @Override
    public void runCommand(String input[]) throws NoDataException {
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
