## 学習

### メソッドをオーバーロードする

Java のオーバーロードとは何かを Web で調べてください。検索キーワードは、「 [java オーバーロード](https://www.google.com/search?q=java+オーバーロード) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、Java のオーバーロードとは何か、オーバーロードの方法をつかみましょう。

## 練習問題 01: メソッドのオーバーロード（時間: 20 分）

次の 2 つのクラスを作成しなさい

1. Calculator クラス
2. Adder クラス

### 1. Calculator クラス

以下の処理を行う main メソッドを持つクラス

#### 変数宣言

- int 型の変数 a に 1 を代入
- int 型の変数 b に 2 を代入
- int 型の配列 array として { 1, 5, 9, 2, 55 } を生成

#### インスタンス操作

- Adder インスタンスを生成
- 変数 a と b を足した結果を Adder インスタンスの showResultAdded で表示
- 配列 array の全要素を足した結果を Adder インスタンスの showResultAdded で表示

### 2. Adder クラス

showResultAdded メソッドとそれに付随するメソッドを持つクラス

### DogOwner.java の実行結果

```console
1 + 2 = 3
1 + 5 + 9 + 2 + 55 = 72
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/04.mid/05.overload/src/mid/overload/method

## 練習問題 02: コンストラクタのオーバーロード（時間: 20 分）

実行結果の通りになるように、次の PersonManager クラスで利用する Person クラスを作成しなさい

### PersonManager.java

```java
package mid.overload.constructor;

public class PersonManager {

    public static void main(String[] args) {

        Person[] people = {
                new Person("山本一郎", 7),
                new Person("山田次郎", 151),
                new Person(),
            };

        for (Person person : people) {
            person.show();
        }
    }
}
```

### PersonManager.java の実行結果

```console
山本一郎 さんは 7 歳です.
山田次郎 さんは 151 歳です.
名無しの太郎 さんは 20 歳です.
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/04.mid/05.overload/src/mid/overload/constructor
