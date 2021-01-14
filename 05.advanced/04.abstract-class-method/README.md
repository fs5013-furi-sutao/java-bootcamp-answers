## 学習

### abstract クラス、abstract メソッドを知る

abstract クラス、abstract メソッドとは何かを Web で調べてください。
検索キーワードは、「 [java abstract](https://www.google.com/search?q=java+abstract) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、abstract クラス、abstract メソッドとは何か、その使い方をつかみましょう。

### 抽象クラス

abstract クラスは、抽象クラスとも呼ばれます。

抽象クラスとは、抽象的に宣言されたクラスのことで、
抽象的なメソッドを含んでいてもよいし、含んでいなくてもよいという意味です。

抽象クラスはインスタンス化できませんが、サブクラス化は可能です。

#### 抽象クラスの定義ルール

Java で抽象クラスを定義する場合のルールをまとめておきます。

1. 抽象クラスは直接インスタンス化することはできない
2. 抽象クラスは、ゼロ以上の任意の数の抽象メソッド、および具象メソッドを定義することができる
3. 抽象クラスは、private または final として定義することはできない
4. 別の抽象クラスを拡張した抽象クラスは、その抽象メソッドがすべて自分の抽象メソッドとして継承される
5. ある抽象クラスを継承する最初の具象クラスは、継承したすべての抽象メソッドの実装しなければならない

#### 抽象クラスの定義例

では、実際の抽象クラスを使ってみます。

#### AbstractClassDemo.java

```java
package advanced.abstracts.demo;

public class AbstractClassDemo {

    public static void main(String[] args) {

        Animal cat = new Cat("ドラネコ");
        cat.eat();
        cat.sound();

        Animal dog = new Dog("ポチ");
        dog.eat();
        dog.sound();
    }
}

abstract class Animal {

    private String name;

    protected Animal(String name) {
        this.name = name;
    }

    // 継承するすべてのクラスが持つ標準のメソッド
    public void eat() {
        System.out.format(
                "%s が食べる .......... %n", this.name
            );
    }

    // 継承するクラスに実装を強制する
    abstract void sound();
}

class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    void sound() {
        System.out.println("にゃあ にゃあ ........");
    }
}

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    void sound() {
        System.out.println("わん わん ........");
    }
}
```

#### AbstractClassDemo.java の実行結果

```console
ドラネコ が食べる ..........
にゃあ にゃあ ........
ポチ が食べる ..........
わん わん ........
```

抽象クラスの定義例  
https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/05.advanced/04.abstract-class-method/src/advanced/abstracts/demo/AbstractClassDemo.java

### 抽象メソッド

abstract メソッドは、抽象メソッドとも呼ばれます。
抽象メソッドとは、具体的な処理を実装をせずに宣言されたメソッドのことです。

#### 抽象メソッドの定義ルール

Java で抽象メソッドを定義する場合のルールをまとめておきます。

- クラスに抽象メソッドが含まれている場合は、クラス自体が抽象宣言されていなければならない
- 抽象メソッドは、抽象クラスでのみ定義できる
- 抽象メソッドは、private または final として宣言することはできない
- 抽象メソッドは、宣言された抽象クラスでメソッドの具体的な処理を実装できない
- サブクラスでの抽象メソッドの実装は、メソッドをオーバーライドする場合と同じルールに従う

#### 抽象クラスをサブクラス化する場合

サブクラスは通常、親クラスのすべての抽象メソッドを実装しなければいけません。
しかし、サブクラスも抽象クラスである場合、親クラスの抽象メソッドは、サブクラスでも抽象化しなければなりません。

```java
/**
 * 哺乳類をあらわす抽象クラス
 */
abstract class Mamal {
    abstract void sound();
}

abstract class Animal extends Mamal {

    @Override
    abstract void sound();
}
```

#### 抽象クラスがインタフェースを実装する場合

インタフェースを実装したクラスを作成する場合、インタフェースのメソッドをすべて実装しなければなりません。

しかし、クラスが抽象クラスであれば、インタフェースのメソッドをすべて実装することは強制されません。

##### AbstractImplementsInterfaceDemo.java

インタフェースを実装する抽象クラスを例で見てみます。

```java
package advanced.abstracts.interf;

interface SuperInterface {
    void a();

    void b();

    void c();

    void d();
}

abstract class AbstractClassImplementsInterface
        implements SuperInterface {

    public void a() {
        System.out.println("I am a");
    }
}

class ConcreteClass
        extends AbstractClassImplementsInterface {

    public void b() {
        System.out.println("I am b");
    }

    public void c() {
        System.out.println("I am c");
    }

    public void d() {
        System.out.println("I am d");
    }
}

public class AbstractImplementsInterfaceDemo {

    public static void main(String args[]) {

        final SuperInterface concrete =
            new ConcreteClass();

        concrete.a();
        concrete.b();
        concrete.c();
        concrete.d();
    }
}
```

抽象クラスがインタフェースを実装する場合  
https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/05.advanced/04.abstract-class-method/src/advanced/abstracts/interf/AbstractImplementsInterfaceDemo.java

## 実プロジェクトでの抽象クラスの使用例

### 従業員/契約社員/正社員の例

![ER図](./er_diagram_employee.png)

この例では、抽象的な Employee クラスを作成し、そのクラスには 抽象メソッド calculateSalary() が含まれています。
そしてサブクラスが Employee クラスを拡張して、calculateSalary() メソッドを実装します。

サブクラスは、Contractor クラス（正社員）と FullTimeEmployee クラス（正社員）です。

契約社員と正社員の給与構造が異なることを知っているので、これらのクラスをオーバーライドして calculateSalary() メソッドを実装します。

### Step 1: Employee 抽象クラス

まず、Employee という名前の抽象スーパークラスを作成してみましょう。

この抽象クラスの Employee に、calculateSalary()というメソッドを抽象メソッドとして定義します。
つまり、このメソッドは抽象化されているので、このメソッドの実装は Employee クラスの継承者に任せることができます。

```java
package advanced.abstracts.employee.entity;

public abstract class Employee {

    private String name;
    private int paymentPerHour;

    protected Employee(String name, int paymentPerHour) {
         this.name = name;
         this.paymentPerHour = paymentPerHour;
    }

    public abstract int calculateSalary();
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPaymentPerHour() {
       return paymentPerHour;
    }
    public void setPaymentPerHour(int paymentPerHour) {
        this.paymentPerHour = paymentPerHour;
    }
}
```

### Step 2: Contractor 具象クラス

Contractor クラスは、親の Employee からすべてのプロパティを継承しますが、
calculateSalary() メソッドには独自の実装を提供する必要があります。
この場合、与えられた労働時間に時間当たりの支払いの値を乗算します。

```java
package advanced.abstracts.employee.entity;

public abstract class Employee {

    private String name;
    private int paymentPerHour;

    protected Employee(String name, int paymentPerHour) {
        this.name = name;
        this.paymentPerHour = paymentPerHour;
    }

    public abstract int calculateSalary();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPaymentPerHour(int paymentPerHour) {
        this.paymentPerHour = paymentPerHour;
    }

    public int getPaymentPerHour() {
        return paymentPerHour;
    }
}

```

### Step 3: FullTimeEmployee 具象クラス

FullTimeEmployee には computeSalary() メソッドの独自の実装があります。
この場合は、8 時間という定数値（定時:REGULAR_TIME）を乗算するだけです。

```java
package advanced.abstracts.employee.entity;

public class FullTimeEmployee extends Employee {

    private static final int REGULAR_TIME = 8;

    public FullTimeEmployee(
            String name, int paymentPerHour) {

        super(name, paymentPerHour);
    }

    @Override
    public int calculateSalary() {
        return getPaymentPerHour() * REGULAR_TIME;
    }
}
```

### Step 4: 抽象クラスの動作確認

抽象クラスをテストするデモクラスを実行してみます。

```java
package advanced.abstracts.employee;

import advanced.abstracts.employee.entity.Contractor;
import advanced.abstracts.employee.entity.Employee;
import advanced.abstracts.employee.entity.FullTimeEmployee;

public class AbstractClassDemo {

    public static void main(String[] args) {

        Employee[] employees = {
                new Contractor("契約社員の山本一郎", 1000, 10),
                new FullTimeEmployee("正社員の山田太郎", 800),
        };

        for (Employee employee : employees) {

            System.out.format(
                    "[%s] 給料: %d 円 %n",
                    employee.getName(),
                    employee.calculateSalary()
                );
        }
    }
}
```

#### AbstractClassDemo.java の実行結果

```console
[契約社員の山本一郎] 給料: 10000 円
[正社員の山田太郎] 給料: 6400 円
```

従業員/契約社員/正社員での抽象クラスの例  
https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/05.advanced/04.abstract-class-method/src/advanced/abstracts/interf/AbstractImplementsInterfaceDemo.java

## まとめ

最後に抽象クラスの概略をまとめます。

- 抽象クラスとは、抽象キーワードで宣言されたクラスのこと
- 抽象メソッドとは、実装を持たずに宣言されたメソッドのこと
- 抽象クラスはすべての抽象メソッドを持っていても良いが、持っていなくても良い。その中には、具体的なメソッドになるものもある
- 抽象的に定義されたメソッドは、常にサブクラス内で再定義されなければならないので、オーバーライドが必須になるか、サブクラス自体を抽象化しなければならない
- 1 つ以上の抽象メソッドを含むクラスは、抽象キーワードで宣言しなければならない
- 抽象クラスのオブジェクトは存在しない。つまり、抽象クラスは、new 演算子を使って直接インスタンス化することはできない
- 抽象クラスはパラメータ化されたコンストラクタを持つことができ、デフォルトのコンストラクタは常に抽象クラスに存在する

## 練習問題（時間: 20 分）

次のクラス PetShop を実行すると、実行結果の通りになるように次の 3 つのクラスと 1 つのインタフェースを作成しなさい

1. Barkable.java 鳴く能力をあらわすインタフェース
2. Animal.java 動物をあらわす抽象クラス
3. Cat.java ネコクラス
4. Rabbit.java ウサギクラス

### PetShop.java

```java
package advanced.abstracts.animal;

import advanced.abstracts.animal.entity.Animal;
import advanced.abstracts.animal.entity.Barkable;
import advanced.abstracts.animal.entity.Cat;
import advanced.abstracts.animal.entity.Rabbit;

public class PetShop {

    private static final boolean MALE = true;
    private static final boolean FEMALE = false;

    public static void main(String[] args) {

        Animal[] pets = {
                new Rabbit(
                        "スキウサギ",
                        FEMALE
                    ),

                new Cat(
                        "どらねこ",
                        MALE
                    ),
            };

        for (Animal pet : pets) {
            System.out.println(pet.toString());
            pet.eat();
            pet.bark();
            System.out.println();
        }

        pets[0].changeName("ツキウサギ");
        System.out.println(pets[0].toString());
        pets[0].eat();

        Barkable rabbit = pets[0];
        rabbit.bark();
    }
}
```

### PetShop.java の実行結果

```console
名前=スキウサギ::性別=メス::食性=草食
スキウサギ は 草食 ........草を食べた ........
みゅー みゅー ........

名前=どらねこ::性別=オス::食性=肉食
どらねこ は 肉食 ........魚を食べた ........
にゃあ にゃあ ........

名前=ツキウサギ::性別=メス::食性=草食
ツキウサギ は 草食 ........草を食べた ........
みゅー みゅー ........
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/05.advanced/04.abstract-class-method/src/advanced/abstracts/animal
