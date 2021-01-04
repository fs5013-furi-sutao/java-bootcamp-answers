## main メソッド内をメソッドの呼び出しが並んだ状態にする

main メソッド内をメソッドの呼び出しが並んだ状態にするとプログラムが読みやすくなります。

例えば次の例を見てみましょう。

```java
public class App {
    public static void main(String[] args) {
        System.out.println("Game start!");

        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }

        System.out.pringln("Game end!");
    }
}
```

main メソッド内の処理を外部メソッドに切り出していくと、次のようになります。

```java
public class App {
    public static void main(String[] args) {

        App app = new App();
        app.callStart();
        app.count(10);
        app.callEnd();

    }

    public void callStart() {
        System.out.println("Game start!");
    }

    public void callEnd() {
        System.out.pringln("Game end!");
    }

    public void count(int num) {
        for (int i = 1; i <= num; i++) {
            System.out.println(i);
        }
    }
}
```

このように、1 つの役割ごとに処理をメソッドを切り出し、
main メソッド内をメソッドの呼び出しが並んだ状態にするとどうでしょう。

処理の流れが把握しやすくなります。
main メソッド内の手続きで何をやりたいのかの意図が明快ですよね。

main メソッド内に、メソッド呼び出しでストーリーを作ると、
読みやすく分かりやすいプログラムになります。

## メソッド切り出しの副産物

こうして処理を細かく切り出すと、読みやすくなるだけではありません。

例えば上記の例では、Game Start と Game End をそれぞれメソッド化しています。

Game Start の表示だけちょっと変えたいという場合は、
callStart メソッドだけを変更すれば良いことになります。

細かく部品化したことで、変更箇所がピンポイントで分かりやすくなります。

## ミニ課題（時間: 20 分）

次の BattleField クラスについて、main メソッド内の手続きが分かりやすくなるように、
メソッドの呼び出しが並んだ状態にしなさい

```java title=src/BattleField.java
import java.util.Random;

public class BattleField {
    public static void main(String[] args) {

        System.out.println("-----");
        System.out.println("処理をスタートします");
        System.out.println("-----");

        String[] players = { "山本", "浜田", };

        Random rand = new Random();
        for (int i = 1; i <= 5; i++) {
            int randomIndex = rand.nextInt(2);
            String attackerName = players[randomIndex];

            String defenderName
                = players[Math.abs(randomIndex - 1)];

            System.out.printf("ターン %d: %n", i);
            System.out.printf(
                "%s が %s を攻撃した. %n",
                attackerName, defenderName
            );
            System.out.println();
        }

        System.out.println("-----");
        System.out.println("処理をスタートします");
        System.out.println("-----");
    }
}
```

```txt title=BattleFieldクラスの実行結果
-----
処理をスタートします
-----

ターン 1:
山本 が 浜田 を攻撃した.

ターン 2:
山本 が 浜田 を攻撃した.

ターン 3:
浜田 が 山本 を攻撃した.

ターン 4:
浜田 が 山本 を攻撃した.

ターン 5:
山本 が 浜田 を攻撃した.

-----
処理を終わります
-----

```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/03.primary/12.creating-story-with-method-calls/src/BattleField.java
