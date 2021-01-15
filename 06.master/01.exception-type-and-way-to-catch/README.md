## ミニ課題: リファクタリング（時間: 20 分）

Order クラスの calcWholePrice メソッドの処理について、
以下の仕様が伝わりやすくなるように説明変数を導入して修正（リファクタリング）しなさい

### 金額総計（wholePrice）の計算方法
以下、A と B の合計に消費税（10%）を掛けたものに送料を加算

### A. 合計額
- 価格 × 個数

### B. ボリューム割引
- 500 個以上は、価格の 5% を割引

### C. 送料
- 合計額の 10%、ただし、上限は 10,000 円


```java title=src/PriceCalculator.java
public class PriceCalculator {
    public static void main(String[] args) {

        int itemPrice = 9800;
        int quantity = 580;
        Order order = new Order(itemPrice, quantity);
        int wholePrice = order.calcWholePrice();
        System.out.printf(
            "%d 円の商品を %d 個注文 => %d 円（税込）%n",
            itemPrice , quantity, wholePrice
        );
    }
}

class Order {
    private int itemPrice;
    private int quantity;

    public Order(int itemPrice, int quantity) {
        this.itemPrice = itemPrice;
        this.quantity = quantity;
    }

    public int calcWholePrice() {
        return Long.valueOf(Math.round(
                (this.itemPrice * this.quantity
                    - this.itemPrice 
                    * Math.max(0, this.quantity - 500) 
                    * 0.05
                ) * 1.10
                + Math.min(
                    this.itemPrice * this.quantity * 0.1, 
                    10000
                )
            )).intValue();
    }
}
```

### PriceCalculator の実行結果

```
9800 円の商品を 580 個で注文 => 6219280 円（税込）
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/03.primary/01.explaining-variable/src/PriceCalculator.java
