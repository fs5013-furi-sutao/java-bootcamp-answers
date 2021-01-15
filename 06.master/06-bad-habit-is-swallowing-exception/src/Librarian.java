public class Librarian {
    public static void main(String[] args) throws Exception {

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
            } catch (NullPointerException e) {
                // 業務アプリなどでは一般的に次のような対策をする
                // 1. アプリを落とすか
                // 2. 上流に throw するか
                // 3. ログに記録するか
                //
                // ・・・いずれにしても例外に気づけるようにする
                throw new Exception(e);
            }
        }  
    }
}
