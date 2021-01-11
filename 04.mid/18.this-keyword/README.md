## 学習

### this が何を指しているかを理解する

Java の this キーワードとは何かを Web で調べてください。
検索キーワードは、「 [java this キーワード](https://www.google.com/search?q=java+this+キーワード) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、Java の this キーワードとは何かをつかみましょう。

## 練習問題: バグ修正（時間: 20 分）

次の Student クラスについて、インスタンスの内容が正しく表示されるようにバグを修正しなさい

### 1. Student.java

```java
package mid.thiskeyword;

public class Student {

    int rollNo;
    String name;
    float monthFee;

    Student(int rollNo, String name, float monthFee) {
        rollNo = rollNo;
        name = name;
        monthFee = monthFee;
    }

    void displayDetails() {
        System.out.format(
                "出席番号:%d 氏名:%S 月謝:%.0f 円 %n",
                this.rollNo, this.name, this.monthFee
            );
    }
}
```

### 2. Classroom.java

```java
package mid.thiskeyword;

public class Classroom {
    public static void main(String[] args) {

        Student[] students = {
            new Student(111, "山本一郎", 5000f),
            new Student(112, "山下次郎", 6000f),
        };

        for (Student student : students) {
            student.displayDetails();
        }
    }
}
```

### 修正前の Classroom.java の実行結果

```console
出席番号:0 氏名:NULL 月謝:0 円
出席番号:0 氏名:NULL 月謝:0 円
```

### 修正後に期待する結果

```console
出席番号:111 氏名:山本一郎 月謝:5000 円
出席番号:112 氏名:山下次郎 月謝:6000 円
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/04.mid/18.this-keyword/src/mid/thiskeyword
