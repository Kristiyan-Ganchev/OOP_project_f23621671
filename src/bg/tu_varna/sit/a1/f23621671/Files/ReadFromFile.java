package bg.tu_varna.sit.a1.f23621671.Files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ReadFromFile {
    public static String readFile(String filename){
        String fileContent="";
        File file = new File(filename);

        try {
            if (!file.exists()) {
                System.out.println("File does not exist!");
            }
            else {
                fileContent= Files.readString(file.toPath());
            }
        } catch (IOException e) {
            System.out.println("Error: "+e);
            ErrorLogger.log(e);
            System.exit(1);
        }

        return fileContent;
    }
}
