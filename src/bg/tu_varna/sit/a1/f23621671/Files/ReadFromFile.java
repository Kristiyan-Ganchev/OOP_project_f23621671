package bg.tu_varna.sit.a1.f23621671.Files;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class ReadFromFile {
    public static String readFile(String filename){
        String fileContent="";
        File file = new File(filename);

        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getAbsolutePath());
            }
            else {
                fileContent= Files.readString(file.toPath());
            }
        } catch (IOException e) {
            System.out.printf("Error\n");
            ErrorLogger.log(e);
        }

        return fileContent;
    }
}
