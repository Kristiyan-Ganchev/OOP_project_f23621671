package bg.tu_varna.sit.a1.f23621671.Files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Utility class for file creation operations.
 */
public class CreateFile {

    /**
     * Creates a new file with the specified filename.
     * <p>
     * If the file does not exist, it attempts to create it and prints the file path on success.
     * If the file already exists or creation fails, a corresponding message is printed.
     * In case of an IOException, the error is logged using {@code ErrorLogger}.
     * </p>
     *
     * @param filename the name (or path) of the file to create
     */
    public static void createFile(String filename) {
        File file = new File(filename);
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getAbsolutePath());
            } else {
                System.out.println("Failed to create the file.");
            }
        } catch (IOException e) {
            System.err.println("An error occurred while creating the file: " + e.getMessage());
            ErrorLogger.log(e);
        }
    }
}
