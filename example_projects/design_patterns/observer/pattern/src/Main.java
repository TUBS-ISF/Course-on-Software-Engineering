import observable.Run;
import observable.RunTracker;
import observer.LongTimeTracker;
import observer.SocialNotifier;

public class Main {
    public static void main(String[] args) {
        RunTracker tracker = new RunTracker();

        LongTimeTracker longTimeTracker = new LongTimeTracker();
        tracker.addObserver(longTimeTracker);


        SocialNotifier socialNotifier = new SocialNotifier();
        tracker.addObserver(socialNotifier);

        
        tracker.addRun(new Run(27, "Gausspark"));
        tracker.addRun(new Run(44, "Suedsee"));
    }
}