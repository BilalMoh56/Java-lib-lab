import java.util.ArrayList;

public class Library {
    private String address;
    private ArrayList<Book> books;

   
    public Library(String libraryAddress) {
        this.address = libraryAddress;
        this.books = new ArrayList<>();
    }

  
    public String getAddress() {
        return address;
    }

  
    public void addBook(Book book) {
        books.add(book);
    }

 
    public void borrowBook(String bookTitle) {
        Book book = findBook(bookTitle);
        if (book != null && !book.isBorrowed()) {
            book.rented();
            System.out.println("You successfully borrowed " + bookTitle);
        } else if (book != null) {
            System.out.println("Sorry, this book is already borrowed.");
        } else {
            System.out.println("Sorry, this book is not in our catalog.");
        }
    }


    public void returnBook(String bookTitle) {
        Book book = findBook(bookTitle);
        if (book != null) {
            book.returned();
            System.out.println("You successfully returned " + bookTitle);
        }
    }

   
    public void printAvailableBooks() {
        for (Book book : books) {
            if (!book.isBorrowed()) {
                System.out.println(book.getTitle());
            }
        }
    }


    private Book findBook(String bookTitle) {
        for (Book book : books) {
            if (book.getTitle().equals(bookTitle)) {
                return book;
            }
        }
        return null;
    }

    
    public static void printOpeningHours() {
        System.out.println("Libraries are open daily from 9am to 5pm.");
    }

    
    public void printAddress() {
        System.out.println(address);
    }
}

