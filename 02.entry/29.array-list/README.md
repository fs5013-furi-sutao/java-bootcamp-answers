## ミニ課題（時間: 20 分）

main メソッドに以下の 5 つの処理を記述して、プログラム実行結果が以下に示したようになるように ArrayListManager クラスを作成しなさい。

### 1. ArrayList の初期化:

- List 型の変数「list」を宣言し、ArrayList のインスタンスを代入

### 2. ArrayList インスタンスが空かどうかの判定結果

- 変数「isListEmpty」を宣言し、「list」が空かどうかの判定結果を代入
- 「isListEmpty」の内容を表示

### 3. ArrayList インスタンスに要素を追加

- 「list」に要素「000」を追加
- 「list」に要素「111」を追加
- 「list」に要素「222」を追加

### 4. ArrayList インスタンスの要素数を表示

- 変数「listSize」を宣言し、「list」の要素数を代入
- 「listSize」の内容を表示

### 5. ArrayList インスタンスに対象要素が含まれるかの確認

- 変数「keyword」を宣言し、「111」を代入
- 変数「hasKeyword」を宣言し、「list」の要素に「keyword」が含まれるかどうかの判定結果を代入
- 「hasKeyword」の内容を表示

### 6.　 ArrayList インスタンスの指定インデックスの要素を取得

- 変数「targetIndex」を宣言し、「2」を代入
- 変数「target」を宣言し、「list」の targetIndex 番目の要素を代入 -「target」の内容を表示

### 7. ArrayList インスタンスのどのインデックスに指定要素があるのかを取得

- 「target」に「000」を代入
- 「targetIndex」に、list のどのインデックスに target にあるのかを代入
- 「targetIndex」の内容を表示

### 8. ArrayList インスタンスの要素の更新と削除

- list のインデックス 2 の要素を「UPDATE」に上書き
- list のインデックス 0 の要素を削除

### 9. ArrayList インスタンスのすべての要素を表示

- list のすべての要素を表示

### ArrayListManager の実行結果

```
list の要素が空かどうか => true
list の要素数 => 3
list の要素に 111 があるかどうか => true
list の 2 番目にある要素 => 222
list の要素「000」があるのは => 0 番目

list の 0 番目の要素 => 111
list の 1 番目の要素 => UPDATE
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/29.array-list/src/ArrayListManager.java
