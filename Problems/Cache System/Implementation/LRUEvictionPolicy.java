package Implementation;

import java.util.HashMap;

import Interface.EvictionPolicy;

class DoublyLinkedList<K> {
    public DoublyLinkedList<K> left;
    public DoublyLinkedList<K> right;
    public K val;
}

public class LRUEvictionPolicy<K> implements EvictionPolicy<K> {

    private final HashMap<K, DoublyLinkedList<K>> hashMap;
    private final DoublyLinkedList<K> front;
    private final DoublyLinkedList<K> back;

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
        DoublyLinkedList<K> target = front.right;
        target.right.left = front;
        front.right = target.right;
        hashMap.remove(target.val);
        return target.val;
    }

    public void keyAccessed(K key) {
        DoublyLinkedList<K> target = hashMap.getOrDefault(key, null);
        if (target != null) {
            target.left.right = target.right;
            target.right.left = target.left;
        } else {
            target = new DoublyLinkedList<>();
            target.val = key;
            hashMap.put(key, target);
        }
        DoublyLinkedList<K> backLeft = back.left;
        back.left = target;
        target.right = back;
        backLeft.right = target;
        target.left = backLeft;
    }
}
