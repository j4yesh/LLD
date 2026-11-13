
interface DBStorage<K, V> {
    V get(K key);

    void put(K key, V value);

}