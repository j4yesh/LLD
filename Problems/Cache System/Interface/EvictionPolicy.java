package Interface;

public interface EvictionPolicy<K, V> {

    K getEvictKey();

    void keyAccessed(K key, V val);

}