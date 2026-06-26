
/**
 * LRU_Algorithm
 */
import java.util.*;

public class LRU_Algorithm {

    static class Node {
        public int key, val;
        public Node next, prev;

        // Constructors
        Node() {
            key = val = -1;
            next = prev = null;
        }

        Node(int k, int value) {
            key = k;
            val = value;
            next = prev = null;
        }
    }

    private Map<Integer, Node> mpp;
    private int cap;
    private Node head;
    private Node tail;

    public LRU_Algorithm(int capacity) {
        cap = capacity;
        mpp = new HashMap<>();

        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    private void deleteNode(Node node) {

        // Get the previous and next pointers
        Node prevNode = node.prev;
        Node nextNode = node.next;

        // Remove pointers to node
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void insertAfterHead(Node node) {
        Node nextNode = head.next;
        head.next = node;

        nextNode.prev = node;
        node.prev = head;
        node.next = nextNode;
    }

    public int get(int key_) {
        if (!mpp.containsKey(key_))
            return -1;

        Node node = mpp.get(key_);
        int val = node.val;

        deleteNode(node);
        insertAfterHead(node);

        return val;
    }

    public void put(int key_, int value) {

        // Update the value if key is already present
        if (mpp.containsKey(key_)) {

            Node node = mpp.get(key_);
            node.val = value;

            deleteNode(node);
            insertAfterHead(node);

            return;
        }

        // Check if the capacity limit has reached
        if (mpp.size() == cap) {
            Node node = tail.prev;
            mpp.remove(node.key);
            deleteNode(node);
        }

        Node newNode = new Node(key_, value);
        mpp.put(key_, newNode);

        insertAfterHead(newNode);
    }

    public static void main(String[] args) {
        // LRU Cache
        LRU_Algorithm cache = new LRU_Algorithm(2);

        // Queries
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.print(cache.get(1) + " ");
        cache.put(3, 3);
        System.out.print(cache.get(2) + " ");
        cache.put(4, 4);
        System.out.print(cache.get(1) + " ");
        System.out.print(cache.get(3) + " ");
        System.out.print(cache.get(4) + " ");
    }

}