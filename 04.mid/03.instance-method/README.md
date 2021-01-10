## 学習

### Java のインスタンスメソッド

Java のインスタンスメソッドとは何かを Web で調べてください。検索キーワードは、「 [java インスタンスメソッド](https://www.google.com/search?q=java+インスタンスメソッド) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、Java のインスタンスメソッドとは何か、インスタンスメソッドの使い方をつかみましょう。

## 練習問題 01: リファクタリング（時間: 20 分）

次の 2 つのクラスについて、Dog インスタンスの詳細を表示する処理をインスタンスメソッドにするよう、リファクタリングしなさい

### DogOwner.java

```java
package mid.instance.method;

import java.util.ArrayList;
import java.util.List;

public class DogOwner {
    public static void main(String[] args) {

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("秋田賢", 7, "秋田犬"));
        dogs.add(new Dog("山本一郎", 1, "プードル"));
        dogs.add(new Dog("山田太朗", 2, "チワワ"));

        for (Dog dog : dogs) {
            System.out.printf("%s の %s は %d 歳です. %n",
                dog.getDogType(),
                dog.getName(),
                dog.getAge()
            );
        }
    }
}
```

### Dog.java

```java
package jp.freestyles.mid.instance.method;

public class Dog {

    private String name;
    private int age;
    private String dogType;

    public Dog(
        String name,
        int age,
        String dogType) {

        this.name = name;
        this.age = age;
        this.dogType = dogType;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDogType() {
        return dogType;
    }
}
```

### DogOwner.java の実行結果

```console
秋田犬 の 秋田賢 は 7 歳です.
プードル の 山本一郎 は 1 歳です.
チワワ の 山田太朗 は 2 歳です.
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/04.mid/03.instance-method/src/mid/instance/method/dog

## 練習問題 02: 依存関係を持つインスタンスメソッド（時間: 20 分）

実行結果のようになる、次の 2 つのクラスを作成しなさい

1. HouseKeeper クラス
2. House クラス

### 1. HouseKeeper クラス

以下の処理を行う main メソッドを持つクラス

- 実行結果にあるような内容の House インスタンスを作成

  - 家主の名前: 山本一郎
  - 色: 赤
  - 住所: 愛知県名古屋市中区伏見 3-4-5

- ドアを閉める
- ドアを開く
- 詳細を表示する

### 2. House クラス

以下のフィールドを持つクラス

- 家主の名前: ownerName
- 色: color
- 住所: address
- ドアが開いているかどうか: isDoorOpen
- 今からドアを開けるところかどうか: isTryingToOpenDoorNow
- 今からドアを閉めるところかどうか: isTryingToCloseDoorNow

### HouseKeeper.java の実行結果

```console
山本一郎 さん家のドアを閉めます
 => [INFO] 既にドアは閉まってます
山本一郎 さん家のドアを開けます
山本一郎 さん家
 => 色: 赤
 => 住所: 愛知県名古屋市中区伏見 3-4-5
 => ドア: 開いてます
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/04.mid/03.instance-method/src/mid/instance/method/house
