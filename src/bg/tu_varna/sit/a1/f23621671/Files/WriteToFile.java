package bg.tu_varna.sit.a1.f23621671.Files;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static void Write(String filename,String msg) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(msg);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.printf("Error\n");
            ErrorLogger.log(e);
        }
    }
}
