## 学習

### 委譲を知る

Java の委譲とは何かを Web で調べてください。
検索キーワードは、「 [java 委譲](https://www.google.com/search?q=java+委譲) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、Java におけるう委譲とは何か、Java で委譲を実現するコーディング方法などをつかみましょう。

### クラスの性質を受け継ぐ 2 つの方法

対象のクラスの性質を受け継ぐ方法として、Java には次の 2 つの方法があります。

1. 継承
2. 委譲

#### 1. 継承（Inheritance）

「継承」は Java において言語的に用意されている機能です。

具体的には、extends キーワードを使い、対象のクラスに機能を追加した新しいクラスを作る方法です。

以下のように継承すれば、NewClass インスタンスでも Base オブジェクトの foo メソッドを使えるようになります。

```java
class Base {
    void foo();
    // ...
}

class NewClass extends Base {
    // ...
}
```

#### 2. 委譲（Delegation）

もう 1 つの方法、「委譲」は言語的な機能を使いません。
委譲は、コーディングによって対象のクラスの性質を利用する方法です。

以下のようにコーディングすれば、NewClass インスタンスの foo メソッドを呼び出すことで Base オブジェクトの foo メソッドと同じ処理をすることができます。

つまり、「委譲」の名前通り、NewClass インスタンスが、処理を Base オブジェクトにお任せするわけです。

```java
class NewClass {
    Base delegation = new Base();
    // ...
    void foo() {
        delegation.foo();
    }
}
```

### 継承と委譲の特長

継承と委譲のメリット・デメリットを以下にまとめます。

<table>
  <thead>
    <tr>
      <th>&nbsp;</th>
      <th>
        <p>クラスの継承（is-a関係）</p>
      </th>
      <th>
        <p>委譲（has-a関係）</p>
      </th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>
        <p>長所</p>
      </td>
      <td>
        <p>Javaの標準機能なので容易にコードの再利用が図れる</p>
      </td>
      <td>
        <p>2つのクラスは完全に分離している</p>
        <p>受け継ぎたい性質を選択できる</p>
      </td>
    </tr>
    <tr>
      <td>
        <p>短所</p>
      </td>
      <td>
        <p>親クラスを修正すると、その影響が子クラスに及ぶことがある</p>
        <p>受け継ぎたくない性質を拒否できない</p>
      </td>
      <td>
        <p>わざわざ別にインスタンスを生成しなければならない</p>
        <p>必要なメソッドはいちいち取り込まなければならない</p>
      </td>
    </tr>
  </tbody>
</table>

## 練習問題（時間: 20 分）

社長クラスが秘書クラスに処理を委譲するように、次の 3 つのクラス（インタフェース）を作成しなさい

なお、3 つのクラス（インタフェース）を以下の Company クラスで実行すると、実行結果の通りになること

1. Worker インタフェース
2. Secretary クラス
3. Boss クラス

### Company.java

```java
package advanced.delegation;

import advanced.delegation.worker.Boss;
import advanced.delegation.worker.Secretary;

public class Company {
    public static void main(String[] args) {
        Secretary secretary = new Secretary();

        Boss bossWithSecretary = new Boss();
        bossWithSecretary.callSecretary(secretary);
        bossWithSecretary.work();

        Boss bossWithNoSecretary = new Boss();
        bossWithNoSecretary.work();
    }
}
```

### Company.java の実行結果

```console
秘書が仕事をしました.
秘書がいません.
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/05.advanced/09.delegation/src/advanced/delegation
