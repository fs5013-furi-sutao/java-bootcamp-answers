## 学習

### Java の継承を知る

Java における継承とは何かを Web で調べてください。
検索キーワードは、「 [java 継承](https://www.google.com/search?q=java+継承) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、Java の継承とは何か、継承の実現方法をつかみましょう。

### 参考: 覚えておくべきキーポイント

1. 継承では、サブクラスがスーパークラスの変数やメソッドを引き継ぐため、コードの再利用は、継承の最も重要なメリットとなる

2. スーパークラスのプライベートメンバは、サブクラスには直接アクセスできない。
   必要に応じて、getter や setter メソッドを通して間接的にアクセスできるようにする

3. デフォルトのアクセス権を持つスーパークラスメンバーは、同じパッケージ内にある場合にのみサブクラスにアクセスできる

4. スーパークラスのコンストラクタはサブクラスに継承されない

5. スーパークラスにデフォルトのコンストラクタがない場合、サブクラスにも明示的なコンストラクタが定義されている必要がある。
   そうしないとコンパイル時に例外が発生する。
   この場合、サブクラスのコンストラクタでは、スーパークラスのコンストラクタへの呼び出しは必須であり、
   サブクラスのコンストラクタの最初のに記述しなければならない

6. Java は多重継承をサポートしていない。サブクラスは 1 つのクラスだけを拡張することができる。
   すべてクラスは暗黙のうちに Object クラスを拡張しており、Java の継承の性質上、サブクラスも Object クラスを拡張している

7. サブクラスのインスタンスを作成し、それをスーパークラス変数に代入することができる。
   例えば次の通りに、アップキャスティングできる

```java
Cat c = new Cat();
Animal a = c;
```

8. スーパークラスのインスタンスがサブクラス変数に代入されている場合、それをダウンキャストという。
   これをサブクラスに明示的にキャストする必要がある。例えば次の通りになる

```java
Cat c = new Cat();
Animal a = c;
Cat c1 = (Cat) a;
```

なお、明示的にキャストしているため、間違っていてもコンパイラーになることはないです。以下は、実行時に ClassCastException をスローする場合の例です。

```java
Dog dog = new Dog();
Animal animal = dpog;
Cat cat = (Cat) animal; // 実行時例外: ClassCastException
```

```java
Animal animal = new Animal();
Cat cat = (Cat) animal; // 実行時例外: ClassCastException
```

9. スーパークラスのメソッドをスーパークラスの中でオーバーライドすることができる。
   ただし、オーバーライドされたメソッドには必ず `@Override` アノテーションをつけるべき。
   コンパイラはメソッドをオーバーライドしていることを知っているので、スーパークラスのメソッドに何か変更があった場合、
   実行時に望まない結果を得るよりもコンパイル時にエラーが分かったほうが助かる

10. super キーワードを使って、スーパークラスのメソッドを呼び出したり、スーパークラスの変数にアクセスしたりすることができる。
    これは、サブクラスに同じ名前の変数・メソッドがあるが、スーパークラスの変数・メソッドにアクセスしたい場合に有効となる。
    また、スーパークラスとサブクラスでコンストラクタが定義されていて、スーパークラスのコンストラクタを明示的に呼び出さなければならない場合にも利用できる

11. オブジェクト間の継承を確認するには、次の例のように instanceof 命令を使用する

```java
Cat cat = new Cat();
Dog dog = new Dog();
Animal animal = cat;

boolean isCatInstance = cat instanceof Cat; // true
boolean isAnimalInstance = cat instanceof Animal; // true
isCatInstance = animal instanceof Cat; // true 実行時に Cat 型となるため
boolean isDogInstance = animal instanceof Dog; // false
```

12. Java では final クラスを継承することができない

13. もしコードの中でスーパークラスを使用しない場合、つまりスーパークラスが再利用可能なコードを保持するためのベースに過ぎない場合は、
    クライアントクラスによる不必要なインスタンス化を避けるために、それらを抽象クラスとして保持することができる。
    そうすることで、ベースクラスのインスタンス生成を制限することができきる

## 練習問題（時間: 20 分）

以下の Zoo クラスを実行すると、実行結果の通りになるように Animal クラスを継承した Dog クラスを作成しなさい

### Zoo.java

```java
package advanced.inheritance;

import advanced.inheritance.entity.Dog;

public class Zoo {
    public static void main(String[] args) {

        Dog labrador = new Dog();

        labrador.setName("ポチ");
        labrador.display();

        labrador.eat();
  }
}
```

### Animal.java

```java
package advanced.inheritance.entity;

public class Animal {

    private String name;

    public void eat() {
        System.out.println(
              "[Animal] 食べます .........."
          );
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }
}
```

### Zoo.java の実行結果

```console
[Dog] 名前は ポチ です.
[Animal] 食べます ..........
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/05.advanced/01.inheritance/src/advanced/inheritance
