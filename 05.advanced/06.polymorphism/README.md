## 学習

### ポリモーフィズムを知る

Java におけるポリモーフィズムとは何かを Web で調べてください。
検索キーワードは、「 [java ポリモーフィズム](https://www.google.com/search?q=java+ポリモーフィズム) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、Java のポリモーフィズムとは何か、その使い方をつかみましょう。

## 練習問題（時間: 20 分）

以下の CoffeeShop クラスを実行すると、実行結果の通りになるように、以下の 4 つのクラスを作成しなさい

1. Liquid.java 液体をあらわすインタフェース
2. Coffee.java コーヒーをあらわすクラス
3. Milk.java ミルクをあらわすクラス
4. CoffeeCup.java コーヒーカップをあらわすクラス

```java
package advanced.polymorphism;

import advanced.polymorphism.liquid.Coffee;
import advanced.polymorphism.liquid.Milk;

public class CoffeeShop {
    public static void main(String[] args) {
        CoffeeCup myCup = new CoffeeCup();

        Coffee coffee = new Coffee();
        Milk milk = new Milk();

        myCup.addLiquid(coffee);
        myCup.stir();
        System.out.println();

        myCup.addLiquid(milk);
        myCup.stir();
    }
}
```

### CoffeeShop.java の実行結果

```console
コーヒーカップを持って .....
中身のコーヒーをかき混ぜる

コーヒーカップを持って .....
中身のミルクをかき混ぜる
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/05.advanced/06.polymorphism/src/advanced/polymorphism
