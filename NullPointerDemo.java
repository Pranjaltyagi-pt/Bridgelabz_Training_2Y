package strings.level1;

// Program 4: Demonstrate NullPointerException
public class NullPointerDemo {
    // Generates the exception (program stops here if not handled)
    public static void generateException() {
        String text = null;
        System.out.println(text.length()); // NullPointerException
    }

    // Handles the exception using try-catch
    public static void handleException() {
        String text = null;
        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Handled NullPointerException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Handled RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // First call the handling method so the program continues
        System.out.println("--- Handling the exception ---");
        handleException();

        // Then generate the exception (program stops abruptly with a stack trace)
        System.out.println("--- Generating the exception ---");
        generateException();
        System.out.println("This line is never reached.");
    }
}
