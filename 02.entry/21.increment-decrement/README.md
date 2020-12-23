## ミニ課題（時間: 20 分）

標準出力（System.out.println();）の上部に書かれたコメントの挙動となるように、println メソッドの引数の「?」をインクリメント、またはデクリメントで置き換えなさい

```java title=src/IncrementDecrement.java
public class IncrementDecrement {
    public static void main(String[] args) {

        int value = 5;

        // -1 した後に value の値を表示する
        System.out.println(?);

        // value の値を表示した後に + 1 する
        System.out.println(?);

        // +1 した後に value の値を表示する
        System.out.println(?);

        // value の値を表示した後に - 1 する
        System.out.println(?;

        System.out.println();
        System.out.println(value);
    }
}
```

### IncrementDecrement の実行結果

```
4
4
6
6

5
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/21.increment-decrement/src/IncrementDecrement.java
