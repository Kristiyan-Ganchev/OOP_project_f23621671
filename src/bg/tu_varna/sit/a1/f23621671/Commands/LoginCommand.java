package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.CommandProcessor;
import bg.tu_varna.sit.a1.f23621671.Files.ReadFromFile;
import bg.tu_varna.sit.a1.f23621671.Users.AccessLevel;
import bg.tu_varna.sit.a1.f23621671.Users.User;


import java.util.Scanner;

public class LoginCommand implements Command{
    @Override
    public void runCommand(String input) {
        if(CommandProcessor.currentUser!=null ){
            System.out.println("Already logged in!");
            return;
        }
        Scanner scanner=new Scanner(System.in);
        String[] users= ReadFromFile.readFile("src/bg/tu_varna/sit/a1/f23621671/Data/users.txt").split("\n");
        System.out.println("Input username:");
        String username= scanner.nextLine();
        System.out.println("Input password:");
        String password= scanner.nextLine();

        for (String user:users) {
            String[] userData=user.split(" ");
            if(username.equals(userData[0])&&password.equals(userData[1])){
                System.out.println("Welcome "+username+"!");
                CommandProcessor.currentUser=new User(username,password, AccessLevel.valueOf(userData[2].trim()));
                break;
            }

        }
        if(CommandProcessor.currentUser==null)System.out.println("Username or password is wrong.");
    }

    @Override
    public void description() {
        System.out.println("login");
    }
}
