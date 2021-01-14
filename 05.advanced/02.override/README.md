## 学習

### Java のオーバーライドを知る

Java のオーバーライドとは何かを Web で調べてください。
検索キーワードは、「 [java オーバーライド](https://www.google.com/search?q=java+オーバーライド) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、Java のオーバーライドとは何か、オーバーライドする方法をつかみましょう。

## 練習問題（時間: 20 分）

以下の Zoo クラスを実行すると、実行結果の通りになるように Animal クラスのメソッドをオーバーライドした Dog クラスを作成しなさい

### Zoo.java

```java
package advanced.override;

import advanced.override.entity.Dog;

public class Zoo {
    public static void main(String[] args) {

        Dog labrador = new Dog();

        labrador.eat();
        labrador.bark();
  }
}
```

### Animal.java

```java
package advanced.override.entity;

public class Animal {

    public void eat() {
        System.out.println(
              "[Animal] 食べます .........."
          );
    }
}
```

### Zoo.java の実行結果

```console
[Dog] 食べます ..........
[Dog] わん わん ..........
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/05.advanced/02.override/src/advanced/override
