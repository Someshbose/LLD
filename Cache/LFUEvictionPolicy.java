import java.util.HashMap;
import java.util.Map;

public class LFUEvictionPolicy<Key> implements EvictionPolicy<Key> {
    
    private final Map<Integer, DoublyLinkedList<Key>> frequencyMap;
    private final Map<Key, Integer> keyFrequencyMap;
    private final Map<Key, DoublyLinkedListNode<Key>> keyNodeMap;
    private int minFrequency;

    public LFUEvictionPolicy() {
        this.frequencyMap = new HashMap<>();
        this.keyFrequencyMap = new HashMap<>();
        this.keyNodeMap = new HashMap<>();
        this.minFrequency = 0;
    }

    @Override
    public void keyAccessed(Key key) {
        if (keyFrequencyMap.containsKey(key)) {
            promoteKey(key);
        } else {
            addNewKey(key);
        }
    }

    @Override
    public Key evictKey() {
        // Find the list of keys with the lowest frequency
        DoublyLinkedList<Key> minFreqList = frequencyMap.get(minFrequency);
        
        if (minFreqList == null || minFreqList.isEmpty()) {
            return null; // Nothing to evict
        }
        
        // Evict the Least Recently Used node from this frequency tier (the first node)
        DoublyLinkedListNode<Key> nodeToEvict = minFreqList.getFirstNode();
        minFreqList.detachNode(nodeToEvict);
        
        Key evictedKey = nodeToEvict.getElement();
        
        // Clean up tracking maps
        keyFrequencyMap.remove(evictedKey);
        keyNodeMap.remove(evictedKey);
        
        return evictedKey;
    }

    // --- Helper Methods to keep logic clean ---

    private void addNewKey(Key key) {
        // New keys always start with a frequency of 1
        minFrequency = 1;
        keyFrequencyMap.put(key, 1);
        
        frequencyMap.putIfAbsent(1, new DoublyLinkedList<>());
        DoublyLinkedListNode<Key> newNode = frequencyMap.get(1).addElementAtLast(key);
        
        keyNodeMap.put(key, newNode);
    }

    private void promoteKey(Key key) {
        int currentFreq = keyFrequencyMap.get(key);
        DoublyLinkedList<Key> currentList = frequencyMap.get(currentFreq);
        DoublyLinkedListNode<Key> node = keyNodeMap.get(key);
        
        // Remove from current frequency tier
        currentList.detachNode(node);
        
        // CRITICAL: If the list we just removed from was the minFrequency tier 
        // and it is now empty, we must increment the minFrequency.
        if (currentFreq == minFrequency && currentList.isEmpty()) {
            minFrequency++;
        }
        
        // Move to the next frequency tier
        int newFreq = currentFreq + 1;
        keyFrequencyMap.put(key, newFreq);
        
        frequencyMap.putIfAbsent(newFreq, new DoublyLinkedList<>());
        DoublyLinkedListNode<Key> promotedNode = frequencyMap.get(newFreq).addElementAtLast(key);
        
        // Update the node map with the newly created node
        keyNodeMap.put(key, promotedNode);
    }
}