public class Book {
    
    private String title;
    private String author;

    public Book(String title) {
        this.title = title;
    }
    
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void showDetails() {
        System.out.format(
            "[Title] %s, [Author の登録] %s %n",
            this.title,
            showIsBlankAuthor());
    }

    private String showIsBlankAuthor() {
        if (this.author.equals("")) {
            return "なし";
        }
        return "あり";
    }
}
