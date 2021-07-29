## 学習

### throw と thorows で何ができるのかを知る

throw とは何か、thorows とは何か、throw と thorows で何ができるのかを Web で調べてください。
検索キーワードは、「 [java throw throws](https://www.google.com/search?q=java+throw+throws) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、throw と thorows で何ができるのかをつかみましょう。

## 練習問題 1（時間: 20 分）

上流で例外をキャッチするように処理を書き換えなさい

### FileUser.java

``` java
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

class FileUser {
    public static void main(String[] args) {
        findFile();
    }

    public static void findFile() {

        File newFile = new File("test.txt");
        try {
            FileInputStream stream = new FileInputStream(newFile);
            stream.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
```
### 実行結果

``` console
java.io.FileNotFoundException: test.txt (指定されたファイルが見つかりません。)
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/06.master/03.thorow-and-thorows/src/master/throwsclause/FileUser.java

## 練習問題 2（時間: 20 分）

実行結果になるように、generateNullPointerDemo メソッドに処理を追記しなさい

### NullPointerDemo.java

``` java
public class NullPointerDemo {
    public static void main(String args[]) {

        try {
            generateNullPointerDemo();

        } catch (NullPointerException e) {
            System.out.format("再キャッチ: %s %n", e);
        }
    }

    static void generateNullPointerDemo() {
        System.out.println("generateNullPointerDemo の中でキャッチされた");
    }
}
```

### 実行結果

``` console
generateNullPointerDemo の中でキャッチされた
再キャッチ: java.lang.NullPointerException: demo 
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/06.master/03.thorow-and-thorows/src/master/throwclause/NullPointerDemo.java
