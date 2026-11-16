package Implementation;

import java.util.HashMap;

import Interface.EvictionPolicy;

class DoublyLinkedList<K, V> {
    public DoublyLinkedList<K, V> left;
    public DoublyLinkedList<K, V> right;
    public K key;
    public V val;
}

public class LRUEvictionPolicy<K, V> implements EvictionPolicy<K, V> {

    private final HashMap<K, DoublyLinkedList<K, V>> hashMap;
    private final DoublyLinkedList<K, V> front;
    private final DoublyLinkedList<K, V> back;

    public LRUEvictionPolicy() {
        this.hashMap = new HashMap<>();
        this.front = new DoublyLinkedList<>();
        this.back = new DoublyLinkedList<>();
        this.front.right = this.back;
        this.back.left = this.front;
    }

    public K getEvictKey() {
        if (front.right == back) {
            return null;
        }
        DoublyLinkedList<K, V> target = front.right;
        target.right.left = front;
        front.right = target.right;
        hashMap.remove(target.key);
        return target.key;
    }

    public void keyAccessed(K key, V val) {
        DoublyLinkedList<K, V> target = hashMap.getOrDefault(key, null);
        if (target != null) {
            target.left.right = target.right;
            target.right.left = target.left;
        } else {
            target = new DoublyLinkedList<>();
            target.key = key;
            target.val = val;
            hashMap.put(key, target);
        }
        DoublyLinkedList<K, V> backLeft = back.left;
        back.left = target;
        target.right = back;
        backLeft.right = target;
        target.left = backLeft;
    }
}
