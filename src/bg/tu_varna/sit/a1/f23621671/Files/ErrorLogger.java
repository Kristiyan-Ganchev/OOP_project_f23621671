package bg.tu_varna.sit.a1.f23621671.Files;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Utility class for logging error information to a local file.
 */
public class ErrorLogger {

    /**
     * Logs the specified exception's details to a local file named "LocalErrors.txt".
     * <p>
     * Each exception is appended as a new line in the file.
     * If the file cannot be opened or written to, an error message is printed to the console.
     * </p>
     *
     * @param e the exception to be logged
     */
    public static void log(Exception e) {
        try (FileWriter errors = new FileWriter("LocalErrors.txt", true)) {
            errors.write(e.toString() + '\n');
            errors.flush();
        } catch (IOException ex) {
            System.out.println("LocalErrors.txt could not be opened.");
        }
    }
}
