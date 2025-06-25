package Level1;
public class Books {
    String title;
    String author;
    double price;
    boolean isAvailable;

    public Books(String title, String author, double price, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Books borrowed successfully: " + title);
        } else {
            System.out.println("Sorry, the book '" + title + "' is currently not available.");
        }
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
    }

    public static void main(String[] args) {
        Books book1 = new Books("The Alchemist", "Paulo Coelho", 350.0, true);

        System.out.println("Books Details:");
        book1.displayDetails();

        System.out.println("\nAttempting to borrow the book...");
        book1.borrowBook();

        System.out.println("\nBook Details After Borrowing:");
        book1.displayDetails();
    }
}
