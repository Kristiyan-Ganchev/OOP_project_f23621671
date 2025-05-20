package bg.tu_varna.sit.a1.f23621671;


/**
 * Main entry point of the application.
 * <p>
 * This class starts the command processing system and handles any exceptions
 * thrown during the execution.
 * </p>
 */
public class Application {

    /**
     * The main method that launches the application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        try {
            CommandProcessor.run();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}