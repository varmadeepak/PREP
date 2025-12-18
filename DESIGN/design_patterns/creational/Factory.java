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
class LoggerFactory{
    public static Logger createLogger(Log log) {
        if(log.equals(Log.INFO)) {
            return new InfoLogger();
        }
        else if(log.equals(Log.DEBUG)) {
            return new DebugLogger();
        }
        return new InfoLogger();
    }
}
public class Factory {
    public static void main(String[] args) {
        Logger infoLogger = LoggerFactory.createLogger(Log.INFO);
        infoLogger.log();
        Logger debugLogger = LoggerFactory.createLogger(Log.DEBUG);
        debugLogger.log();
    }
}
