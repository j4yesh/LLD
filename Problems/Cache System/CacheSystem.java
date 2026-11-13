import java.util.*;
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

        Cache cache = new Cache();

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
