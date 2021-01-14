## 学習

### Java の super キーワードを知る

Java の super キーワードとは何かを Web で調べてください。
検索キーワードは、「 [java super](https://www.google.com/search?q=java+super) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、Java の super キーワードとは何か、 super キーワードの使い方をつかみましょう。

## 練習問題（時間: 20 分）

以下の Zoo クラスを実行すると、実行結果の通りになるように、Animal クラスを継承して Dog クラスを作成しなさい

### Zoo.java

```java
package advanced.superkey;

import advanced.superkey.entity.Animal;
import advanced.superkey.entity.Dog;

public class Zoo {

    public static void main(String[] args) {

        Animal dog = new Dog();
        dog.bark("きゃんきゃん");
    }
}
```

### Animal.java

```java
package advanced.superkey.entity;

public class Animal {

    protected String type = "Animal";

    protected Animal() {
        System.out.println(
            "[Animal] デフォルトコンストラクタを実行"
        );
    }

    public Animal(String message) {
        System.out.format("[Animal]  %s %n",
                message
            );
    }

    public void bark(String sound) {
        System.out.format(
                  "[Animal] %s .......... %n",
                  sound
              );
    }
}
```

### Zoo.java の実行結果

```console
[Animal]  [Dog] String 引数のコンストラクタを呼び出し
[Dog] Animal Dog クラスを生成しました.
[Animal] わんわんきゃんきゃん ..........
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/05.advanced/03.super-keyword/src/advanced/superkey
