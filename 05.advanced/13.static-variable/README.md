## 学習

### Static 変数を知る

Static 変数は何かを Web で調べてください。
検索キーワードは、「 [java static 変数](https://www.google.com/search?q=java+static+変数) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、Static 変数とは何か、Static 変数の使い方をつかみましょう。

## 練習問題（時間: 20 分）

次の ClassRoom クラスが実行結果の通りになるよう、Stataic 変数、Static メソッドを使って Student クラスを作成しなさい

### ClassRoom.java

```java
package advanced.variable;

public class ClassRoom {
    public static void main(String[] args) {

        Student[] students = {
                new Student().name("山本一郎").age(3),
                new Student().name("山下次郎").age(312),
                new Student().name("山口三郎").age(79),
                new Student().name("山田太郎").age(2),
            };

        students[0].showDetails();
        students[2].showDetails();
        students[3].showDetails();
    }
}
```

### ClassRoom.java の実行結果

```console
フリスタ大学 [生徒ID 1] 名前: 山本一郎, 年齢:  3 歳
フリスタ大学 [生徒ID 3] 名前: 山口三郎, 年齢: 79 歳
フリスタ大学 [生徒ID 4] 名前: 山田太郎, 年齢:  2 歳
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/05.advanced/13.static-variable/src/advanced/variable
