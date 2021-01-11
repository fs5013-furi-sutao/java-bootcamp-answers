## 学習

### アクセス修飾子の種類を知り、使い分ける

Java のアクセス修飾子とは何かを Web で調べてください。
検索キーワードは、「 [java アクセス修飾子](https://www.google.com/search?q=java+アクセス修飾子) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、Java のアクセス修飾子とは何か、アクセス修飾子の種類と使い分け方をつかみましょう。

## 練習問題（時間: 20 分）

次の Dog クラスのクラス、フィールド、メソッドについて、適切なアクセス修飾子を付与しなさい

また、実行結果の通りになるように、DogBreeder クラスを作成しなさい

### Dog.java

```java
package mid.access.modifier;

class Dog {

    String name;
    int age;
    String dogType;

    Dog(String name, int age, String dogType) {

        this.name = name;
        this.age = age;
        this.dogType = dogType;
    }

    void showDetails() {
        System.out.format("%s の %s は %d 歳です. %n",
                this.dogType,
                this.name,
                this.age
            );
    }
}
```

### DogBreeder.java の実行結果

```console
秋田犬 の 秋田賢 は 7 歳です.
プードル の 山本一郎 は 1 歳です.
チワワ の 山田太朗 は 2 歳です.
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/04.mid/17.access-modifier/src/access/modifier
