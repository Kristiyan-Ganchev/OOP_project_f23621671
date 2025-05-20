package bg.tu_varna.sit.a1.f23621671.Files;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Utility class for writing content to files.
 */
public class WriteToFile {

    /**
     * Writes a message to the specified file.
     * <p>
     * If {@code append} is true, the message will be added to the end of the file;
     * otherwise, the file will be overwritten.
     * </p>
     * <p>
     * In case of an I/O error, the error is logged and the program exits.
     * </p>
     *
     * @param filename the name (or path) of the file to write to
     * @param msg      the message to write into the file
     * @param append   if true, data is written at the end of the file; if false, the file is overwritten
     */
    public static void Write(String filename, String msg, boolean append) {
        try (FileWriter writer = new FileWriter(filename, append)) {
            writer.write(msg);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
            ErrorLogger.log(e);
            System.exit(1);
        }
    }
}