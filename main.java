

interface InMemoryDB {
    int get(String key);

    void put(String key, int val);

    void begin_transaction();

    void commit();

    void rollback();
}

public class Main {
    public static void main(String[] args) {

    }
}