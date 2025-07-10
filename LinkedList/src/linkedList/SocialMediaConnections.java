// Singly Linked List
package linkedList;

import java.util.*;

class User {
    int id;
    String name;
    int age;
    List<Integer> friends;
    User next;

    User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
    }
}

public class SocialMediaConnections {
    User head;

    public void addUser(int id, String name, int age) {
        User newUser = new User(id, name, age);
        if (head == null) head = newUser;
        else {
            User temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newUser;
        }
    }

    public User getUser(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.id == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addFriendConnection(int uid1, int uid2) {
        User u1 = getUser(uid1), u2 = getUser(uid2);
        if (u1 != null && u2 != null && !u1.friends.contains(uid2)) {
            u1.friends.add(uid2);
            u2.friends.add(uid1);
        }
    }

    public void removeFriendConnection(int uid1, int uid2) {
        User u1 = getUser(uid1), u2 = getUser(uid2);
        if (u1 != null && u2 != null) {
            u1.friends.remove(Integer.valueOf(uid2));
            u2.friends.remove(Integer.valueOf(uid1));
        }
    }

    public void findMutualFriends(int uid1, int uid2) {
        User u1 = getUser(uid1), u2 = getUser(uid2);
        if (u1 != null && u2 != null) {
            Set<Integer> set = new HashSet<>(u1.friends);
            set.retainAll(u2.friends);
            System.out.println("Mutual Friends: " + set);
        }
    }

    public void displayFriends(int uid) {
        User user = getUser(uid);
        if (user != null) {
            System.out.println("Friends of " + user.name + ": " + user.friends);
        }
    }

    public void countFriendsForAll() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friends.size() + " friends.");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SocialMediaConnections smc = new SocialMediaConnections();
        smc.addUser(1, "Alice", 25);
        smc.addUser(2, "Bob", 30);
        smc.addUser(3, "Charlie", 28);
        smc.addFriendConnection(1, 2);
        smc.addFriendConnection(1, 3);
        smc.addFriendConnection(2, 3);
        smc.displayFriends(1);
        smc.findMutualFriends(1, 2);
        smc.countFriendsForAll();
    }
}
