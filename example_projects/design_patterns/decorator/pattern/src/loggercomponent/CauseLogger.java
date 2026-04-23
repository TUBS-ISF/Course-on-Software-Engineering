package loggercomponent;

public class CauseLogger extends LoggerDecorator {

    public AbstractLogger wrappedLogger;

    public CauseLogger(AbstractLogger wrappedLogger) {
        super(wrappedLogger);
        this.wrappedLogger = wrappedLogger;
    }
    @Override
    public String createMessage(Exception e) {
        return wrappedLogger.createMessage(e) + " " + (e.getCause() == null ?  "Exception is root cause" : e.getCause().toString());
    }
    
}
