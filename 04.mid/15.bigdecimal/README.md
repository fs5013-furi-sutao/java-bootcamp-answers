## 学習

### 金額計算で BigDecimal クラスを使う理由を調べる

Java の BigDecimal クラスとは何かを Web で調べてください。
検索キーワードは、「 [java bigdecimal](https://www.google.com/search?q=java+bigdecimal) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、Java の BigDecimal クラスとは何か、金額計算で BigDecimal クラスを使う方法をつかみましょう。

## 練習問題（時間: 20 分）

次の AmountCalculator クラスについて、送料の計算結果が正しくなるように、コードを修正しなさい

### AmountCalculator.java

```java
import java.math.BigDecimal;

public class AmountCalculator {
    public static void main(String[] args) {

        double shippingRate = 0.3;
        BigDecimal strictShippingRate = new BigDecimal(shippingRate);
        BigDecimal noteBookPrice = new BigDecimal("1000");

        BigDecimal resultAmount = noteBookPrice.multiply(strictShippingRate);
        System.out.format(
                "%.0f 円のノートの送料（%.0f%%）: %n",
                noteBookPrice,
                shippingRate * 100
            );

        System.out.println(resultAmount);
    }
}
```

### 修正前の AmountCalculator.java の実行結果

```console
1000 円のノートの送料（30%）:
299.999999999999988897769753748434595763683319091796875000
```

### 修正後に期待する結果

```console
1000 円のノートの送料（30%）:
300.0
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/04.mid/15.bigdecimal/src/AmountCalculator.java
