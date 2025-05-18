package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.CurrentData;
import bg.tu_varna.sit.a1.f23621671.Users.AccessLevel;
import bg.tu_varna.sit.a1.f23621671.Users.User;

public class LogoutCommand implements Command {

    @Override
    public void runCommand(String input[]) {
        CurrentData.getInstance().setCurrentUser(new User("none", "none", AccessLevel.NONE));
        System.out.println("Logged out.");
    }
}
