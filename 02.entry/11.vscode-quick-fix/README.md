## ミニ課題（時間: 20 分）

以下のプログラム QuickFixTester.java を、VSCode の Quick Fix 機能を使って、コンパイルエラーを修正して、プログラムを実行できるようにしなさい

ただし、修正するにあたって Quick Fix 機能のみを使い、文字の削除・入力でコンパイルエラー部分を修正しないこと

```java title=src/QuickFixTester.java
public class QuickFixTester {
    public static void main(String[] args) {

        rand = new Random();
        myName = "山本一郎";
        boolean isLive = rand.nextBoolean();

        snowMessage(myName, isLive);
    }

    private static void showMessage(String name, boolean isLive) {
        if (isLive) {
            System.out.println("%s は生きてるよ.", name);
        } else {
            System.out.println("%s は死んでるよ.", name);
        }
    }
}
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/11.vscode-quick-fix/src/QuickFixTester.java
