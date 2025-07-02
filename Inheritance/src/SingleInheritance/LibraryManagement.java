package SingleInheritance;

class Book{
	String title;
	int publicationYear;
	
	public Book(String title,int publicationYear) {
		this.title = title;
		this.publicationYear = publicationYear;
		
	}
}

class Author extends Book{
	String name;
	String bio;
	
	public Author(String title, int publicationYear , String name , String bio) {
		super(title , publicationYear);
		this.name = name;
		this.bio = bio;
	}
	
	public void displayInfo() {
		    System.out.println("Book Title: " + title);
	        System.out.println("Publication Year: " + publicationYear);
	        System.out.println("Author Name: " + name);
	        System.out.println("Author Bio: " + bio);
	}
}

public class LibraryManagement {
   public static void main(String[] args) {
	   Author a = new Author("The java",2025,"Abhay Singh","Do it.");
	   a.displayInfo();
   }
}
