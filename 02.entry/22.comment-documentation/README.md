## ミニ課題（時間: 20 分）

以下のクラス CommentTraining について、次に指定する 3 つのコメントを付与しなさい

1. クラスに複数行コメントで「コメントを付与する練習クラス」という記載と、コード作者情報
2. 1 行コメントで while 文に「不正な入力がある限りループ」という記載
3. 1 行コメントで、奇数かどうかの判定結果を表示する箇所に「入力値の判定結果」という記載

```java title=src/CommentTraining.java
import java.util.Scanner;

public class CommentTraining {
    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);

        int intInput = 0;
        String strInput = "";
        boolean isNotCorrectInput = true;

        System.out.print("数字を入力してください:");

        while (isNotCorrectInput) {
            strInput = stdin.nextLine();
            System.out.println();

            try {
                intInput = Integer.parseInt(strInput);

            } catch (NumberFormatException e) {
                System.out.println("入力が数字ではありませんでした.");
                System.out.print("数字を入力してください:");
                continue;
            }

            isNotCorrectInput = false;
        }

        boolean isOddInput = isOddInput(intInput);

        if (isOddInput)
            System.out.printf("%d は奇数です.", intInput);
        if (!isOddInput)
            System.out.printf("%d は奇数ではありません.", intInput);

        stdin.close();
    }

    /**
     * 奇数であるかを判定する
     * @param input
     * @return input が奇数であれば true / それ以外は false
     */
    private static boolean isOddInput(int input) {
        return input % 2 != 0;
    }
}
```

### CommentTraining の実行結果

1 回目の入力値: b
2 回目の入力値: 2

```
数字を入力してください:b

入力が数字ではありませんでした.
数字を入力してください:2

2 は奇数ではありません.
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/22.comment-documentation/src/CommentTraining.java
