## 学習

### チェック例外と非チェック例外を認識する

Java におけるチェック例外と非チェック例外の違いを Web で調べてください。
検索キーワードは、「 [java 例外 握りつぶし](https://www.google.com/search?q=java+例外+try+catch) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、チェック例外と非チェック例外、それぞれの特徴と扱い方をつかみましょう。

### 例外の握りつぶしとは

例外の握りつぶしは、Exception swallowing とも呼ばれます。

例外の握りつぶしが何かを知るには、コードを見るのが早いです。

```java
String target = "数字ではない";
try {
    int targetInt = Integer.parseInt(target);

} catch (NumberFormatException e) {
    // 何もしない
}
```

上記の処理ように、「例外を catch するけどその中では何もしない」ことを指して「握りつぶす」と呼びます。
これは、そもそも try-catch を書かないのとは全く違う行為です。

上記の処理の実行結果は、次のようになります。
つまり、何も起きません。

```console

```

## 隠蔽エラー

エラーが発生せず何も起きないのが何が悪いのか？
それは例外が発生したのに、開発者が何も把握できないという状態こそが大問題なのです。

この例外が隠されてしまう事象のことを、エラー隠蔽（Error hiding）と呼びます。

例外が握りつぶされてしまうと、バグの原因追及を難しくし、
システムに取って致命的なエラー（Critical error）を知らないうちに埋め込んでしまいます。

そのため、こうした箇所は「アプリのサイレントキラー」と表現されることもあります。

比較として、上記の例外に対して try-catch を書かないコードを書いてみます。

```java
String target = "This is not a number.";
int targetInt = Integer.parseInt(target);
```

この処理の実行結果は次のようになります。

```java
Exception in thread "main" java.lang.NumberFormatException: For input string: "数字ではない"
        at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        at java.base/java.lang.Integer.parseInt(Integer.java:652)
        at java.base/java.lang.Integer.parseInt(Integer.java:770)
        at master.swallowing.excep.App.main(App.java:7)
```

### まとめ

例外の握りつぶしを行うと次のことが起こります。

- 例外が発生したことを、誰も知ることができない
- プログラムはそのまま実行され続ける

これにより、問題調査が困難になる可能性があるので、例外の握りつぶしは避けるべきです。

特に業務で製造するようなアプリやシステムにおいては、例外をキャッチした箇所で、
ログにスタックトレースを記録する処理を、必ず実装しましょう。

## 練習問題（時間: 20 分）

次のプロジェクトについて、例外が発生したことが隠蔽されないようにコードを修正しなさい

プロジェクトは次の 3 つのクラスからなる

1. Book.java
2. Library.java
3. Librarian.java

### 1. Book.java

```java
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
```

### 2. Library.java

```java
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
```

### 3. Librarian.java

```java
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
                // TODO: 後で実装を決める
            }
        }
    }
}
```

### 修正前の Librarian.java の実行結果

```console
[Title] 檸檬, [Author の登録] あり
[Title] ニコマコス倫理学, [Author の登録] あり
[Title] こころ, [Author の登録] あり
```

### 修正後の Librarian.java の期待する結果

```console
[Title] 檸檬, [Author の登録] あり
java.lang.NullPointerException
        at Book.showIsBlankAuthor(Book.java:31)
        at Book.showDetails(Book.java:27)
        at Librarian.main(Librarian.java:17)
[Title] ニコマコス倫理学, [Author の登録] あり
[Title] こころ, [Author の登録] あり
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/06.master/06-bad-habit-is-swallowing-exception/src
