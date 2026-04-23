public class Logger {

    private boolean beMotivational;

    private boolean printCause;

    private boolean printTrace;

    public Logger(boolean beMotivational, boolean printCause, boolean printTrace) {
        this.beMotivational = beMotivational;
        this.printCause = printCause;
        this.printTrace = printTrace;
    }

    public String createMessage(Exception e) {
        String message = e.getMessage();
        if (beMotivational) {
            message = "Come on. You got this! " + message;
        }
        if (printCause) {
            message = message + " " + e.getCause() == null ? "Root cause" : e.getCause().toString();
        }
        if (printTrace) {
            message = message + " " + e.getStackTrace().toString();
        }
        return message;
    }
}
