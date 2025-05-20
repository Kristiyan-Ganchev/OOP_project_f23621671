package bg.tu_varna.sit.a1.f23621671.Files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Utility class for reading content from files.
 */
public class ReadFromFile {

    /**
     * Reads the entire content of a file as a string.
     * <p>
     * If the specified file does not exist, a message is printed.
     * If an I/O error occurs during reading, the error is logged and the program exits.
     * </p>
     *
     * @param filename the name (or path) of the file to read from
     * @return the content of the file as a String; returns an empty string if file does not exist
     */
    public static String readFile(String filename) {
        String fileContent = "";
        File file = new File(filename);

        try {
            if (!file.exists()) {
                System.out.println("File does not exist!");
            } else {
                fileContent = Files.readString(file.toPath());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
            ErrorLogger.log(e);
            System.exit(1);
        }

        return fileContent;
    }
}
