import loggercomponent.AbstractLogger;
import loggercomponent.BaseLogger;
import loggercomponent.CauseLogger;
import loggercomponent.MotivationalLogger;
import loggercomponent.TraceLogger;

public class Main {
    public static void main(String[] args) {
        AbstractLogger basicLogger = new BaseLogger();
        AbstractLogger traceLogger = new TraceLogger(new BaseLogger());
        AbstractLogger motivationalCauseLogger = new MotivationalLogger(new CauseLogger(new BaseLogger()));
        int[] thisIsTooShort = new int[2];
        try {
            int whereIsThis = thisIsTooShort[2];
            System.out.println(whereIsThis);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(basicLogger.createMessage(e));
            System.out.println(traceLogger.createMessage(e));
            System.out.println(motivationalCauseLogger.createMessage(e));
        }

    }
}
