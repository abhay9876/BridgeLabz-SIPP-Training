// Book.java
// Sample Program 2: Library Management System
// Demonstrates static, this, final, and instanceof best practices
package Level1;

public class Book {
    private static String libraryName = "City Library";
    private final String isbn;
    private String title;
    private String author;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }

    public static void main(String[] args) {
        Book book1 = new Book("Java Basics", "John Doe", "12345");
        Object obj = book1;
        if (obj instanceof Book) {
            ((Book) obj).displayDetails();
        }
        Book.displayLibraryName();
    }
}
