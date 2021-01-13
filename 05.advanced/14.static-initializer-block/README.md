## 学習

### Static 初期化ブロックを知る

Static 初期化ブロックとは何かを Web で調べてください。
検索キーワードは、「 [java static 初期化ブロック](https://www.google.com/search?q=java+static+初期化ブロック) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、Static 初期化ブロックとは何か、Static 初期化ブロックの使い方をつかみましょう。

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
