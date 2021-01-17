## 学習

### 例外を握りつぶすとはどういうことかを認識する

Java の例外を握りつぶすとはどういうことかを Web で調べてください。
検索キーワードは、「 [java 例外 握りつぶし](https://www.google.com/search?q=java+例外+握りつぶし) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、例外を握りつぶすことの危険性を押さえておきましょう。

### 例外の握りつぶしとは

例外の握りつぶしは、Exception swallowing とも呼ばれます。

例外の握りつぶしが何かを知るには、コードを見るのが早いです。

```java
String target = "数字ではない";
try {
    int targetInt = Integer.parseInt(target);

} catch (NumberFormatException e) {
    // 何もしない
}
```

上記の処理ように、「例外を catch するけどその中では何もしない」ことを指して「握りつぶす」と呼びます。
これは、そもそも try-catch を書かないのとは全く違う行為です。

上記の処理の実行結果は、次のようになります。
つまり、何も起きません。

```console

```

## 隠蔽エラー

エラーが発生せず何も起きないのが何が悪いのか？
それは例外が発生したのに、開発者が何も把握できないという状態こそが大問題なのです。

この例外が隠されてしまう事象のことを、エラー隠蔽（Error hiding）と呼びます。

例外が握りつぶされてしまうと、バグの原因追及を難しくし、
システムに取って致命的なエラー（Critical error）を知らないうちに埋め込んでしまいます。

そのため、こうした箇所は「アプリのサイレントキラー」と表現されることもあります。

例外は処理実行時に発生した問題を示してくれます。
例外を無視や破棄をしてしまうと、不正なプログラムやデータなどを検出する機会を失ってしまうともに、
不正な状態のままシステムが動き続けてしまい、二次障害にもつながる可能性があります。

例外をキャッチしたにも関わらず、無視・破棄してしまうは絶対にダメ。
もしそんなコードを先輩に見つけられたら、正座で説教は免れられないでしょう。

比較として、上記の例外に対して try-catch を書かないコードを書いてみます。

```java
String target = "This is not a number.";
int targetInt = Integer.parseInt(target);
```

この処理の実行結果は次のようになります。

```java
Exception in thread "main" java.lang.NumberFormatException: For input string: "数字ではない"
        at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        at java.base/java.lang.Integer.parseInt(Integer.java:652)
        at java.base/java.lang.Integer.parseInt(Integer.java:770)
        at master.swallowing.excep.App.main(App.java:7)
```

### まとめ

例外の握りつぶしを行うと次のことが起こります。

- 例外が発生したことを、誰も知ることができない
- プログラムはそのまま実行され続ける

これにより、問題調査が困難になる可能性があるので、例外の握りつぶしは避けるべきです。

特に業務で製造するようなアプリやシステムにおいては、例外をキャッチした箇所で、
ログにスタックトレースを記録する処理を、必ず実装しましょう。

## 練習問題（時間: 20 分）

次の 4 つのクラスを利用する BirdWatching クラスを実行すると、実行結果の通りになるように、
BirdWatching クラスの該当処理を、例外が発生したことが隠蔽されないようにコードを修正しなさい

1. Bird.java
2. Eagle.java
3. Pigeon.java
4. Logger.java

### BirdWatching.java

```java
package master.swallowing.excep;

import master.swallowing.excep.entity.Eagle;
import master.swallowing.excep.entity.Pigeon;
import master.swallowing.excep.entity.base.Bird;

public class BirdWatching {

    public static void main(String[] args) {

        boolean isNeedToValidPigeon = true;
        boolean isNeedToConvertToPigeon = false;

        BirdWatching app = new BirdWatching();
        app.execute(
                isNeedToValidPigeon,
                isNeedToConvertToPigeon);
        System.out.println();

        isNeedToValidPigeon = false;
        isNeedToConvertToPigeon = true;
        app.execute(
                isNeedToValidPigeon,
                isNeedToConvertToPigeon);
        System.out.println();

        isNeedToConvertToPigeon = false;
        app.execute(
                isNeedToValidPigeon,
                isNeedToConvertToPigeon);
    }

    private void execute(
            boolean isNeedToValidPigeon,
            boolean isNeedToConvertToPigeon) {

        Bird eagle = new Eagle("オジロワシ");
        Bird pigeon = new Pigeon(null);

        try {
            eagle.fly();
            if (isNeedToValidPigeon) {
                pigeon.fly();
                pigeon.isEmptyName();
            }
            if (isNeedToConvertToPigeon) {
                Bird convertedPigeon = Bird.convertToPigeon(eagle);
                convertedPigeon.fly();
            }
        } catch (NullPointerException | ClassCastException e) {
            return;
        }
    }
}
```

### 1. Bird.java

```java
package master.swallowing.excep.entity.base;

import master.swallowing.excep.entity.Pigeon;

public abstract class Bird {

    protected String className;
    protected String name;

    protected Bird(String name) {
        this.name = name;
        this.className = "Bird";
    }

    public boolean isEmptyName() {
        return this.name.equals("");
    }

    public void fly() {
        System.out.format(
                "[%s] %s が飛んだ. %n",
                this.className, this.name);
    }

    public static Pigeon convertToPigeon(Bird bird) {
        return (Pigeon) bird;
    }
}
```

### 2. Eagle.java

```java
package master.swallowing.excep.entity;

import master.swallowing.excep.entity.base.Bird;

public class Eagle extends Bird {

    public Eagle(String name) {
        super(name);
        this.className = "Eagle";
    }
}
```

### 3. Pigeon.java

```java
package master.swallowing.excep.entity;

import master.swallowing.excep.entity.base.Bird;

public class Pigeon extends Bird {

    public Pigeon(String name) {
        super(name);
        this.className = "Pigeon";
    }
}
```

### 4. Logger.java

```java
package master.swallowing.excep.util;

public class Logger {

    public enum LogType {
        DEBUG("DEBUG"),
        INFO("INFO"),
        WARN("WARN"),
        ERROR("ERROR"),;

        private String name;

        private LogType(String name) {
            this.name = name;
        }

        private String getName() {
            return this.name;
        }
    }

    public static void log(LogType type, String message) {

        System.out.format(
                ":: [%s] %s %n", type.getName(), message);
    }

    public static void log(LogType type, Exception e) {

        log(type, e.getClass().getName());

        for (StackTraceElement element : e.getStackTrace()) {
            log(type, "  at " + element.toString());
        }
    }
}
```

### 修正後の BirdWatching.java の実行結果

```console
[Eagle] オジロワシ が飛んだ.
[Pigeon] null が飛んだ.
:: [ERROR] java.lang.NullPointerException
:: [ERROR]   at master.swallowing.excep.entity.base.Bird.isEmptyName(Bird.java:16)
:: [ERROR]   at master.swallowing.excep.BirdWatching.execute(BirdWatching.java:47)
:: [ERROR]   at master.swallowing.excep.BirdWatching.main(BirdWatching.java:18)

[Eagle] オジロワシ が飛んだ.
:: [ERROR] java.lang.ClassCastException
:: [ERROR]   at master.swallowing.excep.entity.base.Bird.convertToPigeon(Bird.java:26)
:: [ERROR]   at master.swallowing.excep.BirdWatching.execute(BirdWatching.java:50)
:: [ERROR]   at master.swallowing.excep.BirdWatching.main(BirdWatching.java:25)

[Eagle] オジロワシ が飛んだ.
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/06.master/06-bad-habit-is-swallowing-exception/src/master/swallowing/excep
