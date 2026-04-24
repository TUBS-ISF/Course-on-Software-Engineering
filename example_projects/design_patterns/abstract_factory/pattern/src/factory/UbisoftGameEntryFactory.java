package factory;

import java.util.HashMap;
import java.util.Map;

import games.IGame;
import games.UbisoftGame;

public class UbisoftGameEntryFactory extends AbstractGameEntryFactory {
    
    private final static Map<String, Integer> ID_MAP = new HashMap<String, Integer>() {
        {
            put("7 Days to Die", 7);
            put("Among Us", 4);
            put("It Takes Two", 2);
        }
    };


    @Override
    public IGame createGame(String title) {
        return new UbisoftGame(title, ID_MAP.get(title), "Ubisoft/" + title);
    }

}
