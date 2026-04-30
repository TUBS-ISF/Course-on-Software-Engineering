package observer;

import observable.Run;
import observable.RunlistState;

public class LongTimeTracker implements IRunObserver {

    int timeSpentRunning;

    public LongTimeTracker() {
        this.timeSpentRunning = 0;
    }

    @Override
    public void update(RunlistState state) {
        this.timeSpentRunning = 0;
        for (Run run : state.runList) {
            this.timeSpentRunning += run.duration;
        }
        System.out.println("You have spent " + timeSpentRunning + " minutes running recently.");
    }
    
}
