## 学習

### Java におけるラムダ式を知る

Java におけるラムダ式とは何かを Web で調べてください。
検索キーワードは、「 [java ラムダ式](https://www.google.com/search?q=java+ラムダ式) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、Java のラムダ式とは何か、ラムダ式の使い方をつかみましょう。

## 練習問題 1: 部品化（時間: 20 分）

加工対象の文字列と可変長引数の関数型インタフェースを渡すと文字列を加工して返す applyFunctions メソッドを
作成しなさい

そして、main メソッドに次の 2 つの変数を作り、
`山本一郎` とその 2 つの変数を applyFunctions に渡した結果を表示する、App クラスを作成しなさい

関数型インタフェースとラムダ式で次の処理の変数を作る:

1. 変数 pickOutFirstChar に、文字列の 1 ～ 2 番目までの文字を取得する処理を代入
2. 変数 duplicateWord に、文字列を複製してつなげる処理を代入

### App.java の実行結果

```console
山本山本
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/06.master/08.lambda-expression/src/master/lambda/expression/modularization
