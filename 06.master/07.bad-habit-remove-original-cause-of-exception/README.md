## 学習

### 「根本例外を捨てる」とはどういうことか？

「根本例外を捨てる」とは、キャッチした例外を別の例外に変換して上位にスローしてしまう行為のことです。

```java
try {
    myService.execute();

} catch (IllegalArgumentException e) {
    throw new MySystemException();
}
```

これをやると根本原因となる Exception がログに表示されないので、これ以上先にエラー原因が追えなくなってしまいます。

## 実業務であるパターン

実業務を想定した場合、例外を別の例外でラップしたくなるのは、次のようなケースです。

あなたのチームは、エラーコードと統一された処理を備えた [自作例外](./04-custom-business-exception) を使用することに決めました。
原因を取り除けない限り、このアプローチに問題はありません。

しかし、この際に根本例外を捨ててしまうと、不具合が起きた時の原因調査が難しくなってしまいます。

そうならないためには、次の点に注意して実装します。

## 自作例外を作る時の注意点

新しい例外をインスタンス化するときは、常にキャッチされた例外をその原因として設定する必要があります。

そうしないと、例外の原因となった例外イベントを説明するメッセージとスタックトレースが失われます。
例外クラスとそのすべてのサブクラスは、パラメータとして元の例外を受け入れ、
原因としてそれを設定し、いくつかのコンストラクタメソッドを提供するようにします。

```java
try {
    myService.execute();

} catch (NumberFormatException e) {
    throw new MyBusinessException(e, ErrorCode.CONFIGURATION_ERROR);

} catch (IllegalArgumentException e) {
    throw new MyBusinessException(e, ErrorCode.UNEXPECTED);

}
```

## 練習問題（時間: 30 分）

次の 4 つのクラスを利用する BirdWatching クラスを実行すると、実行結果の通りになるよう、
根本例外を捨てない方法に Bird 抽象クラスと実行クラス BirdWatching を修正しなさい

また、根本例外を捨てずに再スローする際には、自作例外の AppException クラスを作成し、
根本例外のラップ方法に合わせて、Logger クラスも修正しなさい

1. Bird.java
2. Eagle.java
3. Pigeon.java
4. Logger.java

### BirdWatching.java

```java
package master.original.excep;

import static master.original.excep.util.Logger.LogType.ERROR;

import master.original.excep.entity.Eagle;
import master.original.excep.entity.Pigeon;
import master.original.excep.entity.base.Bird;
import master.original.excep.util.Logger;

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
        } catch (Exception e) {
            // e.printStackTrace();
            Logger.log(ERROR, e);
        }
    }
}
```

### 1. Bird.java

```java
package master.original.excep.entity.base;

import master.original.excep.entity.Pigeon;

public abstract class Bird {

    protected String className;
    protected String name;

    protected Bird(String name) {
        this.name = name;
        this.className = "Bird";
    }

    public boolean isEmptyName() throws Exception {

        boolean isEmptyName = false;
        try {
            isEmptyName = this.name.equals("");

        } catch (NullPointerException e) {
            throw new Exception();
        }

        return isEmptyName;
    }

    public void fly() {
        System.out.format(
                "[%s] %s が飛んだ. %n",
                this.className, this.name);
    }

    public static Pigeon convertToPigeon(Bird bird) throws Exception {

        Pigeon pigeon;
        try {
            pigeon = (Pigeon) bird;

        } catch (ClassCastException e) {
            throw new Exception();
        }
        return pigeon;
    }
}
```

### 2. Eagle.java

```java
package master.original.excep.entity;

import master.original.excep.entity.base.Bird;

public class Eagle extends Bird {

    public Eagle(String name) {
        super(name);
        this.className = "Eagle";
    }
}
```

### 3. Pigeon.java

```java
package master.original.excep.entity;

import master.original.excep.entity.base.Bird;

public class Pigeon extends Bird {

    public Pigeon(String name) {
        super(name);
        this.className = "Pigeon";
    }
}
```

### 4. Logger.java

```java
package master.original.excep.util;

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

### 修正前の BirdWatching.java の実行結果

```console
[Eagle] オジロワシ が飛んだ.
[Pigeon] null が飛んだ.
:: [ERROR] java.lang.Exception
:: [ERROR]   at master.original.excep.entity.base.Bird.isEmptyName(Bird.java:23)
:: [ERROR]   at master.original.excep.BirdWatching.execute(BirdWatching.java:48)
:: [ERROR]   at master.original.excep.BirdWatching.main(BirdWatching.java:19)

[Eagle] オジロワシ が飛んだ.
:: [ERROR] java.lang.Exception
:: [ERROR]   at master.original.excep.entity.base.Bird.convertToPigeon(Bird.java:41)
:: [ERROR]   at master.original.excep.BirdWatching.execute(BirdWatching.java:51)
:: [ERROR]   at master.original.excep.BirdWatching.main(BirdWatching.java:26)

[Eagle] オジロワシ が飛んだ.
```

### 修正後の BirdWatching.java の実行結果

```console
[Eagle] オジロワシ が飛んだ.
[Pigeon] null が飛んだ.
:: [ERROR] UnecpectedError: 想定外の値が設定されています.
:: [ERROR] master.original.excep.exception.AppException
:: [ERROR] java.lang.NullPointerException
:: [ERROR]   at master.original.excep.entity.base.Bird.isEmptyName(Bird.java:24)
:: [ERROR]   at master.original.excep.BirdWatching.execute(BirdWatching.java:48)
:: [ERROR]   at master.original.excep.BirdWatching.main(BirdWatching.java:19)

[Eagle] オジロワシ が飛んだ.
:: [ERROR] IncorrectHandlingError: 間違った処理が行われました.
:: [ERROR] master.original.excep.exception.AppException
:: [ERROR] java.lang.ClassCastException
:: [ERROR]   at master.original.excep.entity.base.Bird.convertToPigeon(Bird.java:43)
:: [ERROR]   at master.original.excep.BirdWatching.execute(BirdWatching.java:51)
:: [ERROR]   at master.original.excep.BirdWatching.main(BirdWatching.java:26)

[Eagle] オジロワシ が飛んだ.
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/06.master/06-bad-habit-is-swallowing-exception/src/master/original/excep
