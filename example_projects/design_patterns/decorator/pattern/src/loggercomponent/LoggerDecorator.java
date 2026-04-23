package loggercomponent;

public abstract class LoggerDecorator extends AbstractLogger {
    
    AbstractLogger wrappedLogger;

    public LoggerDecorator(AbstractLogger wrappedLogger) {
        this.wrappedLogger = wrappedLogger;
    }

    @Override 
    public String createMessage(Exception e) {
        return wrappedLogger.createMessage(e);
    } 
    
}
