## 学習

### Java のクラスメソッド

クラスメソッドは、静的メソッド、もしくは static メソッドとも呼ばれます。

Java のクラスメソッドとは何かを Web で調べてください。検索キーワードは、「 [java クラスメソッド](https://www.google.com/search?q=java+クラスメソッド) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、Java のクラスメソッドとは何か、クラスメソッドの使い方をつかみましょう。

## 練習問題 01: クラスメソッドの作成（時間: 20 分）

次の 2 つのクラスを作成しなさい

1. FigureManager クラス
2. Figure クラス

### 1. FigureManager クラス

以下の処理を行う main メソッドを持つクラス

- 以下の変数を宣言し、値を代入

  - 三角形の底辺: 10 cm
  - 三角形の高さ: 20 cm
  - 三角形の面積: 上記、底辺と高さのデータから Figure クラスのクラスメソッドで算出した面積

### 2. Figure クラス

三角形の面積を算出するクラスメソッド calcTriangleArea を持つ

### FigureManager.java の実行結果

```console
底辺が 10.0 cm で、高さが 20.0 cm の三角形の面積 => 100.0
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/04.mid/04.class-method/src/mid/classes/method/figure

## 練習問題 02: 誤った箇所の修正（時間: 20 分）

次の 2 つのクラス、カウンターを表すクラスと操作するクラスについて、誤っている箇所を修正しなさい

### 1. Counter.java

```java
package mid.classes.method.forfixing;

public class Counter {
    private static int count;

    static {
        count = 0;
    }

    public Counter() {

        ++this.count;

        System.out.printf(
                "Counter インスタンスが生成されました: count=%d %n",
                this.count
            );
    }

    public static void showCounter() {
        System.out.printf("counter=%d %n", this.count);
    }
}
```

### 2. Counter.java

```java
package mid.classes.method.forfixing;

public class CounterUser {

    private static final int INSTANCE_NUMS = 6;

    public static void main(String[] args) {

        Counter[] counters = new Counter[INSTANCE_NUMS];

        for (Counter counter : counters) {
            counter = new Counter();
        }

        Counter obj = new Counter();
        obj.showCounter();
    }
}
```

### CounterUser.java の実行結果

```console
Counter インスタンスが生成されました: count=1
Counter インスタンスが生成されました: count=2
Counter インスタンスが生成されました: count=3
Counter インスタンスが生成されました: count=4
Counter インスタンスが生成されました: count=5
Counter インスタンスが生成されました: count=6
counter=6
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/04.mid/04.class-method/src/mid/classes/method/forfixing
