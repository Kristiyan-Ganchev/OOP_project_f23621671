package bg.tu_varna.sit.a1.f23621671;

public class Application {
    public static void main(String[] args) {
        try {
            CommandProcessor.run();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}