## 学習

### Getter/Setter のメリット

クラスに Getter や Setter を実装すると便利です。

なぜなら、どこのクラスからでも、そのインスタンスの値を取得したり、設定したりすることができるからです。
つまりそれは、どこからでもインスタンスを処理するロジックを、自由に組めることを意味します。

しかし、その自由度の高さは、裏返すと、同じようなロジックをそこら中に実装することが可能となる、というデメリットも含んでいます。

### Getter/Setter で外部にロジックが漏れ出すデメリット

同じようなロジックが、散在すると何がいけないのか？

例えば、「元号」を表すクラスがあるとしましょう。

大規模なシステムで、元号を取得して加算するロジックが 300 箇所あったらどうでしょうか？

元号を加算する方法（仕様）が変更になったら、えらいことになります。

その 300 箇所全部を変更しなければならないからです。

また、その 300 箇所全部について、変更した場合の影響を全部調べなければいけません。
さらに、変更漏れや、変更間違いによって、新たなバグを生んでしまう可能性もあります。

反対に、そもそも元号クラスに Getter/Setter がなく、加算処理もすべて元号クラスの中でやっていたらどうでしょうか？

加算処理に変更が必要となった場合でも、元号クラス内の加算処理を変更するだけで改修が完了します。

### 凝集度の高いプログラムへ

こうしたことから考えても、Getter/Setter は最小限に留めて実装すべきです。

もっといえば、Getter/Setter がなくても済むような設計をできる限り目指すべきです。

そうした、ロジックが外に流出しないプログラムの作り方を「凝集度の高いプログラム」と呼びます。

1 つのクラスに、そのクラスに必要なメソッドがまとまっている状態。それが凝集度の高いプログラムです。

## 練習問題（時間: 20 分）

次の 3 つのクラスについて、凝集度が高いプログラムになるようにリファクタリングしなさい

1. 従業員を表す Employee クラス
2. 部署を表す Division クラス
3. Employee クラスと Division クラスを利用する Business クラス

### 1. Employee.java

```java
package mid.minimize.accessor;

/**
 * 従業員クラス
 */
public class Employee {

    private int id;
    private String name;
    private int age;
    private Division division;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}
```

### 2. Division.java

```java
package mid.minimize.accessor;

/**
 * 部署クラス
 */
public class Division {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

### 3. Business.java

```java
package mid.minimize.accessor;

public class Business {
    public static void main(String[] args) {

        Division division = new Division();
        division.setId(7);
        division.setName("ゲーム事業部");

        Employee employee = new Employee();
        employee.setId(777);
        employee.setName("山本一郎");
        employee.setAge(171);
        employee.setDivision(division);

        System.out.printf(
                "従業員ID:%d %s（%d 歳）さんは、部署ID:%d の %s 所属です. %n",
                employee.getId(),
                employee.getName(),
                employee.getAge(),
                employee.getDivision().getId(),
                employee.getDivision().getName()
            );
    }
}
```

### Business.java の実行結果

```console
従業員ID:777 山本一郎（171 歳）さんは、部署ID:7 の ゲーム事業部 所属です.
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/04.mid/09.keep-getter-setter-to-minimize/src/mid/minimize/accessor
