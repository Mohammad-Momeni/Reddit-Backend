package Database;

import java.util.HashMap;

public class Database {
    private static Database instance = null;
    private HashMap<String, Table> tables;
    Database() {
        tables = new HashMap<String, Table>();
        tables.put("&&User", new Table("src/Data/User.txt"));
    }
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
    public void addTable(String name, String path) {
        tables.put(name, new Table(path));
    }
    public Table getTable(String name) {
        return tables.get(name);
    }
}
