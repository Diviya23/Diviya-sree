import java.util.Arrays;
import java.util.Comparator;

public class Library {
    Book[] books;
    int count;

    public Library(int size) {
        books = new Book[size];
        count = 0;
    }

  
    public void addBook(int id, String title, String author) {
        if (count < books.length) {
            books[count++] = new Book(id, title, author);
            System.out.println("Book added.");
        } else {
            System.out.println("Library is full.");
        }
    }

   
    public Book linearSearch(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

 
    public Book binarySearch(String title) {
        Arrays.sort(books, 0, count, Comparator.comparing(b -> b.title.toLowerCase()));

        int left = 0;
        int right = count - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);

            if (cmp == 0) {
                return books[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

   
    public void displayBooks() {
        for (int i = 0; i < count; i++) {
            books[i].printBook();
        }
    }

  
    public static void main(String[] args) {
        Library lib = new Library(10);

        lib.addBook(101, "Java Basics", "Alice");
        lib.addBook(102, "Data Structures", "Bob");
        lib.addBook(103, "Algorithms", "Charlie");
        lib.addBook(104, "Python Programming", "Diana");
        lib.addBook(105, "Machine Learning", "Ethan");

        System.out.println("\nAll Books:");
        lib.displayBooks();

        System.out.println("\nLinear Search for 'Algorithms':");
        Book result1 = lib.linearSearch("Algorithms");
        if (result1 != null) result1.printBook();
        else System.out.println("Book not found.");

        System.out.println("\nBinary Search for 'Python Programming':");
        Book result2 = lib.binarySearch("Python Programming");
        if (result2 != null) result2.printBook();
        else System.out.println("Book not found.");
    }
}
