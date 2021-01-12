## 学習

### 3 種類の関係: Is-A/Has-A/Part-OF

クラス間の関係を判別する方法として、Is-A/Has-A 判定があります。

Is-A/Has-A 判定では、以下の 3 つの関係性のうち、どれに当てはまるのかを判定します。

- Is-A
- Has-A
- Part-Of

IS-A や HAS-A がそれぞれ何をあらわすのか Web で調べてください。
検索キーワードは、「 [java is-a has-a](https://www.google.com/search?q=java+is-a+has-a) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、「Is-A」「Has-A」「Part-Of」がそれぞれ何かをつかみましょう。

### 継承、関連、集約、コンポジションと比べる

この「Is-A」「Has-A」「Part-Of」に継承、関連、集約、コンポジションを当てはめると次のようになります。

<table border="3">
  <thead>
    <tr>
      <th colspan="3">関連 Assosiation</th>
    </tr>
    <tr>
      <th>Is-A</th>
      <th>Has-A</th>
      <th>Part-Of</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>継承 Inheritance</td>
      <td>集約 Aggregation</td>
      <td>構成 Composition</td>
    </tr>
  </tbody>
</table>

### Is-A の関係

Java では、Is-A 関係は継承です。

この場合の継承には、クラス継承とインターフェイス継承の 2 つのタイプが含まれます。
これは、Java でのコードの再利用性に使用されます。

たとえば、ジャガイモは野菜、バスは乗り物、電球は電子機器などです。

継承の特性の 1 つは、関係が一方向であるということです。

家は建物だとは言えます。ところが、これを逆方向に言うことはできません。
なぜなら、すべての建物が家であるわけではありません。

Java では Is-A 関係を簡単に判別できます。Java のクラス宣言に extends または implement キーワードがある場合、特定のクラスは Is-A 関係に従っていると言われます。

### Has-A の関係

Java では、Has-A 関係は集約（Aggregation）とも呼ばれます。

また、Java でのコードの再利用性にも使用されます。
Has-A 関係は、あるクラスのインスタンスが別のクラスのインスタンスまたは同じクラスの他のインスタンスへの参照を持っていることを意味します。

たとえば、車にはエンジンがあり、犬には尻尾があります。

Java には、Has-A 関係を実装するようなキーワードはありません。

### Part-Of の関係

Java では、Part-Of の関係は構成（Composition）とも呼ばれます。

Part-Of の関係も、大きな視点で見れば Has-A の関係になります。

Part-Of は制限された形式の集約です。構成では、2 つのエンティティは相互に大きく依存しています。一方のエンティティは、もう一方なしでは存在できません。

たとえば、人間には手や足がありますが、手や足はそれのみでは存在できません。ディレクトリとファイルの関係もこれにあたります。

## 練習問題（時間: 20 分）

バイクとスクーターが Is-A 関係になるように、スクーターとエンジンが HAS-A 関係になるように、次の 3 つのクラスを作成しなさい

なお、3 つのクラスを以下の ComputerScienceCulture クラスで実行すると、実行結果の通りになること

1. Bike クラス
2. Scooter クラス
3. Engine クラス

### ScooterUser.java

```java
package advanced.relationship;

import advanced.relationship.entity.Scooter;

public class ScooterUser {
    public static void main(String[] args) {
        Scooter myScooter = new Scooter();
        myScooter.setColor("BLACK");
        myScooter.setMaxSpeed(136);
        myScooter.showBikeInfo();
        myScooter.driveStart();
        myScooter.driveStop();
    }
}
```

### ScooterUser.java の実行結果

```console
バイクの色: BLACK, 最高速度: 136km
Engine started.
Engine stopped.
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/05.advanced/08.is-a-has-a-part-of/src/advanced/relationship
