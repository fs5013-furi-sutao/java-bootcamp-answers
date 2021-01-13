## 学習

### Static メソッドを知る

Static メソッドとは何かを Web で調べてください。
検索キーワードは、「 [java static メソッド](https://www.google.com/search?q=java+static+メソッド) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、Static メソッドとは何か、Static メソッドの使い方をつかみましょう。

## 練習問題 1: ユーティリティメソッド（時間: 20 分）

以下の仕様、実行結果になるように、次の 2 つのクラスを作成しなさい

1. MathUtils.java

次の 2 つのメソッドを持つユーティリティクラス

- addLong メソッド: long 型の 2 つの値を足す

- addInts メソッド：int 型の可変長引数全てを足す

2. MathAdder.java

次の処理を main メソッドに持つクラス

- addLong メソッドに 100L と 20L を渡して、変数 resultAddLong に代入
- addInts メソッドに 9, 1, 22,72, 5, 6 を渡して、変数 resultAddIns に第 hyy

- addLong メソッドの結果を表示
- addInts メソッドの結果を表示

### MathAdder.java の実行結果

```console
addLong メソッドの結果: 120
addInts メソッドの結果: 115
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/05.advanced/12.static-method/src/advanced/staticmeth/normal

## 練習問題 2: インタフェースメソッド「（時間: 20 分）

次の DataChecker クラスが実行結果の通りになるよう、インタフェース MyData を作成しなさい

> このプログラムは Java 8 以降で実行してください

### DataChecker.java

```java
package advanced.staticmeth.interf;

public class DataChecker {

    public static void main(String[] args) {

        int id = 0;

        String nullMessage = null;
        MyData.showResultValidate(++id, nullMessage);

        String emptyMessage = "";
        MyData.showResultValidate(++id, emptyMessage);

        String notEmptyMessage = "山本一郎";
        MyData.showResultValidate(++id, notEmptyMessage);
    }
}
```

### DataChecker.java の実行結果

```console
[1] 値が設定されていません.
[2] 値が設定されていません.
[3] 値が設定されています.
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/05.advanced/12.static-method/src/advanced/staticmeth/interf
