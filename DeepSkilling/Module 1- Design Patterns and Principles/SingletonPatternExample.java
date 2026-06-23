public class SingletonPatternExample {

    // Singleton Class
    static class Logger {

        // Single instance
        private static Logger instance;

        // Private constructor
        private Logger() {
            System.out.println("Logger Instance Created");
        }

        // Public method to get instance
        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        public void log(String message) {
            System.out.println("LOG: " + message);
        }
    }

    // Test Class
    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        logger1.log("Application Started");

        Logger logger2 = Logger.getInstance();
        logger2.log("User Logged In");

        System.out.println("\nChecking instances...");
        System.out.println("logger1 hashcode: " + logger1.hashCode());
        System.out.println("logger2 hashcode: " + logger2.hashCode());

        if (logger1 == logger2) {
            System.out.println("Only one Logger instance exists (Singleton Pattern).");
        } else {
            System.out.println("Multiple instances created.");
        }
    }
}