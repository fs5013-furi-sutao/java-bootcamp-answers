## 学習

### ネストクラス・内部クラスを知る

ネストクラスや内部クラスとは何かを Web で調べてください。
検索キーワードは、「 [java ネストクラス 内部クラス](https://www.google.com/search?q=java+ネストクラス+内部クラス) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、ネストクラスや内部クラスとは何か、ネストクラスと内部クラスの使い方をつかみましょう。

### Static クラス

Java では、クラス内にクラスを作成できます。
これは、1 つの場所でのみ使用される要素をグループ化するための選択肢です。
これにより、コードをより整理して読みやすくすることができます。

ネストされたクラス設計は、次の 2 つに分けられます。

- **ネストクラス**: Static と宣言されたネストされたクラスは Static なネストされたクラスと呼ばれる
- **内部クラス**: Static ではないネストされたクラスは、内部クラスと呼ばれる

これら 2 つのおもな違いは、内部クラスはそれを囲むクラスのすべてのメンバー（private を含む）にアクセスできるのに対し、Static にネストされたクラスは外部クラスの Static メンバーにのみアクセスできることです。

実際、Static にネストされたクラスは、他のトップレベルクラスとまったく同じように動作しますが、パッケージ化の利便性を高めるために、それにアクセスする唯一のクラスで囲まれています。

## Static なネストクラスを使う理由

- 1 つの場所でのみ使用されるクラスをグループ化すると、カプセル化が増加する
- コードは、それを使用する唯一の場所に近づけられる。これにより読みやすさが向上し、コードがより保守しやすくなる
- ネストされたクラスが、それを囲むクラスインスタンスのメンバへのアクセスを必要としない場合は、Static と宣言した方が良い

### 参考: 覚えておくべきキーポイント

- Static にネストされたクラスは、それを囲む外部クラスのインスタンスメンバにアクセスできない。オブジェクトの参照からのみアクセスできる
- Static にネストされたクラスは、プライベートクラスを含む、囲んでいるクラスのすべての Static メンバーにアクセスできる
- Java の仕様では、最上位クラスを Static として宣言することができない。クラス内のクラス（ネストされたクラス）のみを Static として作成できる

## 練習問題（時間: 20 分）

次の EmployeeManager クラスを実行すると、実行結果の通りになるように、
ネストクラス Validator を持つ Employee クラスを作成しなさい

### EmployeeManager.java

```java
package advanced.nested.classes;

/**
 * static なネストクラスを呼び出すサンプル
 * @param args
 */
public class EmployeeManager {

    public static void main(String[] args) {

        Employee[] employees = {
                new Employee(
                        "01 名前のみ設定 一郎",
                        "",
                        ""),
                new Employee(
                        "02 メルアドなし 次郎",
                        "",
                        "愛知県名古屋市中区伏見 3-4-5"),
                new Employee(
                        "",
                        "03_john_doe@freestyles.jp",
                        "愛知県名古屋市中区伏見 3-4-5"),
                new Employee(
                        "04 住所なし 四郎",
                        "04_no_address@freestyles.jp",
                        ""),
        };

        Employee.Validator validator = new Employee.Validator();

        for (Employee employee : employees) {
            validator.showValidatedResult(employee);
        }
    }
}
```

### EmployeeManager.java の実行結果

```console
従業員ID 1 にメールアドレスが設定されていません.
従業員ID 2 にメールアドレスが設定されていません.
従業員ID 3 に名前が設定されていません.
従業員ID 4 は正しく設定されています.
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/05.advanced/15.nested-class/src/advanced/nested/classes
