## 学習

### Java における Getter と Setter の役割を知る

Java のメソッドには Getter と Setter と呼ばれるものがあります。
アクセサとも呼ばれます。

Java のオーバーロードとは何かを Web で調べてください。検索キーワードは、「 [java getter setter](https://www.google.com/search?q=java+getter+setter) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、Java のオーバーロードとは何か、オーバーロードの方法をつかみましょう。

## 練習問題（時間: 20 分）

実行結果の通りになるように、次の ChildHouse クラスで利用する Child クラスを作成しなさい

### ChildHouse.java

```java
package mid.accessor;

public class ChildHouse {
    public static void main(String[] args) {

        Child yamachan = new Child();

        yamachan.setName("山本一郎");
        yamachan.setAge(11);
        yamachan.showDetails();

        try {
            yamachan.setAge(-30);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        try {
            yamachan.setAge(30);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        System.out.printf(
                "%s => %d %n",
                yamachan.getName(),
                yamachan.getAge()
            );
    }
}
```

### ChildHouse.java の実行結果

```console
山本一郎 は 11 歳です.
java.lang.IllegalArgumentException: 年齢は正数で指定してください.
        at mid.accessor.Child.isPositiveAge(Child.java:54)
        at mid.accessor.Child.validAge(Child.java:34)
        at mid.accessor.Child.setAge(Child.java:29)
        at mid.accessor.ChildHouse.main(ChildHouse.java:13)
java.lang.IllegalArgumentException: 年齢は 18 未満で指定してください.
        at mid.accessor.Child.isNotAdult(Child.java:46)
        at mid.accessor.Child.validAge(Child.java:35)
        at mid.accessor.Child.setAge(Child.java:29)
        at mid.accessor.ChildHouse.main(ChildHouse.java:19)
山本一郎 => 11
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/04.mid/06.getter-and-setter/src/mid/accessor
