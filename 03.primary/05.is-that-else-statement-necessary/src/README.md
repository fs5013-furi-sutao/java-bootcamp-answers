## その else if 文や else 文は必要か？

else if 文や else 文は、不要にできるものが多いです。
例を見ながら考えていきます。

技法的には、後の項目「ガード節・早期リターン」でリファクタリング方法は改めて取り扱うので、
ここでは、else が不要になっていくイメージを掴んでください。

## 例 ①：テストの成績に応じてランクを返すメソッド

次のメソッドは、テストの成績に応じてランクが返されるメソッドです。
仕様は次の通りです。

- 90 点以上は S ランク
- 80 点以上は A ランク
- 70 点以上は B ランク
- 60 点以上は C ランク
- 60 点未満は F ランク

```java title=例①：テストの成績に応じてランクを返すメソッド
public String createScoreRank(int score) {

    String rank = "";

    if (score >= 90) {
            rank = "S";

        } else {
            if (score >= 80) {
                rank = "A";

            } else {
                if (score >= 70) {
                    rank = "B";

                } else {
                    if (score >= 60) {
                        rank = "C";

                    } else {
                        rank = "D";
                    }
                }
            }
        }
    }
    return rank;
}
```

これではネストが深くなりすぎて理解がしにくいです。

### 1. else if 文を使うようにする

そもそも、else if 文が使えていないので else if を使うようにしてみます。

```java title=例①：リファクタリング.1.else_if文を使うようにする
public String createScoreRank(int score) {
    if (x >= 90) {
        rank = "S";

    } else if (x >= 80) {
        rank = "A";

    } else if (x >= 70) {
        rank = "B";

    } else if (x >= 60) {
        rank = "C";

    } else {
        rank = "F";

    }
    return rank;
}
```

これで少し読みやすくなりました。

### 2. else 文や else if 文を排除する

ここからが本題です。

else if 文と else 文が不要なので、削除していきます。

```java title=例①：リファクタリング.2.else文やelse_if文を排除
public class ScoreRank {
    public static void main(String[] args) {

        ScoreRank app = new ScoreRank();
        int score = 55;

        System.out.printf(
            "得点が %d 点のランクは %s です.",
            score, app.createScoreRank(score)
        );

    }

    public String createScoreRank(int score) {
        if (score >= 90) return "S";
        if (score >= 80) return "A";
        if (score >= 70) return "B";
        if (score >= 60) return "C";
        return "F";
    }
}
```

例 ①：  
テストの成績に応じてランクを返すメソッドのリファクタリング後  
https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/03.primary/05.is-that-else-statement-necessary/src/ScoreRank.java

```txt title=例②：実行結果
得点が 55 点のランクは F です.
```

## 例 ②：チェック処理

次の例は良くある、メイン処理の前にあるチェック処理のかたまりです。

else if や else を多用すると、出てきた条件を全部覚えながら読む必要があるため、
どうしても可読性が落ちてしまいます。

```java title=例②：チェック処理の後にメイン処理をするメソッド
public void execute(boolean isError, String value) {

    if (isError) {
        System.out.println("エラーです.");

    } else if (value == null) {
        System.out.println("値が設定されていません.");

    } else if (!value.equals("first")
            && !value.equals("second")) {

        System.out.println("値が不正です.");

    } else {
        System.out.println("メイン処理です.");
    }
}
```

### 1. 早期リターンを使う

次のように、return 文を使えば、else 文と else if 文がなくなります。技法的にいうと、早期リターンです。

```java title=例②：リファクタリング.1.早期リターンを使う
public void execute(boolean isError, String value) {

    if (isError) {
        System.out.println("エラーです.");
        return;
    }

    if (value == null) {
        System.out.println("値が設定されていません.");
        return;
    }

    if (!value.equals("first")
            && !value.equals("second")) {

        System.out.println("値が不正です.");
        return;
    }

    System.out.println("メイン処理です.");
}
```

### 2. さらに外部メソッドに切り出す

さらに、value のチェックをする処理を別メソッドに切り分けてみます。

```java title=例②：リファクタリング.2.valueのチェック処理を外部化
public class CheckProcesses {
    public static void main(String[] args) {

        CheckProcesses app = new CheckProcesses();

        boolean isError = false;
        String value = "third";
        app.execute(isError, value);
    }

    public void execute(boolean isError, String value) {
        if (isError) {
            System.out.println("エラーです.");
            return;
        }
        if (!isValid(value)) {
            return;
        }

        System.out.println("メイン処理です.");
    }

    private boolean isValid(String value) {
        if (value == null) {
            System.out.println("値が設定されていません.");
            return false;
        }
        if (!value.equals("first")
                && !value.equals("second")) {

            System.out.println("値が不正です.");
            return false;
        }
        return true;
    }
}
```

例 ②：チェック処理のリファクタリング後  
https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/03.primary/05.is-that-else-statement-necessary/src/CheckProcesses.java

```txt title=例②：実行結果
値が不正です.
```

## 例 ③：単純な else

単純な else の場合、三項演算子で書くと、すっきり読みやすくなる場合があります。

次の例は、配列の要素を 1 つずつチェックしていき、チェック結果を格納する配列に、
偶数なら「even」を、奇数なら「odd」を入れていく処理です。

```java title=例③：単純なelse
int[] targets = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, };
String[] results = new String[targets.length];

for (int i = 0; i < targets.length; i++) {
    if (targets[i] % 2 == 0) {
        results[i] = "even";

    } else {
        results[i] = "odd";
    }
}

for (int i = 0; i < targets.length; i++) {
    System.out.printf(
        "%d => %s %n",
        targets[i], results[i]
    );
}
```

### 三項演算子に置き換える

この処理を三項演算子に置き換えてみます。

```java title=例③：三項演算子に置き換える
public class TernaryOperator {
    public static void main(String[] args) {

        int[] targets = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, };
        String[] results = new String[targets.length];

        for (int i = 0; i < targets.length; i++) {

            results[i] =
                targets[i] % 2 == 0 ? "even" : "odd";
        }

        for (int i = 0; i < targets.length; i++) {
            System.out.printf(
                "%d => %s %n",
                targets[i], results[i]
            );
        }
    }
}
```

例 ③：三項演算子に置き換える  
https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/03.primary/05.is-that-else-statement-necessary/src/TernaryOperator.java

```txt title=例③：実行結果
0 => even
1 => odd
2 => even
3 => odd
4 => even
5 => odd
6 => even
7 => odd
8 => even
9 => odd
```

## まとめ：else 文をなくすこと

ただひたすら、「こういう場合はこう」という if 文を書き連ねていくイメージです。

「そうじゃなくて、こうだったらこうする」とか「それ以外はこうする」とかをなくした方が、
処理自体の見通しは良くなります。

単純な else で代入を切り替える場合は、三項演算子の使用も検討しましょう。

## ミニ課題: ガード節を使う（時間: 20 分）

以下の else 文を不要にするように、ガード節を使ってリファクタリングしなさい

```java title=src/GuardClause.java
public class GuardClause {
    public static void main(String[] args) {

        int[] targets = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, };
        String[] results = new String[targets.length];

        for (int i = 0; i < targets.length; i++) {
            if (targets[i] % 2 == 0) {
                results[i] = "even";

            } else {
                results[i] = "odd";
            }
        }

        for (int i = 0; i < targets.length; i++) {
            System.out.printf(
                "%d => %s %n",
                targets[i], results[i]
            );
        }
    }
}
```

```txt title=GuardClauseの実行結果
0 => even
1 => odd
2 => even
3 => odd
4 => even
5 => odd
6 => even
7 => odd
8 => even
9 => odd
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/03.primary/05.is-that-else-statement-necessary/src/GuardClause.java
