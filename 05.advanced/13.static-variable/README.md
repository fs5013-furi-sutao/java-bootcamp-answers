## 学習

### Static 変数を知る

Static 変数は何かを Web で調べてください。
検索キーワードは、「 [java static 変数](https://www.google.com/search?q=java+static+変数) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、Static 変数とは何か、Static 変数の使い方をつかみましょう。

## Static フィールド（またはクラス変数）

Java では、フィールドが Static として宣言されている場合、そのフィールドのコピーが 1 つだけ作成され、そのクラスのすべてのインスタンス間で共有されます。

クラスを何回初期化するかは関係ありません。それに属する Static フィールドのコピーは常に 1 つだけです。
この Static フィールドの値は、異なるクラスの同じオブジェクトのすべてのオブジェクトで共有されます。

メモリの観点から、Static 変数は Metaspace と呼ばれる JVM メモリ内の特定のプールに配置されます
（Java 8 より前は、このプールは Permanent Generation または PermGen と呼ばれていましたが、今ではその呼び名は完全に削除されて Metaspace となりました）。

## Static フィールドが必要になるケース

- 変数の値がオブジェクトから独立している場合
- 値がすべてのオブジェクト間で共有されることになっている場合

### 参考: 覚えておくべきキーポイント

- Static 変数はクラスに属し、それらはクラス名を使用して直接アクセスすることができ、オブジェクト参照を必要としない
- Static 変数はクラスレベルでのみ宣言できる
- Static フィールドには、オブジェクトの初期化なしでアクセスできる
- オブジェクト参照を使用して Static フィールドにアクセスできるが、この場合、インスタンス変数かクラス変数かを判断するのが難しくなるため、使用を控えるべき。代わりに、常にクラス名を使用して Static 変数を参照するべき

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
