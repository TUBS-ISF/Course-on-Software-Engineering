import factory.AbstractGameEntryFactory;
import factory.DefaultGameEntryFactory;
import factory.SteamGameEntryFactory;
import factory.UbisoftGameEntryFactory;
import games.IGame;

public class Main {

    public enum GAME_LIBRARY {
        STEAM,
        UBISOFT
    }

    public final static GAME_LIBRARY CURRENT_GAME_LIBRARY = GAME_LIBRARY.STEAM;

    public AbstractGameEntryFactory factory;

    public Main(AbstractGameEntryFactory factory) {
        this.factory = factory;
    }
    public static void main(String[] args) {
        Main instance;
        if (CURRENT_GAME_LIBRARY == GAME_LIBRARY.STEAM) {
            instance = new Main(new SteamGameEntryFactory());
        } else if (CURRENT_GAME_LIBRARY == GAME_LIBRARY.UBISOFT) {
            instance = new Main(new UbisoftGameEntryFactory());
        } else {
            instance = new Main(new DefaultGameEntryFactory());
        }

        IGame gameOne = instance.factory.createGame("Among Us");

        // ...
        IGame gameTwo = instance.factory.createGame("It Takes Two");
        IGame gameThree = instance.factory.createGame("7 Days to Die");
    }
}
