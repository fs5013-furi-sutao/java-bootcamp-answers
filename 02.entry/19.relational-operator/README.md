## ミニ課題（時間: 20 分）

以下のクラス RelationalOperator 中のコメントに書かれたように変数の関係を比較するように、プログラム中の「?」を関係演算子に置き換えなさい

```java title=src/RelationalOperator.java
public class RelationalOperator {
    public static void main(String[] args) {

        // 変数宣言 declare variables
        int a = 2;
        int b = 3;
        int c = 5;

        // 変数の値を表示 value of a, b and c 
        System.out.printf("a = %d, b = %d, c = %d %n%n", a, b, c);

        // a と b + c は同じでない
        System.out.println(a ? b + c);

        // a は c より大きい
        System.out.println(a ? c);

        // a + b と c は同じ
        System.out.println(a + b ? c);

        // b は a 以上
        System.out.println(a ? b);

        // a は b より小さい
        System.out.println(a ? b);
    
        // a + b は c 以上
        System.out.println(a + b ? c);
    }
}
```

### RelationalOperator の実行結果

```
a = 2, b = 3, c = 5

true
false
true
true
true
true
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/19.relational-operator/src/RelationalOperator.java
