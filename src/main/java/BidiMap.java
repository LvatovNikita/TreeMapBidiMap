import java.util.HashMap;
import java.util.Set;

public class BidiMap<K, V> {
    private HashMap<K, V> forwardMap;
    private HashMap<V, K> reverseMap;

    public BidiMap() {
        forwardMap = new HashMap<>();
        reverseMap = new HashMap<>();
    }

    public void put(K key, V value) {
        forwardMap.put(key, value);
        reverseMap.put(value, key);
    }

    public V get(K key) {
        return forwardMap.get(key);
    }

    public K getKey(V value) {
        return reverseMap.get(value);
    }

    public void remove(K key) {
        V value = forwardMap.get(key);
        if (value != null) {
            forwardMap.remove(key);
            reverseMap.remove(value);
        }
    }

    public void removeValue(V value) {
        K key = reverseMap.get(value);
        if (key != null) {
            reverseMap.remove(value);
            forwardMap.remove(key);
        }
    }

    public boolean containsKey(K key) {
        return forwardMap.containsKey(key);
    }

    public boolean containsValue(V value) {
        return reverseMap.containsKey(value);
    }

    public Set<K> keySet() {
        return forwardMap.keySet();
    }

    public Set<V> values() {
        return reverseMap.keySet();
    }

    public int size() {
        return forwardMap.size();
    }

    public boolean isEmpty() {
        return forwardMap.isEmpty();
    }

    public void clear() {
        forwardMap.clear();
        reverseMap.clear();
    }

}