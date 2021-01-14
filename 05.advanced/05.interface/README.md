## 学習

### インタフェースを知る

Java におけるインタフェースとは何かを Web で調べてください。
検索キーワードは、「 [java インタフェース](https://www.google.com/search?q=java+インタフェース) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、Java のインタフェースとは何か、その使い方をつかみましょう。

## 練習問題 1: インタフェースの継承（時間: 20 分）

次の CopyServiceShop クラスを実行すると、実行結果の通りになるように、以下の 2 つのインタフェースと 1 つのクラスを作成しなさい

ただし、必ず extends キーワードをどこかで使うこと

1. Printable インタフェース
2. Showable インタフェース
3. HighFunctionDisplay クラス

```java
package advanced.interf.inheritance;

public class CopyServiceShop {

    public static void main(String[] args) {

        Printable printer = new HighFunctionDisplay();
        printer.print();

        Showable display = new HighFunctionDisplay();
        display.show();
    }
}
```

### CopyServiceShop.java の実行結果

```console
[HighFunctionDisplay] 印刷しました.
[HighFunctionDisplay] 表示しました.
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/05.advanced/05.interface/src/advanced/interf/inheritance

## 練習問題 2: 複数インタフェース（時間: 20 分）

次の CopyServiceShop クラスを実行すると、実行結果の通りになるように、以下の 2 つのインタフェースと 1 つのクラスを作成しなさい

ただし、extends キーワードは使わないこと

1. Printable インタフェース
2. Showable インタフェース
3. HighFunctionDisplay クラス

```java
package advanced.interf.multi;

public class CopyServiceShop {

    public static void main(String[] args) {

        Printable printer = new HighFunctionDisplay();
        printer.print();

        Showable display = new HighFunctionDisplay();
        display.show();
    }
}
```

### CopyServiceShop.java の実行結果

```console
[HighFunctionDisplay] 印刷しました.
[HighFunctionDisplay] 表示しました.
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/05.advanced/05.interface/src/advanced/interf/multi
