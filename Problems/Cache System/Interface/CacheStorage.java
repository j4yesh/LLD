package Interface;

public interface CacheStorage<K, V> {
    V get(K key);

    void put(K key, V value);

    void remove(K key);

    int size();
}
