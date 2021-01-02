## ネストを深くすることは悪いことだと知る

深すぎるネストはバグの温床になりやすいです。
できるだけ浅くする努力をしましょう。

ネストとはコードブロックがいくつも入れ子のなっていく状態のことです。

例えば、以下のようなイメージです。以下の例では、ネストが 3 層以上になっています。

```java title=典型的なネスト構造
while (condition) {
    // processes

    if (condition) {
        // processes

        if (condition) {
            // processes

            if (condition) {
                // processes
            } else if (condition) {
                // processes
            } else {
                // processes
            }
        }
    }
}
```

ネストが 3 層以上になると、さすがに処理が追いかけづらくなります。

## ネストは何層ぐらいまでなら許されるの？

ネストは、2 層までに留めたいです。それより深くなると、処理の流れを読むのに苦労するからです。

## 実例を読みやすくなるように段階的にリファクタリング

後の項目「ガード節・早期リターン」でリファクタリングの技術的なことはやっていくので、
ここでは軽く、ネストを深くしないようにするにはどうすればいいかを掴んでいきます。

次の例もネストが 3 層になっていて処理が分かりにくいです。
これを段階を追って、改善していきます。

```java title=例①：リファクタリングの題材
public void function() {
    if (!errorFlag) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                if (hogehoge) {
                    // processes
                } else {
                    // processes
                }
            }
        }
    }
}
```

### 1. 早期リターン

まず、最初にエラーだった時点で return してしまいます。
たったこれだけで、一階層減ります。

```java title=例①：1.早期リターンさせる
public void function() {

    if (errorFlag) return;

    for (int i = 0; i < array.length; i++) {
        if (array[i] != null) {
            if (hogehoge) {
                // processes
            } else {
                // processes
            }
        }
    }
}
```

### 2. ガード節

次に、ループの中で何もしなくていい場合は continue します。
これで、いとも簡単にもう一階層減ります。

```java title=例①：2.ガード節を使う
public void function() {

    if (errorFlag) return;

    for (int i = 0; i < array.length; i++) {

        if (array[i] == null) continue;

        if (hogehoge) {
            // processes
        } else {
            // processes
        }
    }
}
```

### 3. さらにガード節

最後に、余分な else 文を取ればこのメソッドは完成です。

```java title=例①：3.さらにガード節を使う
public void function() {

    if (errorFlag) return;

    for (int i = 0; i < array.length; i++) {

        if (array[i] == null) continue;

        if (hogehoge) {
            // processes
            continue;
        }

        // processes
    }
}
```

## なぜネストが深くなるのか

ネストを深くする人は自分で書いていて読みにくくないのだろうか。
ネストを深くする人は、次のような前段処理をしていないという印象を受けます。

- 次の処理に向かう前に弾けるケースを先にはじいていない
- スキップできる処理を最初にスキップさせていない

複雑な条件分岐がネストしてしまう場合は、わざわざ難しい方法や順序で分岐判定を行っていないか、
少し立ち止まって考えてみるべきです。

### ロジックを整理してみよう

処理を書く前に判定ロジックを整理する、
そして処理を書いた後に判定ロジックはこれで大丈夫なのか
を確認する意識や感覚を持ちましょう。

```java title=例②：本当にこれで判定ロジックは大丈夫？
public int function(int a, int b) {
    int result;

    if (a > 10) {

        if (a > 20) {

            if (a > 30) {
                result = b;

            } else {
                result = 3;
            }

        } else {
            result = 2;
        }

    } else {
        result = 1;
    }

    return result;
}
```

これは以下のように書けます。

```java title=例②：リファクタリング後
public int function(int a, int b){
    if (a < 10) return 1;
    if (a < 20) return 2;
    if (a < 30) return 3;
    return b;
}
```

### エラーチェックの場合

意図したデータが与えられたかどうかのチェックを行うたびに、
判定ロジックがネストされるケースは良くあります。

```java title=例③：データが適正かどうかの判定ロジック
public boolean isValid(Data data) {

    if(data != null) {

        if(data.count() > 0) {

            if(!data.isError()) {

                if (data.getResult() != null) {
                    return true;
                }
            }
        }
    }
    return false;
}
```

これは以下のように簡潔に書くと条件判定が読みやすくなります。

```java title=例③：リファクタリング後
public boolean isValid(Data data) {
    if (data == null) return false;
    if (data.count() == 0) return false;
    if (data.isError == null) return false;
    if (data.getResult() != null) return true;
    return false;
}
```

## ミニ課題（時間: 20 分）

次のクラス Rent について isValid メソッドのネストを減らすようにリファクタリングしなさい

リファクタリング元コード  
https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/03.primary/04.dont-make-nest-too-deep/src/Rent.java

```java title=src/Rent.java
public class Rent {
    public static void main(String[] args) {

        Rent app = new Rent();

        RentalInfo yamamotoInfo = new RentalInfo(
                "山本一郎", "aa", "bb", "10", "2000"
            );

        RentalInfo yamadaInfo = new RentalInfo(
                "山田太郎", "aa", "bb", "80", "2000"
            );

        RentalInfo yamaguchiInfo = new RentalInfo(
                "山口次郎", "aa", "bb", "15", "500"
            );

        app.doRegister(yamamotoInfo);
        app.doRegister(yamadaInfo);
        app.doRegister(yamaguchiInfo);
    }

    private void doRegister(RentalInfo info) {

        System.out.println("-----");
        System.out.printf(
            "%s さんの登録審査をします. %n", info.name
        );

        if (isValid(info)) {
            info.registRentalProperty();
        } else {
            System.out.println(
                "賃貸情報を登録できませんでした."
            );
        }

        System.out.println();
    }

    public boolean isValid(RentalInfo info) {

        boolean isValid = false;

        // 沿線未入力チェック
        if (info.wayside == null) {
            System.out.println("沿線が未入力です.");

        } else {
            // 最寄駅未入力チェック
            if (info.nearestStation == null) {
                System.out.println("最寄駅が未入力です.");

            } else {
                // 徒歩（分）未入力チェック
                if (info.onFootMinutes == null) {
                    System.out.println("徒歩が未入力です.");

                } else if (!isNumeric(info.onFootMinutes)) {
                    System.out.println(
                        "徒歩には数値を入力してください."
                    );

                } else if (
                        !isNumericRange(
                            info.onFootMinutes, 0, 60
                        )
                    ) {

                    System.out.println(
                        "徒歩は0分以上60分以下を"
                            + "入力してください."
                    );

                } else {
                    // 賃料未入力チェック
                    if (info.monthlyRent == null) {
                        System.out.println(
                            "賃料が未入力です."
                        );

                    } else if (
                            !isNumeric(info.monthlyRent)
                        ) {

                        System.out.println(
                            "徒歩には数値を入力してください."
                        );

                    } else if (
                            !isNumericRange(
                                info.monthlyRent,
                                1000, 200000
                            )
                        ) {

                        System.out.println(
                            "徒歩は1,000円以上200,000円以下を"
                                + "入力してください."
                        );

                    } else {
                        isValid = true;
                    }
                }
            }
        }

        return isValid;
    }

    public boolean isNumeric(String target) {
        String regexNumeric = "[+-]?\\d*(\\.\\d+)?";
        boolean isNumeric = target.matches(regexNumeric);
        return isNumeric;
    }

    public boolean isNumericRange(
            String target, int from, int to
        ) {

        int intTarget = Integer.parseInt(target);
        return intTarget >= from && intTarget <= to;
    }
}

class RentalInfo {
    public String name = "";
    public String wayside = "";
    public String nearestStation = "";
    public String onFootMinutes = "";
    public String monthlyRent = "";

    public RentalInfo(
            String name, String wayside,
            String nearestStation, String onFootMinutes,
            String monthlyRent
        ) {

        this.name = name;
        this.wayside = wayside;
        this.nearestStation = nearestStation;
        this.onFootMinutes = onFootMinutes;
        this.monthlyRent = monthlyRent;
    }

    public void registRentalProperty() {
        System.out.println("賃貸情報を登録しました.");
    }
}
```

```txt title=Rentクラスの実行結果
-----
山本一郎 さんの登録審査をします.
賃貸情報を登録しました.
-----
山田太郎 さんの登録審査をします.
徒歩は0分以上60分以下を入力してください.
賃貸情報を登録できませんでした.

-----
山口次郎 さんの登録審査をします.
徒歩は1,000円以上200,000円以下を入力してください.
賃貸情報を登録できませんでした.

```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/03.primary/04.dont-make-nest-too-deep/src/RefactoringRent.java
