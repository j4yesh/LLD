package Interface;

public interface EvictionPolicy<K> {

    K getEvictKey();

    void keyAccessed(K key);

}