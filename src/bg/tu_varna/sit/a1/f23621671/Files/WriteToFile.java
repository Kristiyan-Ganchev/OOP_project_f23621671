package bg.tu_varna.sit.a1.f23621671.Files;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static void Write(String filename,String msg,boolean append) {
        try (FileWriter writer = new FileWriter(filename, append)) {
            writer.write(msg);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: "+e);
            ErrorLogger.log(e);
            System.exit(1);
        }
    }
}
