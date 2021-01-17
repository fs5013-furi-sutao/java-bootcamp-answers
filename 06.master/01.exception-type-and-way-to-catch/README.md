## 学習

### Java における例外処理を知る

Java における例外とは何か、その例外をキャッチする方法と例外の種類を Web で調べてください。
検索キーワードは、「 [java 例外 try catch](https://www.google.com/search?q=java+例外+try+catch) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、Java における例外処理の概要をつかみましょう。

## 練習問題 1: マルチキャッチ（時間: 20 分）

次の 4 つのクラスを利用する BirdWatching クラスを実行すると、実行結果の通りになるように、
BirdWatching クラスの該当処理に、try-catch-finally 例外処理をコーディングしなさい

ただし、例外処理はマルチキャッチにすること

1. Bird.java
2. Eagle.java
3. Pigeon.java
4. Logger.java

### BirdWatching.java

```java
package master.trycatch.multi;

import static master.trycatch.multi.util.Logger.LogType.DEBUG;
import static master.trycatch.multi.util.Logger.LogType.INFO;

import master.trycatch.multi.entity.base.Bird;
import master.trycatch.multi.entity.Eagle;
import master.trycatch.multi.entity.Pigeon;
import master.trycatch.multi.util.Logger;

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

        eagle.fly();
        if (isNeedToValidPigeon) {
            pigeon.fly();
            pigeon.isEmptyName();
        }
        if (isNeedToConvertToPigeon) {
            Bird convertedPigeon = Bird.convertToPigeon(eagle);
            convertedPigeon.fly();
        }
    }
}
```

### 1. Bird.java

```java
package master.trycatch.multi.entity.base;

import master.trycatch.multi.entity.Pigeon;

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
package master.trycatch.multi.entity;

import master.trycatch.multi.entity.base.Bird;

public class Eagle extends Bird {

    public Eagle(String name) {
        super(name);
        this.className = "Eagle";
    }
}
```

### 3. Pigeon.java

```java
package master.trycatch.multi.entity;

import master.trycatch.multi.entity.base.Bird;

public class Pigeon extends Bird {

    public Pigeon(String name) {
        super(name);
        this.className = "Pigeon";
    }
}
```

### 4. Logger.java

```java
package master.trycatch.multi.util;

public class Logger {

    public enum LogType {
        DEBUG("DEBUG"),
        INFO("INFO"),
        WARN("WARN"),;

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

### 例外処理を追記した BirdWatching.java の実行結果

```console
[Eagle] オジロワシ が飛んだ.
[Pigeon] null が飛んだ.
:: [DEBUG] [ヌルポ例外] 例外をキャッチしました.
:: [DEBUG] java.lang.NullPointerException
:: [DEBUG]   at master.trycatch.multi.entity.base.Bird.isEmptyName(Bird.java:16)
:: [DEBUG]   at master.trycatch.multi.BirdWatching.execute(BirdWatching.java:48)
:: [DEBUG]   at master.trycatch.multi.BirdWatching.main(BirdWatching.java:19)
:: [INFO] finally ブロックです.
:: [INFO] try-catch を抜けました.

[Eagle] オジロワシ が飛んだ.
:: [DEBUG] [キャスト例外] 例外をキャッチしました.
:: [DEBUG] java.lang.ClassCastException
:: [DEBUG]   at master.trycatch.multi.entity.base.Bird.convertToPigeon(Bird.java:26)
:: [DEBUG]   at master.trycatch.multi.BirdWatching.execute(BirdWatching.java:51)
:: [DEBUG]   at master.trycatch.multi.BirdWatching.main(BirdWatching.java:26)
:: [INFO] finally ブロックです.
:: [INFO] try-catch を抜けました.

[Eagle] オジロワシ が飛んだ.
:: [INFO] finally ブロックです.
:: [INFO] try-catch を抜けました.
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/06.master/01.exception-type-and-way-to-catch/src/master/trycatch/multi

## 練習問題 2: シングルキャッチ（時間: 20 分）

練習問題 1 のマルチキャッチを、実行結果の通りになるように、シングルキャッチの例外処理に変更しなさい

### 例外処理をシングルキャッチにした BirdWatching.java の実行結果

```console
[Eagle] オジロワシ が飛んだ.
[Pigeon] null が飛んだ.
:: [DEBUG] java.lang.NullPointerException
:: [DEBUG]   at master.trycatch.single.entity.base.Bird.isEmptyName(Bird.java:16)
:: [DEBUG]   at master.trycatch.single.BirdWatching.execute(BirdWatching.java:48)
:: [DEBUG]   at master.trycatch.single.BirdWatching.main(BirdWatching.java:19)
:: [INFO] finally ブロックです.
:: [INFO] try-catch を抜けました.

[Eagle] オジロワシ が飛んだ.
:: [DEBUG] java.lang.ClassCastException
:: [DEBUG]   at master.trycatch.single.entity.base.Bird.convertToPigeon(Bird.java:26)
:: [DEBUG]   at master.trycatch.single.BirdWatching.execute(BirdWatching.java:51)
:: [DEBUG]   at master.trycatch.single.BirdWatching.main(BirdWatching.java:26)
:: [INFO] finally ブロックです.
:: [INFO] try-catch を抜けました.

[Eagle] オジロワシ が飛んだ.
:: [INFO] finally ブロックです.
:: [INFO] try-catch を抜けました.
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/06.master/01.exception-type-and-way-to-catch/src/master/trycatch/single
