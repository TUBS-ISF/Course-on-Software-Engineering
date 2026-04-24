package games;

public class DefaultGame implements IGame {
    String title;

    public DefaultGame(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
