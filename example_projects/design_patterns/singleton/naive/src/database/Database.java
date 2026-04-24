package database;

import java.util.ArrayList;
import java.util.List;

public class Database {
    List<String> entries;

    public Database() {
        this.entries = new ArrayList<>();
    }

    public void storeEntry(String entry) {
        entries.add(entry);
    }

    public boolean deleteEntry(String entry) {
        return entries.remove(entry);
    }
    
}
