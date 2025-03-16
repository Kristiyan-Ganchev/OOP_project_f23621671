package bg.tu_varna.sit.a1.f23621671.Files;

import java.io.FileWriter;
import java.io.IOException;

public class ErrorLogger {
    public static void log(IOException e){
        try (FileWriter errors = new FileWriter("LocalErrors.txt", true)) {
            errors.write(e.toString() + '\n');
            errors.flush();
        } catch (IOException ex) {
            System.out.println("LocalErrors.txt could not be opened.");
        }
    }
}
