package bg.tu_varna.sit.a1.f23621671.Files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CreateFile {
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
