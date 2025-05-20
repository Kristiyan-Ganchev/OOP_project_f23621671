package bg.tu_varna.sit.a1.f23621671.Exceptions;


/**
 * Exception thrown when required data is missing or not available.
 * <p>
 * This exception signals that an operation could not be completed due to the absence of necessary data.
 * </p>
 */
public class NoDataException extends Exception {

    /**
     * Constructs a new NoDataException with the specified detail message.
     *
     * @param message the detail message explaining the cause of the exception
     */
    public NoDataException(String message) {
        super(message);
    }
}
