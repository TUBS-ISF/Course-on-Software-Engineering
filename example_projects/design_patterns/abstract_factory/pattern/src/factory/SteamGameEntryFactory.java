package factory;

import java.util.HashMap;
import java.util.Map;

import games.IGame;
import games.SteamGame;

public class SteamGameEntryFactory extends AbstractGameEntryFactory {
    
    private final static Map<String, String> ID_MAP = new HashMap<String, String>() {
        {
            put("7 Days to Die", "7dtd");
            put("Among Us", "among");
            put("It Takes Two", "it2");
        }
    };

    private final static Map<String, String> PRODUCER_MAP = new HashMap<String, String>() {
        {
            put("7 Days to Die", "Fun Pimps");
            put("Among Us", "Innersloth");
            put("It Takes Two", "Hazelight");
        }
    };


    @Override
    public IGame createGame(String title) {
        return new SteamGame(title, ID_MAP.get(title), PRODUCER_MAP.get(title), 0, false);
    }

}
