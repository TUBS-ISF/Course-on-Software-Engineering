package games;

import java.util.HashMap;
import java.util.Map;

public class SteamGame implements IGame {

    String title;
    String id;
    boolean isFavorite;
    String producer;
    int playDuration;

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

    public SteamGame(String title) {
        this(title, ID_MAP.get(title), PRODUCER_MAP.get(title), 0, false);
    }

    public SteamGame(String title, String id, String producer, int playDuration, boolean isFavorite) {
        this.title = title;
        this.id = id;
        this.producer = producer;
        this.playDuration = playDuration;
        this.isFavorite = isFavorite;
    }

    @Override
    public String getTitle() {
        return title;
    }
    
}
