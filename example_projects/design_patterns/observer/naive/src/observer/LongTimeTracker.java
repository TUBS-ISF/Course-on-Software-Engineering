package observer;

import java.util.List;

import observable.Run;
import observable.RunlistState;

public class LongTimeTracker {

    int timeSpentRunning;

    public LongTimeTracker() {
        this.timeSpentRunning = 0;
    }

    public void printLongTimeUpdate(List<Run> runs) {
        this.timeSpentRunning = 0;
        for (Run run : runs) {
            this.timeSpentRunning += run.duration;
        }
        System.out.println("You have spent " + timeSpentRunning + " minutes running recently.");
    }
    
}
