import observable.Run;
import observable.RunTracker;
import observer.LongTimeTracker;
import observer.SocialNotifier;

public class Main {
    public static void main(String[] args) {
        
        LongTimeTracker longTimeTracker = new LongTimeTracker();
        
        
        SocialNotifier socialNotifier = new SocialNotifier();
        
        RunTracker tracker = new RunTracker(longTimeTracker, socialNotifier);
        
        tracker.processNewRun(new Run(27, "Gausspark"));
        tracker.processNewRun(new Run(44, "Suedsee"));
    }
}