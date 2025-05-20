package bg.tu_varna.sit.a1.f23621671.Exceptions;

/**
 * Exception thrown when a requested user cannot be found.
 * <p>
 * This exception indicates that the specified user does not exist in the system or database.
 * </p>
 */
public class UserNotFoundException extends Exception {

    /**
     * Constructs a new UserNotFoundException with the specified detail message.
     *
     * @param message the detail message explaining why the user was not found
     */
    public UserNotFoundException(String message) {
        super(message);
    }
}
