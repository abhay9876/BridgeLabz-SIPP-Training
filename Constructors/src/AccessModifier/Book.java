package AccessModifier;

public class Book {
    public String ISBN;
    protected String title;
    private String author;

    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void displayBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class EBook extends Book {
    double fileSizeMB;

    public EBook(String ISBN, String title, String author, double fileSizeMB) {
        super(ISBN, title, author);
        this.fileSizeMB = fileSizeMB;
    }

    public void displayEBookDetails() {
        System.out.println("E-Book ISBN: " + ISBN);      
        System.out.println("E-Book Title: " + title);     
        System.out.println("E-Book Author: " + getAuthor()); 
        System.out.println("File Size: " + fileSizeMB + " MB");
    }
}

class Books {
    public static void main(String[] args) {
        Book book1 = new Book("978-0135166307", "Effective Java", "Joshua Bloch");
        book1.displayBookDetails();

        System.out.println();

        EBook ebook1 = new EBook("978-1492078005", "Java: The Complete Reference", "Herbert Schildt", 5.2);
        ebook1.displayEBookDetails();

        System.out.println("\nUpdating author of EBook...");
        ebook1.setAuthor("H. Schildt");
        ebook1.displayEBookDetails();
    }
}
