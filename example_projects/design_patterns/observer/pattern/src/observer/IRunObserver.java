package observer;

import observable.RunlistState;

public interface IRunObserver {
    public void update(RunlistState state);
}
