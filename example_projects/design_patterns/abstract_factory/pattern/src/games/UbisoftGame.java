package games;

public class UbisoftGame implements IGame {

    String title;
    int id;
    String gameResourcesLocation;

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
