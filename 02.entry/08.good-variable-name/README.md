## ミニ課題（時間: 20 分）

以下のプログラム GoodVariableName.java について、実態と変数名が異なっているため、処理が読みにくくなっている。実態と変数名が一致するように、変数名を修正しなさい。

```java title=src/GoodVariableName.java
public class GoodVariableName {
    public static void main(String[] args) {

        int name = 23;
        int address = 62;
        int myFatherWeight = 45;

        int sumAges = myFatherWeight + name;

        System.out.println(ぼくの名前は、山本一郎");
        System.out.printf("年齢は %d 歳です.", name);
        System.out.printf("体重は %d 歳です.", address);
        System.out.printf("パパの年齢は %d 歳です.", myFatherWeight);
        System.out.printf("パパとぼくの年齢を合わせると %d 歳です.", sumAges);
    }
}
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/08.good-variable-name/src/GoodVariableName.java
