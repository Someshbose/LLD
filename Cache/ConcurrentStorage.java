import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentStorage<Key, Value> implements Storage<Key, Value> {
    private final ConcurrentHashMap<Key, Value> storage = new ConcurrentHashMap<>();
    private final int capacity;

    public ConcurrentStorage(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void add(Key key, Value value) throws StorageFullException {
        if (storage.size() >= capacity && !storage.containsKey(key)) {
            throw new StorageFullException("Storage is full");
        }
        storage.put(key, value);
    }
    // ... get and remove implementations ...
}