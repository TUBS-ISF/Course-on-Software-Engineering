package games;

import java.util.HashMap;
import java.util.Map;

public class UbisoftGame implements IGame {

    String title;
    int id;
    String gameResourcesLocation;

    private final static Map<String, Integer> ID_MAP = new HashMap<String, Integer>() {
        {
            put("7 Days to Die", 7);
            put("Among Us", 4);
            put("It Takes Two", 2);
        }
    };

    public UbisoftGame(String title) {
        this(title, ID_MAP.get(title), "Ubisoft/" + title);
    }

    public UbisoftGame(String title, int id, String gameResourcesLocation) {
        this.title = title;
        this.id = id;
        this.gameResourcesLocation = gameResourcesLocation;
    }


    @Override
    public String getTitle() {
        return title;
    }
    
}
