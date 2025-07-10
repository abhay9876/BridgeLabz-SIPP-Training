// Doubly Linked List
package linkedList;

class Movie {
    String title, director;
    int year;
    float rating;
    Movie prev, next;

    Movie(String title, String director, int year, float rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}

public class MovieManagementSystem {
    Movie head, tail;

    public void addMovieAtEnd(String title, String director, int year, float rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public void removeByTitle(String title) {
        Movie curr = head;
        while (curr != null) {
            if (curr.title.equals(title)) {
                if (curr.prev != null) curr.prev.next = curr.next;
                else head = curr.next;
                if (curr.next != null) curr.next.prev = curr.prev;
                else tail = curr.prev;
                return;
            }
            curr = curr.next;
        }
    }

    public void searchByDirector(String director) {
        Movie curr = head;
        while (curr != null) {
            if (curr.director.equals(director))
                System.out.println(curr.title + " by " + director);
            curr = curr.next;
        }
    }

    public void updateRating(String title, float newRating) {
        Movie curr = head;
        while (curr != null) {
            if (curr.title.equals(title)) {
                curr.rating = newRating;
                return;
            }
            curr = curr.next;
        }
    }

    public void displayForward() {
        Movie curr = head;
        while (curr != null) {
            System.out.println(curr.title + " " + curr.director + " " + curr.year + " " + curr.rating);
            curr = curr.next;
        }
    }

    public void displayReverse() {
        Movie curr = tail;
        while (curr != null) {
            System.out.println(curr.title + " " + curr.director + " " + curr.year + " " + curr.rating);
            curr = curr.prev;
        }
    }

    public static void main(String[] args) {
        MovieManagementSystem mms = new MovieManagementSystem();
        mms.addMovieAtEnd("Inception", "Nolan", 2010, 9.0f);
        mms.addMovieAtEnd("Interstellar", "Nolan", 2014, 8.5f);
        mms.displayForward();
        mms.updateRating("Inception", 9.5f);
        mms.displayReverse();
        mms.removeByTitle("Interstellar");
        mms.displayForward();
    }
}