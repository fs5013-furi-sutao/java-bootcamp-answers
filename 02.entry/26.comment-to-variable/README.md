## ミニ課題（時間: 20 分）

以下のクラス VariableNamesCorrecter には、変数名が分かりにくいためにコメントが付いている箇所がある。処理がみやすく、読みやすくなるように修正（リファクタリング）しなさい

```java title=src/VariableNamesCorrecter.java
public class VariableNamesCorrecter {
    public static void main(String[] args) {

        // ボールペンのコード番号
        String cd1 = "BPBK-007";
        // ボールペンの値段
        int price1 = 110;
        // ボールペンの本数
        int num1 = 1;
        // ボールペンの合計金額
        int sum1 = 0;

        // ノートのコード番号
        String cd2 = "NTBK-102 20P";
        // ノートの値段
        int price2 = 80;
        // ノートの本数
        int num2 = 5;
        // ノートの合計金額
        int sum2 = 0;

        // 消費税率 10%
        final double T = 1.10;

        // 文房具の合計金額
        int sum3 = 0;

        sum1 = (int) Math.round((price1 * num1) * T);
        sum2 = (int) Math.round((price2 * num2) * T);
        sum3 = sum1 + sum2;

        System.out.printf("%12s: 1 個 %3d 円 × %1d 個 = %3d 円（税込）%n"
            , product1, price1, num1, sum1);

        System.out.printf("%12s: 1 個 %3d 円 × %1d 個 = %3d 円（税込）%n"
            , product2, price2, num2, sum2);

        System.out.printf("すべての文房具の合計金額 = %d 円（税込）%n"
            , sum3);
    }
}
```

### VariableNamesCorrecter の実行結果

```
    BPBK-007: 1 個 110 円 × 1 個 = 121 円（税込）
NTBK-102 20P: 1 個  80 円 × 5 個 = 440 円（税込）
すべての文房具の合計金額 = 561 円（税込）
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/26.comment-to-variable/src/VariableNamesCorrecter.java
