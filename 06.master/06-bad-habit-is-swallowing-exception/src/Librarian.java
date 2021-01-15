public class Librarian {
    public static void main(String[] args) {

        Book[] books = {
                new Book("檸檬", "梶井基次郎"),
                new Book("平家物語"),
                new Book("ニコマコス倫理学", "アリストテレス"),
                new Book("こころ", "夏目漱石"),
        };

        Library library = new Library();
        library.addBooks(books);

        for (int i = 0; i < library.getNumberOfBooks(); i++) {
            Book targetBook = library.getBookIndexOf(i);
            try {
                targetBook.showDetails();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }  
    }
}
