package bg.tu_varna.sit.a1.f23621671.Exceptions;


/**
 * Exception thrown when a command is invalid or not recognized.
 * <p>
 * This exception indicates that the command issued does not match any known or supported commands.
 * </p>
 */
public class InvalidCommandException extends Exception {

    /**
     * Constructs a new InvalidCommandException with the specified detail message.
     *
     * @param message the detail message explaining why the command is invalid
     */
    public InvalidCommandException(String message) {
        super(message);
    }
}
