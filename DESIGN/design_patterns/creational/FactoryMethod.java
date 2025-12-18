enum Log{
    INFO,DEBUG;
}
interface Logger{
    void log();
}

class InfoLogger implements Logger{

    @Override
    public void log() {
        System.out.println("INFO_LOGGER");
    }
    
}
class DebugLogger implements Logger{

    @Override
    public void log() {
        System.out.println("DEBUG_LOGGER");
    }
    
}
interface LoggerFactory{
    Logger createLogger();
}
class InfoLoggerFactory implements LoggerFactory {

    @Override
    public Logger createLogger() {
       return new InfoLogger();
    }
    
}
class DebugLoggerFactory implements LoggerFactory {

    @Override
    public Logger createLogger() {
       return new DebugLogger();
    }
    
}
public class FactoryMethod {
    public static void main(String[] args) {
        LoggerFactory infoLoggerFactory = new InfoLoggerFactory();
        Logger infoLogger = infoLoggerFactory.createLogger();
        infoLogger.log();

        LoggerFactory debugLoggerFactory = new DebugLoggerFactory();
        Logger debugLogger = debugLoggerFactory.createLogger();
        debugLogger.log();
    }
}
