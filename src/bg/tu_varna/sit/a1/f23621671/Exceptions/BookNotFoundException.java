package bg.tu_varna.sit.a1.f23621671.Exceptions;

/**
 * Exception thrown when a requested book cannot be found in the library.
 * <p>
 * This may occur during operations like removing, finding, or displaying
 * information about a book that does not exist in the current collection.
 */
public class BookNotFoundException extends Exception {

    /**
     * Constructs a new BookNotFoundException with the specified detail message.
     *
     * @param message the detail message explaining why the book was not found.
     */
    public BookNotFoundException(String message) {
        super(message);
    }
}
