package bg.tu_varna.sit.a1.f23621671.Exceptions;


/**
 * Exception thrown when an operation is attempted on a file in an invalid state.
 * <p>
 * This may occur if an attempt is made to open a file when one is already open,
 * or if file-related operations are performed without a proper file context.
 */
public class FileStateException extends Exception {

    /**
     * Constructs a new FileStateException with the specified detail message.
     *
     * @param message the detail message explaining the file state issue.
     */
    public FileStateException(String message) {
        super(message);
    }
}
