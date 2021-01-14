## 学習

### ジェネリクスを知る

Java におけるジェネリクスを Web で調べてください。
検索キーワードは、「 [java ジェネリクス](https://www.google.com/search?q=java+ジェネリクス) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、ジェネリクスの使い方をつかみましょう。

## 練習問題（時間: 20 分）

以下の PetStore クラスを実行すると、実行結果の通りになるように、以下の 4 つのクラスを作成しなさい

1. Bird.java 鳥をあらわす抽象クラス
2. Eagle.java ワシをあらわすクラス
3. Pigeon.java ハトをあらわすクラス
4. Cage.java 鳥かごをあらわすクラス

```java
package master.generics;

public class PetStore {

    public static void main(String[] args) {

        Cage<Bird> birdCage = new Cage<>();
        birdCage.addBird(new Eagle("ハクトウワシ"));
        birdCage.addBird(new Pigeon("伝書鳩"));
        birdCage.addBird(new Eagle("オジロワシ"));

        for (Bird bird : birdCage.getBirds()) {
            bird.fly();
            bird.showDetails();
            System.out.println();
        }
    }
}
```

### PetStore.java の実行結果

```console
[Eagle] ハクトウワシ が飛んだ.
[Bird] 名前は ハクトウワシ です.

[Pigeon] 伝書鳩 が飛んだ.
[Bird] 名前は 伝書鳩 です.

[Eagle] オジロワシ が飛んだ.
[Bird] 名前は オジロワシ です.

```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/06.master/11.generics/src/master/generics
