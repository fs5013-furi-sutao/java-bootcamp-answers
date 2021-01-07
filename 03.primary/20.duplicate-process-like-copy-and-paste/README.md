# 20. 不吉なにおい 🐽 コピペのように処理を複製する

<p class="goal">
  重複処理がいたるところにあると、処理の見通しも悪くなり、同じ改修を複数やらなければならず、
  修正漏れが起きた場合、バグも起きてしまうことを知る
</p>

## 学習

### あれ？同じようなコードがあちこちに

「あれ？何かこのコードとそっくりな箇所、どこかで見たような・・・」

これは、「重複したコード」(Duplicate Code) という「不吉なにおい」の特徴です。

重複したコードというのは、複数の箇所に似たようなコードが散らばっている状態です。コードを安易にコピぺして処理を作ってしまうと、重複したコードがあちこちに散らばることになります。

コードが重複してしまうと、修正がしにくくなります。見つかったバグを取る時に、たくさんの箇所を修正するはめになるからです。

### コピペコーディングの害

コピペコーディングの害は、コードの量自体の増大やそれにともなう見通しの悪さだけではないです。

コピペ元の誤り（if 文の条件漏れなど）がそのまま伝播していき、バグがプロジェクト全体に広がっていくこともあり得ます。

また、バグを修正していくにしても、同じような部分を全て差分を見ながら、手で直していくという時間の掛かる作業が後々発生させることにもつながってしまうのです。

### 重複したコードはどうする？

重複したコードを見つけたら、まとまりを探してクラスやメソッドに切り出すようなリファクタリングを検討します。

## ミニ課題（時間: 20 分）

次のプログラム IcecreamPrices.java について、重複した計算がなくなるようにリファクタリングしなさい

### src/IcecreamPrices.java

```java
public class IcecreamPrices {

    private static final String ICECREAM_CONTENT_FORMAT
        = "%d 個盛り %s アイスの値段: %.0f 円 %n";

    public static void main(String[] args) {

        IceCream ic = new IceCream();
        ic.flavor = "ピスタチオ";
        ic.numberOfScoops = 2;

        System.out.printf(
            ICECREAM_CONTENT_FORMAT,
            ic.numberOfScoops,
            ic.flavor,
            ic.numberOfScoops * ic.pricePerScoop
        );

        FruitSaladWithIceCream fs
            = new FruitSaladWithIceCream();
        fs.flavor = "チョコレート";
        fs.numberOfScoops = 1;
        fs.gramsOfFruitSalad = 50;

        System.out.printf(
            "%d グラムのフルーツサラダと ",
            fs.gramsOfFruitSalad
        );
        System.out.printf(
            ICECREAM_CONTENT_FORMAT,
            fs.numberOfScoops,
            fs.flavor,
            fs.getFruitSaladWithIceCreamPrice()
        );

        PancakeWithIceCream pancakeWithIceCream
            = new PancakeWithIceCream();
        pancakeWithIceCream.flavor = "バニラ";
        pancakeWithIceCream.numberOfScoops = 1;
        pancakeWithIceCream.gramsOfPancake = 75;

        System.out.printf(
            "%d グラムのパンケーキと ",
            pancakeWithIceCream.gramsOfPancake
        );
        System.out.printf(
            ICECREAM_CONTENT_FORMAT,
            pancakeWithIceCream.numberOfScoops,
            pancakeWithIceCream.flavor,
            pancakeWithIceCream.getPancakeWithIceCreamPrice()
        );
    }
}

class IceCream {
    String flavor;
    int numberOfScoops;
    double pricePerScoop;

    IceCream() {
        this.pricePerScoop = 35.0;
    }
}

class FruitSaladWithIceCream extends IceCream {
    int gramsOfFruitSalad;
    double pricePerGram;

    FruitSaladWithIceCream() {
        super();
        pricePerGram = 0.75;
    }

    double getFruitSaladWithIceCreamPrice() {
        double iceCreamPrice = numberOfScoops * pricePerScoop;

        return gramsOfFruitSalad * pricePerGram + iceCreamPrice;
    }
}

class PancakeWithIceCream extends IceCream {
    int gramsOfPancake;
    double pricePerGram;

    PancakeWithIceCream() {
        super();
        pricePerGram = 1.25;
    }

    double getPancakeWithIceCreamPrice() {
        double iceCreamPrice = numberOfScoops * pricePerScoop;

        return gramsOfPancake * pricePerGram + iceCreamPrice;
    }
}
```

### IcecreamPrices の実行結果

```
2 個盛り ピスタチオ アイスの値段: 70 円
50 グラムのフルーツサラダと 1 個盛り チョコレート アイスの値段: 73 円
75 グラムのパンケーキと 1 個盛り バニラ アイスの値段: 129 円
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/03.primary/20.duplicate-process-like-copy-and-paste/src/IcecreamPrices.java
