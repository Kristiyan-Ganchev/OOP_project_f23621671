package bg.tu_varna.sit.a1.f23621671.Users;

/**
 * Represents a user with a username, password, and access level.
 */
public class User {
    private String username;
    private String password;
    private AccessLevel accessLevel;

    /**
     * Constructs a new User with the specified username, password, and access level.
     *
     * @param username    the username of the user
     * @param password    the password of the user
     * @param accessLevel the access level of the user
     */
    public User(String username, String password, AccessLevel accessLevel) {
        this.username = username;
        this.password = password;
        this.accessLevel = accessLevel;
    }

    /**
     * Returns the access level of the user.
     *
     * @return the access level
     */
    public AccessLevel getAccessLevel() {
        return accessLevel;
    }
}
