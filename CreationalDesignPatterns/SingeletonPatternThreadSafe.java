class Logger {
    private static volatile Logger instance = null;

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null)
                    instance = new Logger();
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

public class SingeletonPatternThreadSafe {
    public static void main(String[] args) {

    }
}