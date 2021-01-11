## 学習

### Java のパッケージ構成ルールを知る

Java のパッケージとは何かを Web で調べてください。検索キーワードは、「 [java パッケージ](https://www.google.com/search?q=java+パッケージ) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、Java におけるパッケージとは何か、Java のパッケージのルールなどをつかみましょう。

## 練習問題（時間: 20 分）

次の 3 つのクラスについて、freestyles.jp ドメインを元に、積荷業務（Cargo）としてパッケージ構成を組み立てなさい

また、Employee クラスと Division クラスは Entity パッケージとして同梱すること

1. Business クラス
2. Employee クラス
3. Division クラス

### 1. Business.java

```java
package mid.javadoc;

public class Business {
    public static void main(String[] args) {


        Division division = new Division()
                .id(7)
                .name("ゲーム事業部");

        Employee employee = new Employee()
                .id(777)
                .name("山本一郎")
                .age(171)
                .division(division);

        employee.showDetails();
    }
}

```

### 2. Employee.java

```java
package mid.javadoc;

public class Employee {
    
    private int id;
    private String name;
    private int age;
    private Division division;

    public Employee id(int id) {
        this.id = id;
        return this;
    }

    public void showDetails() {
        System.out.printf(
                "従業員ID:%d %s（%d 歳）さんは、%s 所属です. %n",
                this.id,
                this.name,
                this.age,
                this.division.toString()
            );
    }

    public Employee name(String name) {
        this.name = name;
        return this;
    }

    public Employee age(int age) {
        this.age = age;
        return this;
    }

    public Employee division(Division division) {
        this.division = division;
        return this;
    }
}
```

### 3. Division.java

```java
package mid.javadoc;

public class Division {
    
    private int id;
    private String name;

    public Division id(int id) {
        this.id = id;
        return this;
    }

    public Division name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        
        return String.format(
                "部署ID:%d の %s",
                this.id,
                this.name
            );
    }
}
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/04.mid/21.package/src
