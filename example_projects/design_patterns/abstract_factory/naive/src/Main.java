import factory.AbstractGameEntryFactory;
import factory.DefaultGameEntryFactory;
import factory.SteamGameEntryFactory;
import factory.UbisoftGameEntryFactory;
import games.DefaultGame;
import games.IGame;
import games.SteamGame;
import games.UbisoftGame;

public class Main {

    public enum GAME_LIBRARY {
        STEAM,
        UBISOFT
    }

    public final static GAME_LIBRARY CURRENT_GAME_LIBRARY = GAME_LIBRARY.STEAM;

    public static void main(String[] args) {
        IGame gameOne;
        if (CURRENT_GAME_LIBRARY == GAME_LIBRARY.STEAM) {
            gameOne = new SteamGame("Among Us");
        } else if (CURRENT_GAME_LIBRARY == GAME_LIBRARY.UBISOFT) {
            gameOne = new UbisoftGame("Among Us");
        } else {
            gameOne = new DefaultGame("Among Us");
        }

        
        // ...
        IGame gameTwo;
        if (CURRENT_GAME_LIBRARY == GAME_LIBRARY.STEAM) {
            gameTwo = new SteamGame("It Takes Two");
        } else if (CURRENT_GAME_LIBRARY == GAME_LIBRARY.UBISOFT) {
            gameTwo = new UbisoftGame("It Takes Two");
        } else {
            gameTwo = new DefaultGame("It Takes Two");
        }
        
        // ...
        IGame gameThree;
        if (CURRENT_GAME_LIBRARY == GAME_LIBRARY.STEAM) {
            gameThree = new SteamGame("7 Days to Die");
        } else if (CURRENT_GAME_LIBRARY == GAME_LIBRARY.UBISOFT) {
            gameThree = new UbisoftGame("7 Days to Die");
        } else {
            gameThree = new DefaultGame("7 Days to Die");
        }
    }
}
