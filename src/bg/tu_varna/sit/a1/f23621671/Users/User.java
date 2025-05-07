package bg.tu_varna.sit.a1.f23621671.Users;

public class User {
    private String username;
    private String password;
    private AccessLevel accessLevel;

    public User(String username, String password, AccessLevel accessLevel) {
        this.username = username;
        this.password = password;
        this.accessLevel = accessLevel;
    }

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }
}
