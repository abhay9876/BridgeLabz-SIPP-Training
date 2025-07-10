// Doubly Linked List
package linkedList;

class Book {
    String title, author, genre;
    int id;
    boolean available;
    Book prev, next;

    Book(String title, String author, String genre, int id, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.id = id;
        this.available = available;
    }
}

public class LibraryManagementSystem {
    Book head, tail;

    public void addBook(String title, String author, String genre, int id, boolean available) {
        Book newBook = new Book(title, author, genre, id, available);
        if (head == null) head = tail = newBook;
        else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    public void removeBook(int id) {
        Book curr = head;
        while (curr != null) {
            if (curr.id == id) {
                if (curr.prev != null) curr.prev.next = curr.next;
                else head = curr.next;
                if (curr.next != null) curr.next.prev = curr.prev;
                else tail = curr.prev;
                return;
            }
            curr = curr.next;
        }
    }

    public void updateAvailability(int id, boolean status) {
        Book curr = head;
        while (curr != null) {
            if (curr.id == id) {
                curr.available = status;
                return;
            }
            curr = curr.next;
        }
    }

    public void countBooks() {
        int count = 0;
        Book curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        System.out.println("Total Books: " + count);
    }

    public void displayBooks() {
        Book curr = head;
        while (curr != null) {
            System.out.println(curr.title + " " + curr.author + " " + curr.genre + " " + curr.id + " " + curr.available);
            curr = curr.next;
        }
    }

    public void displayReverse() {
        Book curr = tail;
        while (curr != null) {
            System.out.println(curr.title + " " + curr.author + " " + curr.genre + " " + curr.id + " " + curr.available);
            curr = curr.prev;
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem();
        lms.addBook("Book1", "AuthorA", "Fiction", 101, true);
        lms.addBook("Book2", "AuthorB", "SciFi", 102, false);
        lms.displayBooks();
        lms.updateAvailability(101, false);
        lms.countBooks();
        lms.removeBook(102);
        lms.displayReverse();
    }
}
