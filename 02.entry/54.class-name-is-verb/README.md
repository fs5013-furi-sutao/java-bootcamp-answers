## クラス名を動詞にするのは悪

Java だけではなく、オブジェクト指向を持つ言語すべてにいえることですが。

クラス名が動詞だった場合に、違和感を感じるような感覚が必要です。
なぜなら、オブジェクト指向でクラスを扱う際に、クラス名が動詞だと上手く扱えないからです。

## クラス名が名詞であれば

例えば、以下のような苦情クラスを使うとします。

```java
/**
 * 苦情クラス
 */
public class Complaint {
    String message;

    public void setMessage(String message) {
        this.message = message;
    }
}
```

このようにクラス名が名詞だと、ごく自然な感覚で使えます。例えばこんな感じです。

```java
Complaint complaint = new Complaint();
complaint.setMessage("風呂が汚い");
```

## クラス名が動詞始まりになると

では、クラス名が動詞始まりであったらどうでしょうか？

```java
/**
 * 苦情受付クラス
 */
public class RecieveComplaint {
    String message;

    public void setMessage(String message) {
        this.message = message;
    }
}
```

この苦情受付クラスを使おうとすると、こんな感じになってしまいます。

```java
RecieveComplaint recieve = new RecieveComplaint();
recieve.setMessage("風呂が汚い");
```

英語の文章としておかしな感じになってしまうわけです。

## 現実世界を演出する

実際に苦情を受け付けるクラスを作るとすると、以下のような感じにすれば、現実世界に近い感じを演出できるかと思います。

```java
/**
 * お客様窓口クラス
 */
class CustomerHelpDesk {

    /**
     * 苦情を受け付ける
     * @param complaint 苦情内容
     * @return 受付メッセージ
     */
    public String recieveComplaint(Complaint complaint) {
        // implementing the process
    }
}
```

## オブジェクト指向の意義

オブジェクト指向は、分割統治法の 1 種です。

人間は、多くの状態を一度に覚えるのが苦手です。

そのため、大規模なプログラムでは、分割統治を行い、一度に把握すべきことを少なくする必要があります。

オブジェクト指向は、現実世界のモノ（オブジェクト）に処理を重ね合わせることで、処理を統治しやすくするという方法です。

例えば、「LightSwitch」というクラスがあれば、照明のスイッチということが分かります。

そのクラスに「turnOn」というメソッドがあれば、照明をオンにするんだなというのが直感で分かります。

そうやって、現実世界になぞらえて処理を把握しやすくする方法が、オブジェクト指向です。

## オブジェクト指向にならった命名

このオブジェクト指向に沿うようにするには、クラス名とメソッド名は次のようなルールに従うことになります。

- クラス名は名詞
- メソッド名は動詞始まり

試しに、先ほど例示した「お客様窓口」クラスを使ってみましょう。

```java
Complaint complaint = new Complaint();
complaint.setMessage("風呂が汚い");

CustomerHelpDesk supportDesk = new CustomerHelpDesk();
supportDesk.recieveComplaint(complaint);
```

サポートデスクが苦情を受け付ける・・・みたいな自然な英語になり、
処理がすんなり読めて、実装の意図をくみ取りやすくなります。

## ミニ課題（時間: 20 分）

各クラスの仕様が以下の通りで、プログラム実行結果が以下に示したようになるように 3 つのクラスを作成しなさい

### 1. 顧客クラス

#### フィールド

- 名前
- 支払情報

#### メソッド

- コンストラクタ（引数は名前と料金）
- 支払い
- 支払い済みかどうかを表示

### 2. 支払情報クラス

#### フィールド

- 金額
- 支払い済みかどうか

#### メソッド

- コンストラクタ（引数は料金）
- 支払い
- 金額取得
- 支払い済みかどうかを取得

### 3. 顧客取り扱いクラス

#### main メソッド内の処理

- 「山本一郎」と「200 円」で、顧客インスタンス（yamamoto）を生成
- 「山田太郎」と「200 円」で、顧客インスタンス（yamada）を生成
- yamamoto が支払い
- yamamoto が支払い済みかどうかを表示
- yamada が支払い済みかどうかを表示

### 顧客取り扱いクラスの実行結果

```
山本一郎 さんは 200 円支払い済みです.
山田太郎 さんに 300 円請求中です.
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/54.class-name-is-verb/src
