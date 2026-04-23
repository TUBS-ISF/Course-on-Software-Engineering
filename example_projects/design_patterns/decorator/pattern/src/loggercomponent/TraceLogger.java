package loggercomponent;

public class TraceLogger extends LoggerDecorator {

    public AbstractLogger wrappedLogger;

    public TraceLogger(AbstractLogger wrappedLogger) {
        super(wrappedLogger);
        this.wrappedLogger = wrappedLogger;
    }

    @Override
    public String createMessage(Exception e) {
        return wrappedLogger.createMessage(e) + " " + e.getStackTrace().toString();
    }
    
}
