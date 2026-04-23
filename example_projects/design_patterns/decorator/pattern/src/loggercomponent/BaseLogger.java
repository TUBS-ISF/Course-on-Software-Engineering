package loggercomponent;

public class BaseLogger extends AbstractLogger {

    
    @Override
    public String createMessage(Exception e) {
        return e.getMessage();
    }
    
}
