package observer;

import observable.RunlistState;

public class SocialNotifier implements IRunObserver {

    int lastSharedIndex;

    public SocialNotifier() {
        this.lastSharedIndex = -1;
    }

    @Override
    public void update(RunlistState state) {
        while (lastSharedIndex < state.runList.size() - 1) {
            lastSharedIndex++;
            System.out.println("Very refreshing run in " + state.runList.get(lastSharedIndex).location + ". Love to my followers!");
        }
    }
    
}
