// ===== Abstract Products =====
interface InfoLogger {
    void log(String message);
}

interface DebugLogger {
    void log(String message);
}

// ===== Concrete Products : Console =====
class ConsoleInfoLogger implements InfoLogger {
    @Override
    public void log(String message) {
        System.out.println("[CONSOLE][INFO] " + message);
    }
}

class ConsoleDebugLogger implements DebugLogger {
    @Override
    public void log(String message) {
        System.out.println("[CONSOLE][DEBUG] " + message);
    }
}

// ===== Concrete Products : File =====
class FileInfoLogger implements InfoLogger {
    @Override
    public void log(String message) {
        System.out.println("[FILE][INFO] " + message);
    }
}

class FileDebugLogger implements DebugLogger {
    @Override
    public void log(String message) {
        System.out.println("[FILE][DEBUG] " + message);
    }
}

// ===== Abstract Factory =====
interface LoggerFactory {
    InfoLogger createInfoLogger();
    DebugLogger createDebugLogger();
}

// ===== Concrete Factories =====
class ConsoleLoggerFactory implements LoggerFactory {

    @Override
    public InfoLogger createInfoLogger() {
        return new ConsoleInfoLogger(); // «create» dependency
    }

    @Override
    public DebugLogger createDebugLogger() {
        return new ConsoleDebugLogger(); // «create» dependency
    }
}

class FileLoggerFactory implements LoggerFactory {

    @Override
    public InfoLogger createInfoLogger() {
        return new FileInfoLogger(); // «create» dependency
    }

    @Override
    public DebugLogger createDebugLogger() {
        return new FileDebugLogger(); // «create» dependency
    }
}

// ===== Client =====
public class AbstractFactory{

    public static void main(String[] args) {

        // Switch factory to change entire logger family
        LoggerFactory factory = new ConsoleLoggerFactory();
        // LoggerFactory factory = new FileLoggerFactory();

        InfoLogger infoLogger = factory.createInfoLogger();
        DebugLogger debugLogger = factory.createDebugLogger();

        infoLogger.log("Application started");
        debugLogger.log("Debugging enabled");
    }
}