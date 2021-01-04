## メソッドは名前と処理を一致させるようにする

メソッドは名前と、中身の処理の内容が一致していないとダメです。

もうこれは決定的で、間違いないシンプルな事実です。以下の例を見れば、明白です。

```java
public int countUp(int num) {
    System.out.println("Hello world.");
    return num;
}
```

もうこれはバグです。プログラムとしての体をなしていません。
カウントアップしてくださいね、と言ってるのに、カウントアップをせずに、勝手な表示をしているだけ。

では例えば、次の例はどうでしょうか。

```java
public int countUpMember() {
    this.cntMembers++;
    if (this.cntMembers <= MAX_CAPACITY) {
        this.status = ReceptionStatus.CLOSED;
    }
}
```

メンバーをカウントアップします、と言っているのにカウントアップだけでなく、
定員に達したら受付終了状態にすることまでやっています。

こうした実態とメソッド名が一致していないとバグの温床になります。

改善するなら、以下の感じでしょうか。

```java
public int checkInReception() {
    countUpMember();

    if (isMembersFull()) {
        setStatusToClosed();
    }
}

public int countUpMember() {
    this.cntMembers++;
}

public int setStatusToClosed() {
    this.status = ReceptionStatus.CLOSED;
}

public boolean setStatusToClosed() {
    return this.cntMembers <= MAX_CAPACITY;
}
```

## 良いメソッド名の条件

良いメソッド名は、その中身を正しく表しています。
良いメソッド名ならば、コメントを読むまでもなく、名前を見るだけでその役割を理解できます。

良い名前はコードの理解を助けますが、反対に悪い名前は読む者を混乱させ、勘違いを生み、バグの発生を助長します。

良いメソッド名は説明的で意味・意図を的確に表しています。

## 名前重要

達人プログラマたちのエッセイ集で「プログラマが知るべき 97 のこと」という書籍があります。

この本の中で、まつもと ゆきひろ氏が「名前重要」というタイトルで、
プログラミングにおける名前の重要性について語っています。

まつもと ゆきひろ氏は、プログラミング言語 Ruby の開発者であり、生みの親です。

> 適切な名前をつけられると言うことは、その機能が正しく理解されて、設計されているということで、逆にふさわしい名前がつけられないということは、その機能が果たすべき役割を設計者自身も十分に理解できていないということではないでしょうか。

名前重要 | プログラマが知るべき 97 のこと  
[https://プログラマが知るべき 97 のこと.com/エッセイ/名前重要
](https://xn--97-273ae6a4irb6e2hsoiozc2g4b8082p.com/%E3%82%A8%E3%83%83%E3%82%BB%E3%82%A4/%E5%90%8D%E5%89%8D%E9%87%8D%E8%A6%81/)

## ミニ課題（時間: 20 分）

次のプログラム内で、実態に則していないメソッド名がある。リファクタリングしなさい

```java
public class ChildrenHelper {
    public static void main(String[] args) {

        Child[] children = {
            new Child("山本", "一郎", Gender.MAN),
            new Child("山田", "花子", Gender.WOMAN),
            new Child("山口", "次郎", Gender.MAN),
        };

        for (Child child : children) {
            System.out.printf(
                "ID=%d のフルネームは %s です. %n",
                child.id, child.updateName()
            );
        }
    }
}

enum Gender {
    MAN, WOMAN,
}

class Child {
    private static int maxId;
    public int id;
    private String firstName;
    private String lastName;
    private Gender gender;

    static {
        maxId = 0;
    }

    public Child(
            String firstName, String lastName,
            Gender gender) {

        this.id = ++maxId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public String updateName() {
        return this.firstName
            + this.lastName
            + getHonorificTitle();
    }

    public String getHonorificTitle() {
        if (this.gender == Gender.MAN) return "くん";
        return "ちゃん";
    }
}
```

### VariousArrays の実行結果

```txt title=ChildrenHelperクラスの実行結果
ID=1 のフルネームは 山本一郎くん です.
ID=2 のフルネームは 山田花子ちゃん です.
ID=3 のフルネームは 山口次郎くん です.
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/03.primary/10.method-name-matches-actual-situation/src/ChildrenHelper.java
