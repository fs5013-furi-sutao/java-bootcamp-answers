## 学習

### ラッパークラスを知る

Java のラッパークラスとは何かを Web で調べてください。検索キーワードは、「 [java ラッパークラス](https://www.google.com/search?q=java+ラッパークラス) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、Java のラッパークラスとは何か、ラッパークラスの使い方をつかみましょう。

8 つのプリミティブ型のそれぞれには、対応するラッパークラスがあります。

| プリミティブ型 | ラッパークラス |
| :------------- | :------------- |
| byte           | Byte           |
| boolean        | Boolean        |
| char           | Character      |
| double         | Double         |
| float          | Float          |
| int            | Integer        |
| long           | Long           |
| short          | Short          |

### 処理効率を考えて使い分ける

基本型（プリミティブ型）は、メモリの占有率からみて、対応するラッパーオブジェクトよりも効率的です。したがって、効率が必要な場合は、常にプリミティブ型を使用するようにしましょう。

## 練習問題（時間: 20 分）

最小値 3 ～ 最大値 11 までをリストに詰めた後、その中身をすべて表示する処理を main メソッドに持つ NumberList クラスを作成しなさい

### NumberList.java の実行結果

```console
[0] 3
[1] 4
[2] 5
[3] 6
[4] 7
[5] 8
[6] 9
[7] 10
[8] 11
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/04.mid/12.wrapper-class/src/NumberList.java
