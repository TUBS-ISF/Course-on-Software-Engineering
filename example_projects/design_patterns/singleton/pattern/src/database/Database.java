package database;

import java.util.ArrayList;
import java.util.List;

public class Database {
    List<String> entries;

    private static Database instance;

    private Database() {
        this.entries = new ArrayList<>();
    }

    public static Database getDatabase() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void storeEntry(String entry) {
        entries.add(entry);
    }

    public boolean deleteEntry(String entry) {
        return entries.remove(entry);
    }
    
}
