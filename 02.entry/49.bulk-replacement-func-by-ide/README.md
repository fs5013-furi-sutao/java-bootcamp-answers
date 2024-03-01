** この記事では、OS を Windows 10 で、IDE は VSCode を想定しています **

## コード中の名前を変更する 2 種類の方法

VSCode では、コード中のクラス名、メソッド名、変数名などを変更するのに、2 種類の方法があります。

1 つが `Rename Symbol` で、もう 1 つが `Replace in Files` です。

## Rename Symbol

コード中の名前を変更したい時、対象の箇所で F2 を押すと、`Rename Symbol` を行うことができます。

```txt title=コード中の名前を変更するショートカットキー
F2 キー
```

F2 キーを押すと、名前の入力窓が出現するので、ここに変更後の名前を入力します。

また、ショートカットキーを使わない場合は、右クリックのメニューから「Rename Symbol」を選択することで実行できます。

Rename Symbol は、依存関係にある名前の整合性をすべて解決した上で、名前を変更してくれるので、名前の変更によるミスが起こらず便利です。

![Rename Symbol でコード中の名前を変更する](./images/rename_symbol_in_vscode.gif)

## Replace in Files

プロジェクト中のコードに存在する名前を一括で置き換えたい場合は、IDE の一括置換機能を使います。

VSCode では、次のショートカットキーで実行できます。

```txt title=コード中の名前を一括置き換えするショートカットキー
Ctr + Shift + H キー
```

Replace in Files を実行すると、左ペインに入力窓が 2 つ表示されます。

上部の窓に「検索ワード」、下部の窓に「置き換え後のワード」を入れ、次のショートカットを実行すると一括置き換えが実行されます。

```txt title=すべて一括置き換えを実行するショートカットキー（ReplaceAll）
Ctr + Alt + Enter キー
```

ただし、こちらは、プログラム的な整合性を考えてファイル名の置き換えをするなどの操作は行われません。

そのため、クラス名変更や同一メソッド名が存在する場合などの、整合性を考える必要のあるリファクタリングは、Rename Symbol の機能を使うべきです。

![Ctr キーを押した状態でメソッドをクリックして、メソッド参照先を表示する](./images/replace_in_files_in_vscode.gif)

## ミニ課題（時間: 20 分）

以下のソースコードを使って、Rename Symbol と Replace in Files、2 種類の名前一括置き換え機能の動作確認を行いなさい

### 動作確認用ソースコード

#### RenameVerification.java

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/48.bulk-replacement-func-by-ide/src/RenameVerification.java

#### RenameFoo.java

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/48.bulk-replacement-func-by-ide/src/RenameFoo.java
