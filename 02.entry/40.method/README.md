## ミニ課題 01: 足し算をするインスタンスメソッド（時間: 20 分）

プログラム実行結果が以下に示したようになる NumberAdder クラスを作成しなさい

### main メソッド

みかん 25 個、りんご 15 個を引数にして、addNumbers メソッドを呼び出し、結果を表示する

### addNumbers インスタンスメソッド

1 つ目の引数と 2 つ目の引数を足した値を返す

### NumberAdder の実行結果

```
みかん: 25 個
りんご: 15 個
合計: 40 個
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/40.method/src/NumberAdder.java

## ミニ課題 02: 生死判定をするクラスメソッド（時間: 20 分）

プログラム実行結果が以下に示したようになる HpChecker クラスを作成しなさい

### main メソッド

HP として 0 ～ 9 までの乱数を発生させ、HP を引数に isDead クラスメソッドを呼ぶ

isDead メソッドの返り値が false である限り「生きてます」と表示して、次の乱数を発生させ続け、メソッドの返り値が true になったら「死んでます」と表示する

### isDead クラスメソッド

引数が 0 だった場合に true を返す

### NumberAdder の実行結果

```
HP => 4: 生きてます.
HP => 4: 生きてます.
HP => 2: 生きてます.
HP => 6: 生きてます.
HP => 1: 生きてます.
HP => 9: 生きてます.
HP => 4: 生きてます.
HP => 6: 生きてます.
HP => 2: 生きてます.
HP => 0: 死んでます.
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/40.method/src/HpChecker.java

## ミニ課題 03: リストの全要素を表示させるインスタンスメソッド（時間: 20 分）

プログラム実行結果が以下に示したようになる ListPrinter クラスを作成しなさい

### main メソッド

1. 以下の要素を追加した ArrayList を作成する

- Chiwawa
- Pomeranian
- Bulldog
- Akita
- Poodle

2. printAllElements メソッドを呼び出す

### printAllElements インスタンスメソッド

引数のリストの全要素のインデックスと内容を表示する

### ListPrinter の実行結果

```
0 => Chiwawa
1 => Pomeranian
2 => Bulldog
3 => Akita
4 => Poodle
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/40.method/src/ListPrinter.java
