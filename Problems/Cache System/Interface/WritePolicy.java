package Interface;

public interface WritePolicy<K, V> {
    public void put(K key, V value);

    public void remove(K key);
}
