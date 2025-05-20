package bg.tu_varna.sit.a1.f23621671;

import bg.tu_varna.sit.a1.f23621671.Users.AccessLevel;
import bg.tu_varna.sit.a1.f23621671.Users.User;

/**
 * Singleton class that holds the current application state data.
 * <p>
 * Stores the current logged-in user and the currently opened file path.
 * Provides global access to this state throughout the application.
 * </p>
 */
public class CurrentData {
    private static CurrentData instance = null;
    private static User currentUser;
    private static String currentFile;

    /**
     * Private constructor to prevent direct instantiation.
     * Initializes the current user with no access and sets the current file to empty.
     */
    private CurrentData() {
        currentUser = new User(null, null, AccessLevel.NONE);
        currentFile = "";
    }

    /**
     * Returns the singleton instance of the CurrentData class.
     * Creates the instance if it does not yet exist.
     *
     * @return the singleton instance
     */
    public static CurrentData getInstance() {
        if (instance == null) {
            instance = new CurrentData();
        }
        return instance;
    }

    /**
     * Returns the currently logged-in user.
     *
     * @return the current user
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Returns the current file path.
     *
     * @return the current file path as a string
     */
    public String getCurrentFile() {
        return currentFile;
    }

    /**
     * Sets the current logged-in user.
     *
     * @param currentUser the user to set as current
     */
    public void setCurrentUser(User currentUser) {
        CurrentData.currentUser = currentUser;
    }

    /**
     * Sets the current file path.
     *
     * @param currentFile the file path to set as current
     */
    public void setCurrentFile(String currentFile) {
        CurrentData.currentFile = currentFile;
    }
}
