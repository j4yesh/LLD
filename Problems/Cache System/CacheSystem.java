import java.util.*;

import Implementation.*;
import Interface.*;

class Cache<K, V> {

    EvictionPolicy<K, V> evictionPolicy;
    WritePolicy<K, V> writePolicy;
    CacheStorage<K, V> cacheStorage;
    DBStorage<K, V> dbStorage;

    private final int size = 3;

    Cache(CacheStorage<K, V> cacheStorage,
            DBStorage<K, V> dbStorage,
            EvictionPolicy<K, V> evictionPolicy,
            WritePolicy<K, V> writePolicy) {
        this.evictionPolicy = evictionPolicy;
        this.writePolicy = writePolicy;
        this.cacheStorage = cacheStorage;
        this.dbStorage = dbStorage;
    }

    V get(K key) {
        V val = cacheStorage.get(key);
        if (val == null) {
            System.out.println("MISS");
            val = dbStorage.get(key);
            System.out.println("getting val from DB " + val);
            if (val == null) return null;
            if (cacheStorage.size() >= size) {
                K toRemove = evictionPolicy.getEvictKey();
                System.out.println("evicting key " + toRemove);
                cacheStorage.remove(toRemove);
            }
            System.out.println("putting the val in cache");
            cacheStorage.put(key, val);
        }
        evictionPolicy.keyAccessed(key, val);
        return val;
    }

    void put(K key, V value) {
        if (cacheStorage.get(key) == null && cacheStorage.size() >= size) {
            System.out.println("Size Reached ");
            K toRemove = evictionPolicy.getEvictKey();
            System.out.println("key to evict " + toRemove);
            cacheStorage.remove(toRemove);
        }
        System.out.println("Writing the key val in DB and Cache" + " key: " + key + "  val: " + value);
        writePolicy.put(key, value);
        System.out.println("");
        evictionPolicy.keyAccessed(key, value);
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

        Cache<String,Integer> cache = new Cache<String,Integer>(cacheStorage, dbStorage, evictionPolicy, writeThorughPolicy);

        System.out.println("=== PUT a=1, b=2, c=3 (fill cache) ===");
        cache.put("a", 1);
        cache.put("b", 2);
        cache.put("c", 3);

        System.out.println("=== GET a (should HIT) ===");
        System.out.println("Result: " + cache.get("a"));

        System.out.println("=== PUT d=4 (cache full, should evict b - LRU) ===");
        cache.put("d", 4);

        System.out.println("=== GET b (should MISS, evicted, fetch from DB) ===");
        System.out.println("Result: " + cache.get("b"));

        System.out.println("=== GET d (should HIT) ===");
        System.out.println("Result: " + cache.get("d"));

        System.out.println("=== GET z (never inserted, should MISS, null) ===");
        System.out.println("Result: " + cache.get("z"));

        System.out.println("=== PUT a=99 (overwrite, no eviction needed) ===");
        cache.put("a", 99);

        System.out.println("=== GET a (should HIT, value=99) ===");
        System.out.println("Result: " + cache.get("a"));

        /*
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Enter action (put/get/exit): ");
            String action = sc.nextLine().trim();

            if(action.equals("exit")){
                break;
            }

            System.out.print("Enter key: ");
            String key = sc.nextLine().trim();

            if(action.equals("put")){
                System.out.print("Enter value: ");
                Integer val = Integer.parseInt(sc.nextLine().trim());
                cache.put(key, val);
            }else if(action.equals("get")){
                Integer result = cache.get(key);
                System.out.println("Result: " + result);
            }else{
                System.out.println("Unknown action: " + action);
            }

            System.out.println();
        }
        sc.close();
        

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
