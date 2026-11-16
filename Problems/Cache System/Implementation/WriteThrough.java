package Implementation;

import Interface.CacheStorage;
import Interface.DBStorage;
import Interface.WritePolicy;

public class WriteThrough<K, V> implements WritePolicy<K, V> {
    private DBStorage<K, V> dbStorage;
    private CacheStorage<K, V> cacheStorage;

    public WriteThrough(DBStorage<K, V> dbStorage, CacheStorage<K, V> cacheStorage) {
        this.dbStorage = dbStorage;
        this.cacheStorage = cacheStorage;
    }

    @Override
    public void put(K key, V value) {
        dbStorage.put(key, value);
        cacheStorage.put(key, value);
    }

    @Override
    public void remove(K key) {
        dbStorage.remove(key);
        cacheStorage.remove(key);
    }

}
