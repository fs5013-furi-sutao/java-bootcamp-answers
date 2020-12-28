## ミニ課題: スコープの修正（時間: 20 分）

次のクラス MoreNarrowScope で使われている変数について、できる限りスコープを狭くするように修正しなさい

### 修正対象のコード

```java title=src/MoreNarrowScope.java
import java.util.Random;

public class MoreNarrowScope {
    public static void main(String[] args) {

        Random rand = new Random();
        int num = 0;

        int count = 0;
        boolean isHit = false;

        while (!isHit) {
            num = rand.nextInt(10);
            count++;
            System.out.printf("%d 回目の数字 => %d %n", count, num);

            if (num == 5) isHit = true;
        }
    }
}
```

### MoreNarrowScope の実行結果

```
1 回目の数字 => 8
2 回目の数字 => 8
3 回目の数字 => 2
4 回目の数字 => 4
5 回目の数字 => 6
6 回目の数字 => 0
7 回目の数字 => 5
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/36.variable-scope/src/MoreNarrowScope.java
