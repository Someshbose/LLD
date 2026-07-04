public class Cache<Key, Value> {
    private final Storage<Key, Value> storage;
    private final EvictionPolicy<Key> evictionPolicy;
    private final int capacity;

    public Cache(int capacity, Storage<Key, Value> storage, EvictionPolicy<Key> evictionPolicy) {
        this.capacity = capacity;
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    public void put(Key key, Value value) {
        try {
            storage.add(key, value);
            evictionPolicy.keyAccessed(key);
        } catch (StorageFullException exception) {
            Key keyToRemove = evictionPolicy.evictKey();
            if (keyToRemove == null) {
                throw new RuntimeException("Unexpected State: Storage full but no key to evict.");
            }
            storage.remove(keyToRemove);
            
            // Retry insertion after eviction
            put(key, value);
        }
    }

    public Value get(Key key) {
        try {
            Value value = storage.get(key);
            evictionPolicy.keyAccessed(key);
            return value;
        } catch (NotFoundException exception) {
            return null; // Or throw an exception based on requirement
        }
    }
}