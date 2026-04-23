package loggercomponent;

public class MotivationalLogger extends LoggerDecorator {

    public AbstractLogger wrappedLogger;

    public MotivationalLogger(AbstractLogger wrappedLogger) {
        super(wrappedLogger);
        this.wrappedLogger = wrappedLogger;
    }

    @Override
    public String createMessage(Exception e) {
        return "Come on. You got this! :) " + wrappedLogger.createMessage(e);
    }
    
}
