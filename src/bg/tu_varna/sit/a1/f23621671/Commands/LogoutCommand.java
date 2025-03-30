package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.CommandProcessor;

public class LogoutCommand implements Command{

    @Override
    public void runCommand(String input) {
        if(CommandProcessor.currentUser==null){
            System.out.println("Not logged in");
        }
        else {
            CommandProcessor.currentUser = null;
            System.out.println("Logged out.");
        }
    }

    @Override
    public void description() {
        System.out.println("logout");
    }
}
