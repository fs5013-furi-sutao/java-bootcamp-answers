## 条件式をメソッド化する

次の例を見てください。

showCheckValueResult メソッド内の if 文では値が指定範囲内にあるかチェックしています。
しかし、条件式を見ても、直感的に範囲チェックしているのが読み取りにくいです。

```java title=リファクタリング前
public class Validator {

    final int MIN = 10;
    final int MAX = 20;

    public void showCheckValueResult(int num) {

        if (return this.MIN <= num && num <= this.MAX) {
            System.out.println("範囲内です.");
            returnl;
        }
        System.out.println("範囲外です.");
    }
}
```

そこで、条件式を外部メソッド isInRange() に切り出してあげると、範囲チェックしていることが直感的に伝わりやすくなります。

```java title=リファクタリング後：if文の条件式をメソッド化
public class Validator {

    final int MIN = 10;
    final int MAX = 20;

    public void showCheckValueResult(int num) {

        if (isInRange(num)) {
            System.out.println("範囲内です.");
            returnl;
        }
        System.out.println("範囲外です.");
    }

    private boolean isInRange(int num) {
        return this.MIN <= num && num <= this.MAX;
    }
}
```

このように、if 文や while 文の条件式を `is○○` のようなメソッド呼び出しにすると、
何を判定しているか分かりやすいコードになります。

## ミニ課題（時間: 20 分）

次のクラス SlimeAttacker について、main メソッド内の処理で使われている条件式をメソッド化しなさい

```java title=src/SlimeAttacker.java
import java.util.Random;

public class SlimeAttacker {
    public static void main(String[] args) {

        Slime slime = new Slime("メタルスライム", 12);
        int cntTurn = 0;

        while (slime.hp > 0) {

            cntTurn++;
            System.out.printf("%d ターン: %n", cntTurn);

            slime.recieveBlows();

            if (slime.hp <= 0) {
                System.out.printf(
                    "%s は死にました.  %n", slime.name
                );
            }
            System.out.println();
        }
    }
}

class Slime {
    Random rand = new Random();
    public String name;
    public int hp;

    public Slime(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public void recieveBlows() {
        System.out.printf("%s は殴られた. %n", this.name);

        int damage = this.rand.nextInt(10);
        this.hp = Math.max(0, this.hp - damage);

        System.out.printf(
            " => %s は %d のダメージを受けた. %n", this.name, damage
        );
        System.out.printf(" => HP: %d %n", this.hp);
    }
}

```

```txt title=SlimeAttackerクラスの実行結果
1 ターン:
メタルスライム は殴られた.
 => メタルスラム は 0 のダメージを受けた.
 => HP: 12

2 ターン:
メタルスライム は殴られた.
 => メタルスラム は 4 のダメージを受けた.
 => HP: 8

3 ターン:
メタルスライム は殴られた.
 => メタルスラム は 2 のダメージを受けた.
 => HP: 6

4 ターン:
メタルスライム は殴られた.
 => メタルスラム は 9 のダメージを受けた.
 => HP: 0
メタルスライム は死んだ.

```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/03.primary/13.methodize-conditional-expressions-in-if-statements/src/SlimeAttacker.java

## ミニ課題（時間: 20 分）

次のクラス TemperatureManager について、main メソッド内の処理で使われている条件式をメソッド化しなさい

```java title=src/TemperatureManager.java
import java.util.Random;

public class TemperatureManager {
    public static void main(String[] args) {

        final int DIFF_SETTING = 6;
        final int MIN_TEMPERATURE = 2;
        final int MAX_TEMPERATURE = 11;
        int nowTemperature = 7;

        Temperature aichiTemp =
            new Temperature(
                MIN_TEMPERATURE, MAX_TEMPERATURE, nowTemperature
            );

        aichiTemp.showCurrentStatus();

        while (MIN_TEMPERATURE <= aichiTemp.now
                && aichiTemp.now <= MAX_TEMPERATURE) {

            aichiTemp.addChange(DIFF_SETTING);
            aichiTemp.showNowAndCurrentChange();

        }
    }
}

class Temperature {
    private static Random rand = new Random();
    public final int MIN;
    public final int MAX;
    public int now;
    public int currentChange;

    public Temperature(int min, int max, int now) {
        this.MIN = min;
        this.MAX = max;
        this.now = now;
    }

    public void showNowAndCurrentChange() {
        System.out.printf(
            "現在の気温: %d (差: %d) %n",
            this.now, this.currentChange
        );
    }

    public void addChange(int diffSetting) {
        this.currentChange = this.getChange(diffSetting);
        this.now += this.currentChange;
    }

    public void showCurrentStatus() {
        System.out.printf(
            "設定温度=( 最低: %d, 最高: %d ) %n",
            this.MIN, this.MAX
        );
        System.out.printf("現在の気温: %d %n", this.now);
        System.out.println("-----");
    }

    public int getChange(int diffSetting) {
        int sign = rand.nextBoolean() ? 1 : -1;  // プラス・マイナス符号
        return rand.nextInt(diffSetting) * sign;
    }
}
```

```txt title=TemperatureManagerクラスの実行結果
設定温度=( 最低: 2, 最高: 11 )
現在の気温: 7
-----
現在の気温: 11 (差: 4)
現在の気温: 10 (差: -1)
現在の気温: 6 (差: -4)
現在の気温: 9 (差: 3)
現在の気温: 13 (差: 4)
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/03.primary/13.methodize-conditional-expressions-in-if-statements/src/TemperatureManager.java
