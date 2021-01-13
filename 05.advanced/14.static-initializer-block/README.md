## 学習

### Static 初期化ブロックを知る

Static 初期化ブロックとは何かを Web で調べてください。
検索キーワードは、「 [java static 初期化ブロック](https://www.google.com/search?q=java+static+初期化ブロック) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、Static 初期化ブロックとは何か、Static 初期化ブロックの使い方をつかみましょう。

### Static ブロック

静的のブロックを初期化するために使用される静的変数を。静的の変数を宣言時に直接初期化することができ、我々は複数行の処理を行うために必要としている状況があります。

このような場合、静的ブロックが役立ちます。

静的変数が初期化中に追加のマルチステートメントロジックを必要とする場合は、静的ブロックを使用できます。

#### マルチステートメントロジックの例

```java
public class StaticBlockDemo {
    public static List<String> ranks = new LinkedList<>();

    static {
        ranks.add("Lieutenant");
        ranks.add("Captain");
        ranks.add("Major");
    }

    static {
        ranks.add("Colonel");
        ranks.add("General");
    }
}
```

## Static ブロックが必要になるケース

- Static 変数の初期化に、割り当て以外の追加のロジックが必要な場合
- Static 変数の初期化がエラーを起こしやすく、例外処理が必要な場合

### 参考: 覚えておくべきキーポイント

- クラスは複数の Static ブロックを持つことができる
- Static フィールドと Static ブロックは、クラスに存在するのと同じ順序で解決および実行される

## 練習問題（時間: 20 分）

次のクラス InitializationExecutor を実行すると、
Static 変数やインスタンス変数を初期化ブロックで使って、実行結果の通りになるように Initializer クラスを作成しなさい

### InitializationExecutor.java

```java
public class InitializationExecutor {

    public static void main(String[] args) {

        Initializer testInit = new Initializer("事前テスト");
        testInit.showCounterValue();
        System.out.println();

        Initializer[] inits = {
                new Initializer("一郎"),
                new Initializer("次郎"),
                new Initializer("三郎"),
            };

        for (Initializer init : inits) {
            init.showCounterValue();
        }
        System.out.println();

        testInit = new Initializer("中間テスト");
        testInit.showCounterValue();
        System.out.println();

        for (Initializer init : inits) {
            init.showCounterValue();
        }
    }
}
```

### InitializationExecutor.java の実行結果

```console
Static 初期化ブロックが実行されました
[id] 1, [name] 事前テスト, [staticCounter] 1, [instanceCounter] 1

[id] 2, [name] 一郎, [staticCounter] 4, [instanceCounter] 1
[id] 3, [name] 次郎, [staticCounter] 4, [instanceCounter] 1
[id] 4, [name] 三郎, [staticCounter] 4, [instanceCounter] 1

[id] 5, [name] 中間テスト, [staticCounter] 5, [instanceCounter] 1

[id] 2, [name] 一郎, [staticCounter] 5, [instanceCounter] 1
[id] 3, [name] 次郎, [staticCounter] 5, [instanceCounter] 1
[id] 4, [name] 三郎, [staticCounter] 5, [instanceCounter] 1
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/05.advanced/14.static-initializer-block/src
