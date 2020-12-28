## ミニ課題 01: 指定の数値が入力されるまで（時間: 20 分）

「77」が入力されるまで入力が受け付けられる処理を main メソッドに持つ UntilTargetNumberLooper クラスを作成しなさい

### UntilTargetNumberLooper の実行結果

```
77 が入力されたら終了します.

1 回目: 数字を入力してください: 76
2 回目: 数字を入力してください: br
  => 数字以外の値（ br ）が入力されました.

3 回目: 数字を入力してください: *
  => 数字以外の値（ * ）が入力されました.

4 回目: 数字を入力してください: 77

  => 77 が入力されたので終了しました.
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/34.while-statement/src/UntilTargetNumberLooper.java

## ミニ課題 02: 空文字が入力されるまで（時間: 20 分）

空文字「」が入力される（文字の入力なしで Enter キーが押された状態）まで入力が受け付けられる処理を main メソッドに持つ UntilBlankLooper クラスを作成しなさい

※プログラムのベースには、以下のソースコードを使用すること

### ベースコード

```java title=src/UntilBlankLooper.java
import java.util.Scanner;

public class UntilBlankLooper {
    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        final String BLANK = "";

        String inputtedString;
        int count = 0;

        System.out.println(
            "文字が入力されず Enter キーが押されたら終了します. \n"
        );

        /**
         * TODO: ここに処理を追加する
         */

        System.out.println("\n  => 文字が入力されなかったので終了しました.");
        stdin.close();
    }
}
```

### UntilBlankLooper の実行結果

```
文字が入力されず Enter キーが押されたら終了します.

1 回目: 文字を入力してください: aaa
2 回目: 文字を入力してください: @@@
3 回目: 文字を入力してください: 23
4 回目: 文字を入力してください:

  => 文字が入力されなかったので終了しました.
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/34.while-statement/src/UntilBlankLooper.java
