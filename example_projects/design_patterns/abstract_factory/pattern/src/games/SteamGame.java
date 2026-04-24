package games;

public class SteamGame implements IGame {

    String title;
    String id;
    boolean isFavorite;
    String producer;
    int playDuration;

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
