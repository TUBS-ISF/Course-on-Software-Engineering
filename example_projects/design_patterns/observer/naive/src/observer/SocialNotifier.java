package observer;

import java.util.List;

import observable.Run;
public class SocialNotifier {

    int lastSharedIndex;

    public SocialNotifier() {
        this.lastSharedIndex = -1;
    }

    
    public void sendRunUpdateToFollowers(List<Run> runs) {
        while (lastSharedIndex < runs.size() - 1) {
            lastSharedIndex++;
            System.out.println("Very refreshing run in " + runs.get(lastSharedIndex).location + ". Love to my followers!");
        }
    }
    
}
