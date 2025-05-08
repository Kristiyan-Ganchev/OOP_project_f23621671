package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.CommandProcessor;

public class LogoutCommand implements Command{

    @Override
    public void runCommand(String input) {
        CommandProcessor.setCurrentUser(null);
        System.out.println("Logged out.");
    }
}
