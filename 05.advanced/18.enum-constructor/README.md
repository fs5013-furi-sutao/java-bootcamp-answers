## 学習

### Enum コンストラクタを知る

Enum コンストラクタとは何かを Web で調べてください。
検索キーワードは、「 [java enum コンストラクタ](https://www.google.com/search?q=java+enum+コンストラクタ) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、Enum コンストラクタとは何か、Enum コンストラクタの使い方をつかみましょう。

## Enum をフル活用する方法

ここでは、日本の硬貨を例にして、Enum の発展した使い方を見ていく。

日本の硬貨を enum にすると次のようになる。

```java
enum CoinType {
    ONE,
    FIVE,
    TEN,
    FIFTY,
    HUNDRED,
    FIVE_HUNDRED,
    ;
}
```

## 定数と値を対応させる

このままでは定義だけで、金額といった実際に使い道のある値への対応づけができていない。

enum 値（インスタンス）と int 値を対応づけたい場合は、クラスと同じようにコンストラクタを使ってフィールドへ値を代入する。

```java
enum CoinType {
    ONE(1),
    FIVE(5),
    TEN(10),
    FIFTY(50),
    HUNDRED(100),
    FIVE_HUNDRED(500),
    ;

    private int price;

    CoinType(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}
```

### private なコンストラクタ

ただし、注意してほしいのは enum のコンストラクタは private を記述しなくても、暗黙的に private になること。

なぜなら、各 Enum 値（インスタンス）は、実行されるプログラム中でただ 1 つになることを保障しなければならないように設計されているからである。

### 定数それぞれがフィールドを持っている

Enum は内部的には、特殊なクラスとして扱われている。

上記のコード例から分かるように、定数それぞれがフィールドを持ったインスタンスになっている。

## さらに複数の値を対応づける

使い勝手を良くするために、フィールド jpName を追加する。

```java
enum CoinType {
    ONE("1円玉", 1),
    FIVE("5円玉", 5),
    TEN("10円玉", 10),
    FIFTY("50円玉", 50),
    HUNDRED("100円玉", 100),
    FIVE_HUNDRED("500円玉", 500),
    ;

    private String jpName;
    private int price;

    CoinType(String jpName, int price) {
        this.jpName = jpName;
        this.price = price;
    }

    public String getJpName() {
        return this.jpName;
    }

    public int getPrice() {
        return this.price;
    }
}
```

### enum インスタンスを使ってみる

定義した CoinType を使ってみる。

```java
for (CoinType c : CoinType.values()) {
    System.out.printf("%5s: %3d%n", c.getJpName(), c.getPrice());
}
```

実行結果:

```output
  1円玉:   1
  5円玉:   5
 10円玉:  10
 50円玉:  50
100円玉: 100
500円玉: 500
```

Stream API とラムダ式を使うと上記のコードは次のように書き換えられる。

```java
Arrays.stream(CoinType.values())
    .forEach(e ->
        System.out.printf("%5s: %3d%n", e.getJpName(), e.getPrice())
    );
```

## 金額から enum 値を返すメソッドを追加する

金額から enum 値（インスタンス）を返す static メソッド priceOf() を追加すると enum は次のようになる。

```java
import java.util.Arrays;

enum CoinType {
    ONE("1円玉", 1),
    FIVE("5円玉", 5),
    TEN("10円玉", 10),
    FIFTY("50円玉", 50),
    HUNDRED("100円玉", 100),
    FIVE_HUNDRED("500円玉", 500),
    UNKNOWN("存在しない", -1)
    ;

    private String jpName;
    private int price;

    CoinType(String jpName, int price) {
        this.jpName = jpName;
        this.price = price;
    }

    public String getJpName() {
        return this.jpName;
    }

    public int getPrice() {
        return this.price;
    }

    public static CoinType priceOf(int price) {
        return Arrays.stream(CoinType.values())
            .filter(e -> price == e.getPrice())
            .findFirst()
            .orElse(CoinType.UNKNOWN);
    }
}
```

この enum を main メソッドから利用してみる。

```java
System.out.println(CoinType.priceOf(50).getJpName());
System.out.println(CoinType.priceOf(60).getJpName());
```

実行結果:

```output
50円玉
存在しない
```

### 凝集度を考えて

以下は、enum 的な話を越えた、設計的な余談になる。

クラス設計を考えると、凝集度を高めるために、getter を外部に漏らしたくない。そうすると、enum と enum を使う側のコードは次のようになる。

```java title="Cointype.java"
enum CoinType {

    // ・・・中略

    public static CoinType priceOf(int price) {
        return Arrays.stream(CoinType.values())
            .filter(e -> price == e.getPrice())
            .findFirst()
            .orElse(CoinType.UNKNOWN);
    }

    public static String getJpNameFromPriceOf(int price) {
        return priceOf(price).getJpName();
    }

}

```

```java
System.out.println(CoinType.getJpNameFromPriceOf(50));
System.out.println(CoinType.getJpNameFromPriceOf(60));
```

## まとめ

Enum の各値には複数の値を対応づけることができる。static メソッドを自作することで、値から逆引きして enum 値（インスタンス）を取得することもできる。

この機能を使えば、アプリ内での設定値の管理が楽になり、処理の見通しも良くなる。

ただし、設定値が数百個単位となってくると、管理が大変になる。

そうした場合は、DB で設定値を管理する方法のほうがベターか、検討する余地がある。

## 練習問題（時間: 20 分）

次のクラス、インタフェースについて、性別と食性の型を Enum にするよう、リファクタリングをしなさい

1. Barkable.java 鳴く能力をあらわすインタフェース
2. Animal.java 動物をあらわす抽象クラス
3. Cat.java ネコクラス
4. Rabbit.java ウサギクラス
5. PetShop.java 実行クラス

### 1. Barkable.java 鳴く能力をあらわすインタフェース

```java
package advanced.enumcon.entity;

public interface Barkable {
    void bark();
}
```

### 2. Animal.java 動物をあらわす抽象クラス

```java
package advanced.enumcon.entity;

public abstract class Animal implements Barkable {

    private String name;
    private boolean isMale;
    private String feedingType;

    protected Animal(String name, boolean isMale, String feedingType) {
        this.name = name;
        this.isMale = isMale;
        this.feedingType = feedingType;
    }

    public void eat() {
        showFeedingType();
    }

    private void showFeedingType() {
        System.out.format(
                "%s は %s ........", this.name, this.feedingType
            );
    }

    @Override
    public String toString() {

        return String.format(
                "名前=%s::性別=%s::食性=%s",
                this.name,
                toStringGender(),
                this.feedingType
            );
    }

    public void changeName(String newName) {
        this.name = newName;
    }

    private String toStringGender() {
        if (this.isMale) return "オス";
        return "メス";
    }
}
```

### 3. Cat.java ネコクラス

```java
package advanced.enumcon.entity;

public class Cat extends Animal {

    public Cat(
            String name, boolean isMale) {

                super(name, isMale, "肉食");
    }

    @Override
    public void bark() {
        System.out.println("にゃあ にゃあ ........");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("魚を食べた ........");
    }
}
```

### 4. Rabbit.java ウサギクラス

```java
package advanced.enumcon.entity;

public class Rabbit extends Animal {

    public Rabbit(
            String name, boolean isMale) {

        super(name, isMale,  "草食");
    }

    @Override
    public void bark() {
        System.out.println("みゅー みゅー ........");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("草を食べた ........");
    }
}
```

### 5. PetShop.java 実行クラス

```java
package advanced.enumcon;

import advanced.abstracts.animal.entity.Animal;
import advanced.abstracts.animal.entity.Barkable;
import advanced.abstracts.animal.entity.Cat;
import advanced.abstracts.animal.entity.Rabbit;

public class PetShop {

    private static final boolean MALE = true;
    private static final boolean FEMALE = false;

    public static void main(String[] args) {

        Animal[] pets = {
                new Rabbit(
                        "スキウサギ",
                        FEMALE
                    ),

                new Cat(
                        "どらねこ",
                        MALE
                    ),
            };

        for (Animal pet : pets) {
            System.out.println(pet.toString());
            pet.eat();
            pet.bark();
            System.out.println();
        }

        pets[0].changeName("ツキウサギ");
        System.out.println(pets[0].toString());
        pets[0].eat();

        Barkable rabbit = pets[0];
        rabbit.bark();
    }
}
```

### PetShop.java の実行結果

```console
名前=スキウサギ::性別=メス::食性=草食
スキウサギ は HERBI ........草を食べた ........
みゅー みゅー ........

名前=どらねこ::性別=オス::食性=肉食
どらねこ は CARNI ........魚を食べた ........
にゃあ にゃあ ........

名前=ツキウサギ::性別=メス::食性=草食
ツキウサギ は HERBI ........草を食べた ........
みゅー みゅー ........
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/05.advanced/18-enum-constructor/src/advanced/enumcon
