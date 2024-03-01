## 学習

### 名前から推測できないことをやるメソッドは悪

第三者がコードを読む場合、「このメソッドは何をやるのか」とか「どんな意図があるのか」といったことは、メソッド名から汲み取ります。

わざわざ、メソッド内の実装まで見ないと何をやっているのか分からない、というのでは、そもそもメソッド名の付け方が悪い、品質の低いコードです。

つまり、第三者はメソッド名で、どんな処理の流れなのかを推測します。

###　例えば、カウントアップする処理で

例えば、カウントアップするメソッド `int counUp(int num)` があるとします。

普通にみれば、このメソッドは「渡した num を、決まった方法でカウントアップして返してくれるんだな」と思いますよね。

ですが、実際にはこのメソッド内で他のステータス（状態を管理する変数）を変更していたらどうでしょう？

「そんなの聞いてねえよ」となりますよね。

この認識の違いがバグになります。

他の処理でステータスを判定して処理内容を変える箇所がもしあったら？

ステータスを変更させるようなメソッドを探しても、そんなステータス変更はしていない。
で、長時間かけて調べたら実は、カウントアップのメソッドでステータスを変更していました。

となったら、コードを調査した人は、カウントアップメソッドにこんな処理を書いた人に「私の時間を返して！」と思うことでしょう。

## まとめ

業務で使われるようなコードは書いたら、動いたら終わりではありません。

その後の不具合調査や改修で無駄な時間（工数）を掛けないためにも。つまり、プロジェクトに対する負債を作らないためにも・・・

メソッド名にないことをやるような処理はコーディングしないようにしましょう。

## ミニ課題（時間: 20 分）

以下の問題点を解決するように FoolishMethodOwner クラスを改修しなさい

- generateNumber メソッドが数値の生成だけでなく、数値により幸運かどうかの判定もしている

### 改修対象のソースコード

```java title=src/FoolishMethodOwner.java
public class FoolishMethodOwner {

    private final int[] CONFIGURATED_NUMS = {
        6, 11, 25, 41, 52,
    };
    private boolean isLucky = false;

    public static void main(String[] args) {

        FoolishMethodOwner app = new FoolishMethodOwner();
        int numsLength = app.CONFIGURATED_NUMS.length;

        for (int i = 0; i < numsLength; i++) {
            int number = app.generateNumber(i);
            app.showIsLucky(number);
        }
    }

    private int generateNumber(int index) {

        int num = CONFIGURATED_NUMS[index];

        if (num % 2 == 0) {
            this.isLucky = true;
        } else {
            this.isLucky = false;
        }

        return num;
    }

    private void showIsLucky(int num) {
        if (this.isLucky) {
            System.out.printf("%2d => 幸運です. %n", num);
            return;
        }
        System.out.printf("%2d => 幸運ではありません. %n", num);
    }
}
```

### FoolishMethodOwner の実行結果

改修前後で実行結果が変わらないこと

```
 6 => 幸運です.
11 => 幸運ではありません.
25 => 幸運ではありません.
41 => 幸運ではありません.
52 => 幸運です.
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/50.do-something-that-is-not-in-your-name/src/FoolishMethodOwner.java
