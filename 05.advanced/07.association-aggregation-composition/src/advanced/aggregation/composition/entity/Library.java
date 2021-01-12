package advanced.aggregation.composition.entity;

import java.util.List;

/**
 * 図書館クラス
 * 図書館クラスは本のリストを持っている
 */
public class Library {

    // 本のリストを参照するための参照
    private final List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public List<Book> getAllBooksInLibrary() {
        return this.books;
    }
}
