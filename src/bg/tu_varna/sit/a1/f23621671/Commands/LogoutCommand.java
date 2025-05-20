package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.CurrentData;
import bg.tu_varna.sit.a1.f23621671.Users.AccessLevel;
import bg.tu_varna.sit.a1.f23621671.Users.User;

/**
 * Command implementation for logging out the currently logged-in user.
 * Resets the current user to a default "none" user with no access level.
 * This effectively ends the session for the current user.
 */
public class LogoutCommand implements Command {

    /**
     * Executes the logout command.
     * Clears the current user session by setting a dummy user with {@link AccessLevel#NONE}.
     *
     * @param input the command arguments (not used for this command)
     */
    @Override
    public void runCommand(String input[]) {
        CurrentData.getInstance().setCurrentUser(new User("none", "none", AccessLevel.NONE));
        System.out.println("Logged out.");
    }
}
