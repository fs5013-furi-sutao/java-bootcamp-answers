## 学習

### マジックナンバーを知る

マジックナンバーとは何か、マジックナンバーは何がいけないのか、
Java でマジックナンバーを排除する方法を Web で調べてください。
検索キーワードは、「 [java マジックナンバー](https://www.google.com/search?q=java+マジックナンバー) 」です。

3 種類ぐらい説明記事やサンプルコードを読んで、
マジックナンバーの何がいけないのかを知り、マジックナンバーを排除する方法つかみましょう。

### 標準 API でマジックナンバーを排除している例

例えば Math クラスの円周率も、マジックナンバーを定数によって回避しています。

```java
double pi = Math.PI;
System.out.println(pi);
```

```txt title=実行結果
3.141592653589793
```

Integer クラスでも最大値や最小値を定数管理しています。

```java
int minInt = Integer.MIN_VALUE;
int maxInt = Integer.MAX_VALUE;
System.out.printf("int 型の最小値 = %11d %n", minInt);
System.out.printf("int 型の最大値 = %11d %n", maxInt);
```

```txt title=実行結果
int 型の最小値 = -2147483648
int 型の最大値 =  2147483647
```

## 例えば、支払方法をチェックする処理

悪いコードの例です。以下のようなチェックがあったとします。

```java
if (paymentType == 1) {
    // process payment
}
```

この「1」がマジックナンバーです。

この「1」を見ただけでは、「1」が何を意味しているのか分かりません。
他の処理を読み込んで推測したり、場合によっては仕様書を読まないと分からないかもしれません。

一旦、自分が書き上げたコードを自己レビューする時は、
こういった「1」のようなリテラルをハードコーディングしている箇所があれば、
「あれ？」と気づく感覚が必要です。

### 修正方法 1. 定数にする

最も単純なマジックナンバーの修正方法は、定数に置き換えることです。

```java
final int CREDIT = 1;

if (paymentType == CREDIT) {
    // process payment
}
```

これで一応、何をチェックしているかの意図は伝わります。

### 修正方法 2. Enum にする

列挙型を使うと、さらに支払方法の管理がしやすくなります。

```java
public enum PaymentType {
  CREDIT, DEBIT, CASH, CHECK
}

if (paymentType == PaymentType.CREDIT)  {
    // process payment
}
```

## ミニ課題（時間: 20 分）

列挙型「Gender」を作成し、マジックナンバーを列挙型に修正（リファクタリング）しなさい

```java title=src/AntiMagicNumber.java
public class AntiMagicNumber {
    public static void main(String[] args) {

        int gender = 2;

        if (gender == 2) {
            System.out.println("私は 女 です.");
        }
    }
}
```

```txt title=AntiMagicNumberの実行結果
私は 女 です.
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/03.primary/27.array/src/AntiMagicNumber.java
