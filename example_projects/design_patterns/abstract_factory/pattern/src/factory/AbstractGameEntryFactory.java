package factory;

import games.IGame;
import games.DefaultGame;

public abstract class AbstractGameEntryFactory {
    public IGame createGame(String title) {
        return new DefaultGame(title);
    }
}
