package observable;

import java.util.ArrayList;
import java.util.List;

import observer.IRunObserver;

public class RunTracker {
    List<IRunObserver> observers;

    RunlistState state;

    public RunTracker() {
        this.observers = new ArrayList<>();
        this.state = new RunlistState();
    }

    public void addObserver(IRunObserver observerToAdd) {
        this.observers.add(observerToAdd);
    }

    public void removeObserver(IRunObserver observerToRemove) {
        this.observers.remove(observerToRemove);
    }

    public void notifyObservers() {
        for (IRunObserver observer : observers) {
            observer.update(state);
        }
    }

    public void addRun(Run run) {
        state.runList.add(run);
        notifyObservers();
    }

}
