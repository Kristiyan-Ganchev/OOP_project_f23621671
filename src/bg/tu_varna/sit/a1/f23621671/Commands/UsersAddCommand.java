package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.CommandProcessor;
import bg.tu_varna.sit.a1.f23621671.Files.ReadFromFile;
import bg.tu_varna.sit.a1.f23621671.Files.WriteToFile;
import bg.tu_varna.sit.a1.f23621671.Users.AccessLevel;
import bg.tu_varna.sit.a1.f23621671.Users.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UsersAddCommand implements Command{
    @Override
    public void runCommand(String input) {
        String[] userAndPassword = input.split(" ");
        boolean userExists=false;
        String[] users= ReadFromFile.readFile("src/bg/tu_varna/sit/a1/f23621671/Data/users.txt").split("\n");

        for (String user:users) {
            String[] userData=user.split(" ");
            if(userAndPassword[0].equals(userData[0])&&userAndPassword[1].equals(userData[1])){
                System.out.println("User already exists");
                userExists=true;
                break;
            }
        }
        if(!userExists){
            WriteToFile.Write("src/bg/tu_varna/sit/a1/f23621671/Data/users.txt","\n"+userAndPassword[0]+" "+userAndPassword[1]+" "+AccessLevel.USER,true);
            System.out.println("User added!");
        }
    }

    @Override
    public void description() {
        System.out.println("users add");
    }
}
