## ミニ課題 01: 文字列の分割（時間: 20 分）

main メソッドに以下の 3 つの処理を記述して、プログラム実行結果が以下に示したようになるように StringSplitter クラスを作成しなさい

- 変数「フルネーム」で「山本 一郎」を宣言する
- 変数「フルネーム」で 文字列を分割するメソッドを、半角スペースを引数にして呼び出し、分割結果を変数「名前配列」に代入する
- 変数「名前配列」を使って、姓と名を表示する

### StringSplitter の実行結果

```
姓: 山本, 名: 一郎
```

## StringSplitter の解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/15.text-operations/src/StringSplitter.java

## ミニ課題 02: 文字列の結合（時間: 20 分）

main メソッドに以下の 4 つの処理を記述して、プログラム実行結果が以下に示したようになるように StringConcatter クラスを作成しなさい

- 変数「姓」で「山本」を宣言する
- 変数「名」で「一郎」を宣言する
- 変数「姓」で文字列を結合するメソッドを、変数「名」を引数にして呼び出し、結合結果を変数「フルネーム」に代入する
- 変数「フルネーム」を表示する

### StringConcatter の実行結果

```
ぼくのフルネームは 山本一郎 です.
```

## StringConcatter の解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/15.text-operations/src/StringConcatter.java

## ミニ課題 03: 複数文字列の結合（時間: 20 分）

main メソッドに以下の 4 つの処理を記述して、プログラム実行結果が以下に示したようになるように MultipleStringsConcatter クラスを作成しなさい

### 1. 定数宣言

- 定数「半角スペース」で「 」を宣言する

### 2. 変数宣言

- StringBuilder クラスのインスタンスを生成して、StringBuilder 型の変数「文字列組立」に代入する
- 変数「姓」で「山本」を宣言する
- 変数「名」で「一郎」を宣言する

### 3. 文字列結合

- 変数「文字列組立」で文字列追加メソッドを、変数「姓」を引数にして呼び出す
- 変数「文字列組立」で文字列追加メソッドを、定数「半角スペース」を引数にして呼び出す
- 変数「文字列組立」で文字列追加メソッドを、変数「名」を引数にして呼び出す

### 4. 表示処理

- 変数「文字列組立」の内容を表示する

### MultipleStringsConcatter の実行結果

```
山本 一郎
```

## MultipleStringsConcatter の解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/15.text-operations/src/MultipleStringsConcatter.java

## ミニ課題 04: 文字列の切り出し（時間: 20 分）

main メソッドに以下の 4 つの処理を記述して、プログラム実行結果が以下に示したようになるように StringCutOut クラスを作成しなさい

### 1. 定数宣言

- 定数「始点」として「2」を宣言する
- 定数「終点」として「6」を宣言する

### 2. 変数宣言

- 変数「対象文字列」で「investment」を宣言する

### 3. 文字列の切り出し

- 変数「対象文字列」で文字列の切り出しメソッドを、定数「始点」と定数「終点」を引数にして呼び出し、切り出した結果を変数「結果文字列」に代入する

### 4. 表示処理

- 変数「結果文字列」の内容を表示する

### StringCutOut の実行結果

```
vest
```

## StringCutOut の解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/15.text-operations/src/StringCutOut.java
