package hashmap_problems;
import java.util.*;

class Node {
    int key, value;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class CustomHashMap {
    private int SIZE = 1000;
    private Node[] table;

    public CustomHashMap() {
        table = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int i = hash(key);
        if (table[i] == null) {
            table[i] = new Node(key, value);
        } else {
            Node curr = table[i];
            while (true) {
                if (curr.key == key) {
                    curr.value = value;
                    return;
                }
                if (curr.next == null) break;
                curr = curr.next;
            }
            curr.next = new Node(key, value);
        }
    }

    public Integer get(int key) {
        int i = hash(key);
        Node curr = table[i];
        while (curr != null) {
            if (curr.key == key) return curr.value;
            curr = curr.next;
        }
        return null;
    }

    public void remove(int key) {
        int i = hash(key);
        Node curr = table[i], prev = null;
        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) table[i] = curr.next;
                else prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put(1, 10);
        map.put(2, 20);
        System.out.println(map.get(1));
        map.remove(1);
        System.out.println(map.get(1));
    }
}