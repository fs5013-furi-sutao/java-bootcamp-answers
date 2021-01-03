## 1 つのメソッドには 1 つの役割にする理由

メソッドを切り出すと時に気を付けたいことは、
1 つのメソッドには 1 つの役割を持つようにさせることです。

1 つのメソッドに 1 つの役割のみを与えることを徹底することで
メソッド名が明快になります。

なぜなら、そのメソッドの役割をメソッド名に込めればいいわけですから。

そして、メソッド名を明快にした、役割が単一となったメソッドにすることで、
以下のようなメリットが生まれます。

- 処理が読みやすくなる
- 処理の再利用がしやすくなる
- エラーがなくなる（想定外の処理がされないため）
- 単体テストがしやすくなる

## メソッド名が重要

メソッドを 1 つの役割に限定させるには、いかにメソッド名を付けるかが重要になります。

例えば、`createOrder()` と付ければ、メソッドの役割は、注文を作成することになります。

例えば、`renderCustomerInfo()` と名付ければ、
顧客情報を整形して表示するのが、メソッドの役割になります。

## 役割を分割する例

例えば、借入明細書を表示するプログラムがあったとしたら、
以下のようにリファクタリングして、1 つの役割でメソッドを外部化します。

```java title=リファクタリング前
/**
 * 借入明細の表示
 */
void printOwing() {
    printHeader();
    // 明細の表示
    System.out.printf("name: %s %n", name);
    System.out.printf(
        "amount: %f %n",
        getOutstanding()  // 未払い金
    );
}
```

```java title=リファクタリング後
/**
 * 借入明細の表示
 */
void printOwing() {
    printHeader();
    printDetails(getOutstanding());
}

/**
 * 明細の表示
 * @param outstanding 未払い金
 */
void printDetails(double outstanding) {
    System.out.printf("name: %s %n", name);
    System.out.printf("amount: %f %n", outstanding);
}
```

## ミニ課題（時間: 20 分）

以下のクラス StatusReader について、次の処理をメソッドに切り出しなさい

### 1. hasError メソッド

ステータスとエラーメッセージの判定条件式を外部メソッドにする

### 2. showErrorMessage メソッド

エラーメッセージの表示部分を外部メソッド化する

```java
public class StatusReader {

    enum StatusType {
        WAIT, PROGRESS, DONE, KEEP, PROBLEM,
    }
    public static void main(String[] args) {

        // 1回目
        String errorMessage = "読み込みエラー";
        StatusType status = StatusType.PROGRESS;

        if(status == StatusType.KEEP
                || status == StatusType.PROBLEM
                || errorMessage != null) {

            System.out.println("エラーです.");
            if (errorMessage != null) {
                System.out.printf(" => %s %n", errorMessage);
            }
            System.out.println();
        }

        // 2回目
        errorMessage = null;
        status = StatusType.DONE;

        if(status == StatusType.KEEP
                || status == StatusType.PROBLEM
                || errorMessage != null) {

            System.out.println("エラーです.");
            if (errorMessage != null) {
                System.out.printf(" => %s %n", errorMessage);
            }
            System.out.println();
        }
    }
}
```

```txt title=StatusReaderクラスの実行結果
エラーです.
 => 読み込みエラー

```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/03.primary/09.a-method-has-only-one-function/src/StatusReader.java
