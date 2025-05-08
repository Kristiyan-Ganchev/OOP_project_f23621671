package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.CommandProcessor;
import bg.tu_varna.sit.a1.f23621671.Files.WriteToFile;
import bg.tu_varna.sit.a1.f23621671.Files.ReadFromFile;
import bg.tu_varna.sit.a1.f23621671.Users.AccessLevel;

import java.util.Arrays;

public class UsersRemoveCommand implements Command{
    @Override
    public void runCommand(String input) {
        String[] users= ReadFromFile.readFile("Data/users.txt").split("\n");
        StringBuilder tempFile = new StringBuilder();
        for (String user:users) {
            String[] userData=user.split(" ");
            if(!(input.equals(userData[0]))){
                tempFile.append(user+"\n");
            }
        }
        WriteToFile.Write("Data/users.txt",tempFile.toString(),false);
        System.out.println("User removed!");
    }
}
