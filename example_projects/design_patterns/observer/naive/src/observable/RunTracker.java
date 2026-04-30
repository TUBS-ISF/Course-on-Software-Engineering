package observable;

import observer.LongTimeTracker;
import observer.SocialNotifier;

public class RunTracker {

    RunlistState state;

    LongTimeTracker longTimeTracker;

    SocialNotifier socialNotifier;

    public RunTracker(LongTimeTracker longTimeTracker, SocialNotifier socialNotifier) {
        this.state = new RunlistState();
        this.longTimeTracker = longTimeTracker;
        this.socialNotifier = socialNotifier;
    }


    public void processNewRun(Run run) {
        state.runList.add(run);
        longTimeTracker.printLongTimeUpdate(state.runList);
        socialNotifier.sendRunUpdateToFollowers(state.runList);
    }

}
