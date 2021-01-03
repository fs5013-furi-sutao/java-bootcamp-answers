## ミニ課題: メソッドの抽出（時間: 20 分）

以下のクラス SquarePrinter について、次の 6 つのメソッドを切り出しなさい

### 1. inputLine メソッド

文字入力を受け付けて結果を返す

### 2. isInputOneChar メソッド

入力値が一文字かどうかを確認した結果を返す

### 3. showNotInputOneChar メソッド

入力値が一文字ではなかった場合にメッセージを表示する

### 4. isWidthValid メソッド

入力値が指定内の幅として適正値かどうかを確認した値を返す

### 5. showNotWidthValid メソッド

入力値が指定内の幅として適正値ではなかった場合にメッセージを表示する

### 6. printSquare メソッド

入力された一文字で、入力された幅の正方形を表示する

```java title=src/SquarePrinter.java
import java.util.Scanner;

public class SquarePrinter {

    private static Scanner stdin = new Scanner(System.in);
    private static final int MAX_WIDTH = 9;

    public static void main(String[] args) {

        String strCharInput = "";

        while (strCharInput.length() != 1) {
            System.out.print("一文字入力してください: ");
            strCharInput = stdin.nextLine();

            if (strCharInput.length() != 1) {
                System.out.println(
                    " => 一文字ではありません."
                );
            }
            System.out.println();
        }

        char charToDraw = strCharInput.charAt(0);

        String strWidthInput = "";

        boolean isValid = false;
        int intWidth = 0;

        while (!isValid) {
            System.out.printf(
                "幅（1 ～ %d）を入力してください: ",
                MAX_WIDTH
            );

            strWidthInput = stdin.nextLine();

            try {
                intWidth = Integer.parseInt(strWidthInput);
            } catch (NumberFormatException e) {
                System.out.println(" => 値が不正です.");
                System.out.println();
                continue;
            }

            if (intWidth <= 0 || intWidth > MAX_WIDTH) {
                System.out.println(" => 値が不正です.");
                System.out.println();
                continue;
            }
            isValid = true;
            System.out.println();
        }

        for (int i = 0; i < intWidth; i++) {

            for (int j = 0; j < intWidth; j++) {
                System.out.print(charToDraw);
            }
            System.out.println();
        }

        stdin.close();
    }
}
```

```txt title=SquarePrinterクラスの実行結果
一文字入力してください: ee
 => 一文字ではありません.

一文字入力してください: @

幅（1 ～ 9）を入力してください: e
 => 値が不正です.

幅（1 ～ 9）を入力してください: 0
 => 値が不正です.

幅（1 ～ 9）を入力してください: 10
 => 値が不正です.

幅（1 ～ 9）を入力してください: 5

@@@@@
@@@@@
@@@@@
@@@@@
@@@@@
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/03.primary/07.cut-out-processes-into-method/src/SquarePrinter.java
