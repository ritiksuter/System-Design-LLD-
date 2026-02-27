class Logger {
    private static Logger logger = null;

    private Logger() {}

    public static Logger getLogger() {
        if (logger == null) logger = new Logger();
        return logger;
    }

    public void log(String message) {
        System.out.println("Log : " + message);
    }
}

class Application {
    public void run() {
        Logger logger = Logger.getLogger();
        logger.log("Application Started");
    }
}

public class SingeletonPattern {
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }
}