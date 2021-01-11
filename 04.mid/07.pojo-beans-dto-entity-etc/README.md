## 学習

### Java における Getter と Setter の役割を知る

Java では、クラスの種類を指す言葉として、POJO・Beans・DTO・Entity などといったクラス名称があります。

クラスを指し示す言葉、アプリケーション内での用途は違いますが、すべて同じ構造のクラスです。

どれも、次のような構造のクラスです。

> フィールドと、その各フィールドに対する Getter と Setter のみを持ったクラス

つまり、ただのデータの入れ物として利用するためのオブジェクトです。

POJO・Beans・DTO・Entity などについて、現時点ですべて知る必要はないですが、ざっくりとこれらについて知識的に触れておきましょう。

POJO・Beans・DTO・Entity などが何かを Web で調べてください。
検索キーワードは、「 [pojo](https://www.google.com/search?q=pojo) 」「 [java beans](https://www.google.com/search?q=java+beans) 」
「 [java dto](https://www.google.com/search?q=java+dto) 」「 [java entity](https://www.google.com/search?q=java+entity) 」などです。

## 練習問題（時間: 20 分）

実行結果の通りになるように、次の Bank クラスで利用するための銀行口座を表す POJO である BankAccount クラスを作成しなさい

### Bank.java

```java
package mid.pojo;

public class Bank {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();
        account.setId(777);
        account.setName("山本一郎");
        account.setAge(3);
        account.setBalance(5211111110.0);

        System.out.printf(
                "ID:%d %s（%d 歳）さんの預金残高は %.0f 円です. %n",
                account.getId(),
                account.getName(),
                account.getAge(),
                account.getBalance()
            );
    }
}
```

### ChildHouse.java の実行結果

```console
ID:777 山本一郎（3 歳）さんの預金残高は 5211111110 円です.
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/04.mid/07.pojo-beans-dto-entity-etc/src/mid/pojo
