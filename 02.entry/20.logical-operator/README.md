## ミニ課題（時間: 20 分）

以下のクラス ShortCircuit について、2 つの if 文、それぞれの上部に書かれた挙動となるように、条件式中の「?」を論理演算しに置き換えなさい

```java title=src/ShortCircuit.java
public class ShortCircuit {
    public static void main(String[] args) {

        String str = null;

        // 必ず getTrue() メソッドが実行されないように
        // ショートサーキットとなるように ? を論理演算子で置き換えなさい
        if (str != null ? getTrue()) {
            System.out.println("1 つ目の if 文の中に入りました.");
        }

        // getFalse() メソッドが実行されないように
        // ショートサーキットとなるように ? を論理演算子で置き換えなさい
        if (str == null ? getFalse()) {
            System.out.println("2 つ目の if 文の中に入りました.");
        }
    }

    public static boolean getTrue() {
        System.out.println("getTrue() を実行しました.");
        return true;
    }

    public static boolean getFalse() {
        System.out.println("getFalse() を実行しました.");
        return false;
    }
}
```

### ShortCircuit の実行結果

```
2 つ目の if 文の中に入りました.
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/20.logical-operator/src/ShortCircuit.java
