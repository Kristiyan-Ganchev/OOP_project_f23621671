package bg.tu_varna.sit.a1.f23621671.Exceptions;


/**
 * Exception thrown when a user attempts to perform an action
 * they do not have the required access level for.
 * <p>
 * This typically occurs when a non-privileged user tries to execute
 * an administrator or user-level command.
 */
public class AccessDeniedException extends Exception {

    /**
     * Constructs a new AccessDeniedException with the specified detail message.
     *
     * @param message the detail message explaining the access violation.
     */
    public AccessDeniedException(String message) {
        super(message);
    }
}
