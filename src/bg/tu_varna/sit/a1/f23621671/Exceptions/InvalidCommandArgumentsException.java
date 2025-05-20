package bg.tu_varna.sit.a1.f23621671.Exceptions;


/**
 * Exception thrown to indicate that the arguments provided to a command are invalid.
 * <p>
 * This exception can be used to signal that the input parameters do not meet the expected criteria
 * or format for a particular command.
 * </p>
 */
public class InvalidCommandArgumentsException extends Exception {

    /**
     * Constructs a new InvalidCommandArgumentsException with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception
     */
    public InvalidCommandArgumentsException(String message) {
        super(message);
    }
}
