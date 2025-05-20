package bg.tu_varna.sit.a1.f23621671.Exceptions;


/**
 * Exception thrown when the application encounters malformed or invalid data.
 * <p>
 * This typically occurs during parsing or processing of book/user data
 * that does not conform to the expected format or contains logically incorrect values.
 */
public class BadDataException extends Exception {

    /**
     * Constructs a new BadDataException with the specified detail message.
     *
     * @param message the detail message explaining the nature of the bad data.
     */
    public BadDataException(String message) {
        super(message);
    }
}
