** この記事では、OS を Windows 10 で、IDE は VSCode を想定しています **

## メソッド参照先を表示する

プロジェクトの中から、対象のメソッドを参照している箇所を表示させるには、以下の操作を行います。

```txt title=メソッド参照先表示
Ctr キーを押した状態でメソッドをクリックする
```

対象のメソッドを呼び出している箇所が複数あれば、その呼び出し箇所すべてが表示されます。

### ショートカットキーで参照先を表示

メソッドの呼び出し箇所の表示はショートカットキーでも実行することができます。

```txt title=ショートカットキーでメソッド参照先表示
Shift + F12
```

## メソッド参照先へジャンプする

表示されたメソッド呼び出し箇所をダブルクリックすると、その呼び出し箇所にジャンプします。

## ショートカットでメソッド呼び出し箇所に戻る

メソッド定義箇所に戻るには、以下のショートカットキーを使います。

```txt title=メソッド呼び出し箇所に戻る
Alt + ← キー
```

## メソッド参照先表示、ジャンプ、戻る

次の画像は、メソッド参照先を表示させ、複数の参照先から 1 つを選んでジャンプ、元の処理に戻る・・・という一連の様子です。

![Ctr キーを押した状態でメソッドをクリックして、メソッド参照先を表示する](./images/go_to_method_refs_in_vscode.gif)

## ミニ課題（時間: 20 分）

以下のソースコードを使って、メソッド参照先を表示させる、複数の参照先から 1 つを選んでジャンプ、元の処理に戻る・・・の動作確認を行いなさい

### 動作確認用ソースコード

#### GoToRefChecker.java

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/47.go-to-reference-by-ide/src/GoToRefChecker.java

#### DogList.java

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/47.go-to-reference-by-ide/src/DogList.java
