## 学習

### 匿名クラスを知る

匿名クラスとは何かを Web で調べてください。
検索キーワードは、「 [java 匿名クラス](https://www.google.com/search?q=java+匿名クラス) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、匿名クラスとは何か、匿名クラスの使い方をつかみましょう。

### 匿名クラス

Java では、クラスにネストされたクラスと呼ばれる別のクラスを含めることができます。名前を付けずにネストされたクラスを作成することは可能です。

名前のないネストされたクラスは、匿名クラスと呼ばれます。

匿名クラスは、別のクラス内で定義する必要があります。したがって、匿名内部クラスとしても知られています。その構文は次のとおりです。

#### 匿名クラスの構文

```java
class OuterClass {

    // 匿名クラスを定義する
    myObject = new Type(parameters) {
         // 処理
    };
}
```

匿名クラスは通常、サブクラスを拡張するか、インターフェイスを実装します。

上記の例では、 Type には以下のものを指定します。

- 匿名クラスが拡張するスーパークラス
- 匿名クラスが実装するインターフェース

上記のコードは、myObject 実行時に匿名クラスのオブジェクトを作成します。

> 匿名クラスは式内で定義されます。したがって、セミコロンは、式の終わりを示すために匿名クラスの終わりに使用します

次に、匿名クラスの実装パターンを 2 つ、見てみます。

## 例 1：クラスを拡張する匿名クラス

次の例はクラスのメソッドを匿名クラスでオーバーライドする例です。

プログラムを実行すると、匿名クラスのオブジェクト anonymousObj が作成されます。
そして、このオブジェクトは匿名クラスの display() メソッドを呼び出します。

```java
class Screen {
    public void display() {
       System.out.println("Inside the Polygon class");
    }
 }

class AnonymousClassWithClass {
    public void createClass() {

        Screen anonymousObj = new Screen() {

            @Override
            public void display() {
                System.out.println("[display()] 匿名クラスです.");
            }
        };
        anonymousObj.display();
    }
}

class AnonymousClassWithClassDemo {
    public static void main(String[] args) {
        AnonymousClassWithClass anonymousObj = new AnonymousClassWithClass();
        anonymousObj.createClass();
    }
}
```

クラスを拡張する匿名クラス  
https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/05.advanced/16.anonymous-class/src/AnonymousClassWithClassDemo.java

### 例 1 の実行結果

```console
[display()] 匿名クラスです.
```

## 例 2：インターフェースを実装する匿名クラス

インターフェースを実装する匿名クラスを作成する場合は、次のようになります。

```java
interface IScreen {
    public void display();
}

class AnonymousClassWithInterface {
    public void createClass() {

        IScreen anonymousObj = new IScreen() {
            public void display() {
                System.out.println("[display()] 匿名クラスです.");
            }
        };

        anonymousObj.display();
    }
}

class AnonymousClassWithInterfaceDemo {
    public static void main(String[] args) {
        AnonymousClassWithInterface anonymousObj = new AnonymousClassWithInterface();
        anonymousObj.createClass();
    }
}
```

インターフェースを実装する匿名クラス  
https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/05.advanced/16.anonymous-class/src/AnonymousClassWithInterfaceDemo.java

### 例 2 の実行結果

```console
[display()] 匿名クラスです.
```

### ラムダ式で簡潔に書いた場合

また、メソッドが 1 つのインタフェースを利用する場合は、ラムダ式でコードを置き換えることができます。

```java
interface IScreen {
    public void display();
}

class AnonymousClassWithInterface {
    public void createClass() {

        IScreen anonymousObj = () -> System.out.println(
                "[display()] 匿名クラスです."
            );

        anonymousObj.display();
    }
}

class AnonymousClassWithInterfaceDemo {
    public static void main(String[] args) {
        AnonymousClassWithInterface anonymousObj = new AnonymousClassWithInterface();
        anonymousObj.createClass();
    }
}
```

## 匿名クラスの利点

匿名クラスでは、オブジェクトは必要なときにいつでも作成できます。
つまり、オブジェクトは必要があれば、特定のタスクを実行するためにいつでも作成できるのです。
例えば、

```java
Object = new Example() {

    @Override
    public void display() {
        System.out.println("匿名クラスは display() メソッドをオーバーライドする");
    }
};
```

### 参考: 覚えておくべきキーポイント

- 匿名クラスの作成中には、任意のコンストラクタを使用できる。コンストラクタ引数も使用されていることに注意する
- 匿名クラスは最上位クラスを拡張し、抽象クラスまたはインタフェースを実装する。したがって、アクセス修飾子ルールは通常どおり適用される。保護された変数にアクセスできる。プライベートに変更すると、アクセスできなくなる
- クラスを拡張した場合は、すべてのメソッドをオーバーライドする必要はない。反対に、インタフェースまたは抽象クラスである場合は、実装されていないすべてのメソッドの実装を提供する必要がある
- 匿名クラスで Static 初期化ブロックまたはメンバインタフェースを宣言することができない
- 匿名クラスは、定数変数であれば Static メンバーを持つことができる

## 練習問題 1: ネストした匿名クラス（時間: 20 分）

以下の Hello インタフェースを使って、次のような匿名クラスを実装し、
main メソッドで sayHello() メソッドを実行する NestedAnonymousExample クラスを作成しなさい

- 「こんにちはネストした匿名クラス」と表示させるネストした匿名クラス
- main メソッド内に「こんにちは匿名クラス」と表示させる匿名クラス

### Hello.java

```java
package advanced.anonymous.nested;

public interface Hello {

	public void sayHello();
}
```

### NestedAnonymousExample.java の実行結果

```console
こんにちは匿名クラス
こんにちはネストした匿名クラス
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/05.advanced/16.anonymous-class/src/advanced/anonymous/nested

## 練習問題 2: コンストラクタを使用した匿名クラス（時間: 20 分）

次の Hello クラスを利用して、実行結果の通りになるように main メソッドに
匿名クラスを実装した AnonymousWithConstructorExample クラスを作成しなさい

### Hello.java

```java
package advanced.anonymous.constructor;

public class Hello {

    protected String name;

    public Hello(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println(name);
    }

    void foo() {
        System.out.println("Foo");
    }
}
```

```console
こんにちは匿名クラスの 山本一郎 さん
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/05.advanced/16.anonymous-class/src/advanced/anonymous/constructor
