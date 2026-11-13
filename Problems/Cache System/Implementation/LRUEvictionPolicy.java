package Implementation;

import Interface.EvictionPolicy;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K> {
    public K getEvictKey() {
        return null;
    }

    public void keyAccessed(K key) {

    }
}
