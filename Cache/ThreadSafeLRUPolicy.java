import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeLRUPolicy<Key> implements EvictionPolicy<Key> {
    private final DoublyLinkedList<Key> dll;
    private final Map<Key, DoublyLinkedListNode<Key>> mapper;
    private final ReentrantLock lock = new ReentrantLock();

    public ThreadSafeLRUPolicy() {
        this.dll = new DoublyLinkedList<>();
        this.mapper = new HashMap<>();
    }

    @Override
    public void keyAccessed(Key key) {
        lock.lock(); // Block other threads from modifying the DLL
        try {
            if (mapper.containsKey(key)) {
                dll.detachNode(mapper.get(key));
                dll.addNodeAtLast(mapper.get(key));
            } else {
                DoublyLinkedListNode<Key> newNode = dll.addElementAtLast(key);
                mapper.put(key, newNode);
            }
        } finally {
            lock.unlock(); // Ensure the lock is released even if an exception occurs
        }
    }

    @Override
    public Key evictKey() {
        lock.lock();
        try {
            DoublyLinkedListNode<Key> first = dll.getFirstNode();
            if (first == null) return null;
            
            dll.detachNode(first);
            mapper.remove(first.getElement());
            return first.getElement();
        } finally {
            lock.unlock();
        }
    }
}