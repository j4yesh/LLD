import java.util.*;

import Implementation.*;
import Interface.*;

class Cache<K, V> {

    EvictionPolicy evictionPolicy;
    WritePolicy writePolicy;
    CacheStorage<K, V> cacheStorage;
    DBStorage<K, V> dbStorage;

    Cache(CacheStorage<K, V> cacheStorage,
            DBStorage<K, V> dbStorage,
            EvictionPolicy evictionPolicy,
            WritePolicy writePolicy) {
        this.evictionPolicy = evictionPolicy;
        this.writePolicy = writePolicy;
        this.cacheStorage = cacheStorage;
        this.dbStorage = dbStorage;
    }

    V get(K key) {
        return null;
    }

    void put(K key, V value) {

    }

}

class CacheSystem {

    public static void main(String[] jayesh) {
        System.out.println("Initiating the Cache system");

        EvictionPolicy<String, Integer> evictionPolicy = new LRUEvictionPolicy<String, Integer>();
        CacheStorage<String, Integer> cacheStorage = new HashMapCacheStorage<String, Integer>();
        DBStorage<String, Integer> dbStorage = new HashMapDBStorage<String, Integer>();
        WriteThrough<String, Integer> writeThorughPolicy = new WriteThrough<String, Integer>(
                dbStorage,
                cacheStorage);

        Cache cache = new Cache<>(cacheStorage, dbStorage, evictionPolicy, null);

        // get / put
        // req comes to server
        // if hit welldone
        // miss then bring from db
        // add in cache
        // return

        // writing policy
        // ->write through -> picked
        // ->write back
        // ->write around

        // eviction policy
        // ->random
        // ->LFU
        // ->LRU -> picked

        // Concurrent Access
        // ->Locks
        // ->Thread Affinity
        // allocate the single thread wrt each key
    }

}
