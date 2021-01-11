## 学習

### それぞれの日付操作のクラスの特徴をつかむ

Java に用意されている Date クラス、Calendar クラス、LocalDateTime クラスが何か、使い方を Web で調べてください。

- java.util.Date
- java.util.Calendar
- java.time.LocalDateTime(java8)

検索キーワードは、「 [java date クラス](https://www.google.com/search?q=java+date+クラス) 」
「 [java calendar クラス](https://www.google.com/search?q=java+calendar+クラス) 」
「 [java localdatetime クラス](https://www.google.com/search?q=java+localdatetime+クラス) 」などです。
各 3 種類ぐらい説明記事やサンプルコードを読んで、Java で日付操作をする方法を、ざっとつかみましょう。

各クラスについて現時点で、深く理解する必要はなく、
それぞれの日付操作のクラスの特徴が分かり、必要に応じて日付操作を、調べながら実装できるようにしておきましょう。

また、Java 8 以降であれば、日時の操作はできる限り java.time.LocalDate や java.time.LocalDateTime を使うようにすることも知っておきましょう。

## 練習問題 01: メソッドのオーバーロード（時間: 20 分）

java.time.LocalDateTime クラスを使って、実行結果のように現在日時を表示する処理を main メソッドに持つ CurrentDateTime クラスを作成しなさい

### CurrentDateTime.java の実行結果

```console
現在の日時: 2021 年 01 月 11 日  19 時 00 分
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/04.mid/11.date-manipuration/src/mid/date/manipuration
