public class Main {
    public static void main(String[] args) {
        Logger basicLogger = new Logger(false, false, false);
        Logger traceLogger = new Logger(false, false, true);
        Logger motivationalCauseLogger = new Logger(true, true, false);
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
