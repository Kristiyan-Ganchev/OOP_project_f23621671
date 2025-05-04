package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Files.WriteToFile;
import bg.tu_varna.sit.a1.f23621671.Files.ReadFromFile;
import bg.tu_varna.sit.a1.f23621671.Users.AccessLevel;

public class UsersRemoveCommand implements Command{
    @Override
    public void runCommand(String input) {
        String[] users= ReadFromFile.readFile("src/bg/tu_varna/sit/a1/f23621671/Data/users.txt").split("\n");
        StringBuilder tempFile = new StringBuilder();
        for (String user:users) {
            String[] userData=user.split(" ");
            if(!(input.equals(userData[0]))){
                tempFile.append(user+"\n");
            }
        }
        WriteToFile.Write("src/bg/tu_varna/sit/a1/f23621671/Data/users.txt",tempFile.toString(),false);
        System.out.println("User removed!");
    }

    @Override
    public void description() {
        System.out.println("users remove");
    }
}
