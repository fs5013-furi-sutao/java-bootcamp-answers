## ミニ課題（時間: 20 分）

以下のプログラム AutoFormatter.java を、VSCode の自動整形機能を使って、コードを整形して、一般的なコード規約に沿った読みやすいコードに整えなさい

```java title=src/AutoFormatter.java
public class AutoFormatter {
    public static void main(String[] args) {

  int a[] = {66,12,10,43,45,52,73,65,2,39,97,76,83,11,57,63};
// aの内容を表示
    for (int i = 0; i < a.length; i++) {
System.out.print(a[i] + " ");
}
System.out.println();
        // バブルソート
    for (int e = a.length; e >= 2; e--) {
// 先頭から順に隣接する逆順要素を交換する
for (int i = 1; i < e; i++) {
if (a[i-1] > a[i]) {
// a[i]とa[i-1]を交換
    int w = a[i];
a[i] = a[i-1];
    a[i-1] = w;
}
}
              // aの内容を表示
      for (int i = 0; i < a.length; i++) {
  System.out.print(a[i] + " ");
    }
System.out.println();
}
    }
        }
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/10.vscode-auto-formatter/src/AutoFormatter.java
