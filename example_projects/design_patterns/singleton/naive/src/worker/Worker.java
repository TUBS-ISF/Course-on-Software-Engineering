package worker;

import database.Database;

public class Worker {
    
    public Database dbToUse;
    
    public Worker(Database db) {
        this.dbToUse = db;
    }

    public Worker() {
        this.dbToUse = new Database();
    }

    public void writeToDatabase(String entry) {
        dbToUse.storeEntry(entry);
    }
}