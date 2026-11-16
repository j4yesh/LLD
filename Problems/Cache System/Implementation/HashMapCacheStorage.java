package Implementation;

import Interface.CacheStorage;

import java.util.HashMap;
import java.util.Map;

public class HashMapCacheStorage<K, V> implements CacheStorage<K, V> {
    private final Map<K, V> cache = new HashMap<>();

    @Override
    public V get(K key) {
        return cache.get(key);
    }

    @Override
    public void put(K key, V value) {
        cache.put(key, value);
    }

    @Override
    public void remove(K key) {
        cache.remove(key);
    }
}
