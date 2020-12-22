## ミニ課題 01: 数字入力（時間: 20 分）

プログラム実行後、以下の数字を入力した場合に、以下のプログラム実行結果となるように、main メソッドを持つクラス NumberInputReciever を作成しなさい。

### 入力値

```
888
```

### NumberInputReciever の実行結果

```
数字を入力してください: 888
入力された数字は 888 です.
```

## NumberInputReciever の解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/16.text-input/src/NumberInputReciever.java

## ミニ課題 02: 文字列入力（時間: 20 分）

プログラム実行後、以下の文字列を入力した場合に、以下のプログラム実行結果となるように、main メソッドを持つクラス StringInputReciever を作成しなさい。

### 入力値

```
QRS
```

### StringInputReciever の実行結果

```
文字列を入力してください: QRS
入力された名前は QRS   です.
```

## StringInputReciever の解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/16.text-input/src/StringInputReciever.java

## ミニ課題 03: 不正入力（時間: 20 分）

Scanner クラスを使った標準入力で、数字入力を想定したメソッドを使っているのに、ユーザが数字以外の文字を入力するとエラーになる。上記、InputReciever を実行した場合が、まさにそれに当たる

プログラム実行後、以下の数字を入力した場合に、以下のプログラム実行結果となるように、main メソッドを持つクラス BadInputReciever を作成しなさい。

### 入力値

```
qrs
```

### BadInputReciever の実行結果

```
数字を入力してください: qrs
数字以外の文字が入力されました.
```

## BadInputReciever の解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/16.text-input/src/BadInputReciever.java

## 別解（BadInputRecieverAnother）

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/16.text-input/src/BadInputRecieverAnother.java
