import java.util.ArrayList;
import java.util.List;

public class Library {
    
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBooks(Book... books) {
        for (Book book : books) {
            this.books.add(book);
        }
    } 

    public Book getBookIndexOf(int index) {
        return this.books.get(index);
    }

    public int getNumberOfBooks() {
        return this.books.size();
    }
}
