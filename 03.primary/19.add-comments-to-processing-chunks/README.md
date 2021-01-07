# 不吉なにおい 🐽 処理のかたまりにコメントを付ける

<p class="goal">
  処理のかたまりに一言コメントを付けているということは、メソッド化で読みやすくなるサインであることを知る
</p>

## 学習

### 処理のかたまりにコメントを付けているということは・・・

処理のかたまり、ひとつの役割にコメントを付けていたら、「不吉なにおい」として感じ取ってください。

処理のかたまりにコメントを使ているということは、そのひとくくりの処理にはひとつの明確な役割があるということです。
すなわち、それはメソッドとして切り出せるような処理を、メソッドに切り出せていないことを示しています。

ひとつひとつの役割をメソッドに切り出すことで、処理が読みやすく、また処理の再利用性も高くなります。

処理のかたまりにコメントを付けようとしていたら、注意しましょう。

## ミニ課題（時間: 20 分）

次のクラス UsageFileWriter について、処理のかたまりにコメントが付いているにもかかわらず、メソッド化できていない

処理が読みやすくなるように、ひとかたまりの処理をメソッド化しなさい

### src/UsageFileWriter.java

```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UsageFileWriter {

    static final Path DIR_PATH = Paths.get("C:\\tmp");
    static final Path FILE_PATH = Paths.get("C:\\tmp\\test.txt");
    static final String QUOTE_CURSOR = ">";

    static final LocalDateTime NOW = LocalDateTime.now();
    static List<String> lines = new ArrayList<>();

    public static void main(String[] args) {

        String name = "山本一郎";
        int usageContent = 5;

        // ディレクトリの存在確認
        if (Files.exists(DIR_PATH)) {

            // ログ表示
            System.out.printf(
                "%s は既に存在します. %n",
                DIR_PATH.toAbsolutePath().toString()
            );

        } else {
            // ディレクトリの作成
            try {
                Files.createDirectory(DIR_PATH);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // ファイルの存在確認
        if (Files.exists(FILE_PATH)) {

            // ログ表示
            System.out.printf(
                "%s は既に存在します. %n",
                FILE_PATH.toAbsolutePath().toString()
            );

        } else {
            // ファイルの作成
            try {
                Files.createFile(FILE_PATH);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //　利用回数内容の作成
        lines.add("利用回数");
        lines.add("-----");

        // 利用日時の作成
        lines.add(
                String.format(
                        " - 出力日時: %s-%s-%s(%s) %s:%s:%s",
                        NOW.getYear(),
                        NOW.getMonth(),
                        NOW.getDayOfMonth(),
                        NOW.getDayOfWeek()
                                .getDisplayName(
                                    TextStyle.SHORT, Locale.JAPANESE
                                ),
                        NOW.getHour(),
                        NOW.getMinute(),
                        NOW.getSecond()));

        // 詳細内容の作成
        lines.add(
                String.format(" - 氏名: %s", name));
        lines.add(
                String.format(" - 回数: %s", usageContent));

        // ファイルへの書き込み
        try {
            Files.write(FILE_PATH, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ファイル内容の読み込み
        List<String> readLines = new ArrayList<>();
        try {
            readLines = Files.readAllLines(FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ファイル内容の表示
        // ログ表示
        System.out.println("ファイル内容を表示します...");
        for (String line : readLines) {
            System.out.printf("%s %s %n", QUOTE_CURSOR, line);
        }
    }
}
```

### UsageFileWriter の実行結果

`C:\tmp` ディレクトリを作成した状態で実行 

```
C:\tmp は既に存在します.
ファイル内容を表示します...
> 利用回数
> -----
>  - 出力日時: 2021-JANUARY-7(木) 17:14:14
>  - 氏名: 山本一郎
>  - 回数: 5
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/03.primary/19.add-comments-to-processing-chunks/src/
