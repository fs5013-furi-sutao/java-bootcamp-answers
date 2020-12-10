## ミニ課題（時間: 20 分）

以下のプログラム ReservedWords.java について、コンパイルエラーを修正し、プログラム実行結果が以下に示したようになるようにプログラムを作成しなさい。

```java title=src/ReservedWords.java
public class ReservedWords {
    public static void main(String[] args) {

        int this = 12;
        int that = 23;
        int default = 0;

        default = this + that;

        System.out.printf("%d + %d = %d%n", this, that, default);
    }
}
```

### プログラム実行結果

``` console
12 + 23 = 35
```
