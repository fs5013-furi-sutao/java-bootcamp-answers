## 学習

### JUnit とは

JUnit は、Java で作成したコードの単体テストを実施するツールです。

単体テストは何か、JUnit とは何かを Web で調べてください。
検索キーワードは、「 [junit](https://www.google.com/search?q=junit) 」
「 [単体テスト](https://www.google.com/search?q=単体テスト) 」です。
3 種類ぐらい説明記事やサンプルコードを読んで、Java におけるう委譲とは何か、単体テストは何か、JUnit とは何かをつかみましょう。

### VSCode で Junit を使えるようにする

では、VSCode で一番手っ取り早い方法で JUnit を使えるようにしてみます。

> 本来は、Gradle や Maven といったビルドツールを使いますが、
> ここではそうしたツールは使わず、簡易的に単体テストが実行できる環境を作ります

#### Console Launcher をダウンロードする

Console Launcher という JUnit 5 を VSCode で使いやすくできるものがあるので、このツールをダウンロードします。

ツールの入手先は、Maven のセントラルリポジトリです。

Maven のセントラルリポジトリ  
https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/

最新バージョンは安定していないので、1 つ前のバージョンを使うようにします。
今回は、以下のようなバージョンが揃っていたので、この中から `junit-platform-console-standalone-1.6.3.jar` をダウンロードしました。

```
1.0.0/                                            2017-09-10 18:11         -
1.0.0-M4/                                         2017-04-01 19:25         -
1.0.0-M5/                                         2017-07-04 16:40         -
1.0.0-M6/                                         2017-07-18 19:34         -
1.0.0-RC1/                                        2017-07-30 19:14         -
1.0.0-RC2/                                        2017-07-30 20:38         -
1.0.0-RC3/                                        2017-08-23 18:43         -
1.0.1/                                            2017-10-03 12:29         -
1.0.2/                                            2017-11-12 14:04         -
1.0.3/                                            2018-01-15 19:05         -
1.1.0/                                            2018-02-18 19:43         -
1.1.0-M1/                                         2017-11-19 15:56         -
1.1.0-M2/                                         2018-01-28 19:37         -
1.1.0-RC1/                                        2018-02-04 18:53         -
1.1.1/                                            2018-04-08 19:01         -
1.2.0/                                            2018-04-29 18:28         -
1.2.0-M1/                                         2018-04-15 17:34         -
1.2.0-RC1/                                        2018-04-22 19:18         -
1.3.0/                                            2018-09-03 19:23         -
1.3.0-M1/                                         2018-06-24 19:57         -
1.3.0-RC1/                                        2018-08-13 18:55         -
1.3.1/                                            2018-09-11 04:49         -
1.3.2/                                            2018-11-25 19:11         -
1.4.0/                                            2019-02-07 20:14         -
1.4.0-M1/                                         2018-12-23 18:24         -
1.4.0-RC1/                                        2019-01-24 19:43         -
1.4.0-RC2/                                        2019-01-31 19:31         -
1.4.1/                                            2019-03-17 19:11         -
1.4.2/                                            2019-04-07 17:30         -
1.5.0/                                            2019-06-30 19:48         -
1.5.0-M1/                                         2019-03-19 16:11         -
1.5.0-RC1/                                        2019-06-06 20:39         -
1.5.0-RC2/                                        2019-06-20 09:28         -
1.5.1/                                            2019-07-20 14:40         -
1.5.2/                                            2019-09-08 18:33         -
1.6.0/                                            2020-01-20 20:04         -
1.6.0-M1/                                         2019-10-21 19:10         -
1.6.0-RC1/                                        2020-01-06 15:59         -
1.6.1/                                            2020-03-22 18:58         -
1.6.2/                                            2020-04-10 14:19         -
1.6.3/                                            2020-10-26 20:40         -
1.7.0/                                            2020-09-13 13:15         -
1.7.0-M1/                                         2020-04-19 18:30         -
1.7.0-RC1/                                        2020-08-16 16:29         -
```

#### jar ファイルを配置する

ダウンロードしたライブラリファイル（jar ファイル）を以下の場所に、JUnit 用のフォルダを用意して配置します。
今回は、VScode のポータブル版を Scoop でインストールしていることを想定しています。

```
C:\Users\{ユーザ名}\scoop\apps\vscode-portable\current\data\junit
```

### setting.json に追記

次に VSCode がこのライブラリを認識できるように設定ファイルに追記をします。

追記対象のファイルは、VSCode の setting.json です。

setting.json を開くには次のショートカットでコマンドパレットを開きます。

```
Ctr + Shift + P
```

コマンドパレットが開いたら、「setting」とコマンドを入力すれば、次のコマンドがコマンド候補で出るのでこれを選択します。

```
Preferences: Open Settings(JSON)
```

これで setting.json ファイルがエディタで開くはずです。この中に次のオブジェクトを追記します。

```json
{
  "java.project.referencedLibraries": [
    "lib/**/*.jar",
    "C:\\\\Users\\\\{ユーザ名}\\\\scoop\\\\apps\\\\vscode-portable\\\\current\\\\data\\\\junit\\\\junit-platform-console-standalone-1.6.3.jar"
  ]
}
```

これで準備は完了です。

## テスト対象のコードを用意する

次にテスト対象とするコードを用意します。

### Higher.java

```java
public class Higher {

    public static void main(String[] args) {

        int a = 25;
        int b = -25;
        int higherNum = higher(a, b);

        System.out.printf(
               "より大きい数字は %d です. %n",
               higherNum
            );
    }

    public static int higher(int x, int y) {
        if (x > y) return x;
        return y;
    }
}
```

このプログラムを実行結果は以下の通りになります。

```console
より大きい数字は 25 です.
```

## テストメソッドの作成

次にテストメソッドを、Higher.java に追記します。

### テストメソッド testHigher() を追記後の Higher.java

```java
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Higher {

    public static void main(String[] args) {

        int a = 25;
        int b = -25;
        int higherNum = higher(a, b);

        System.out.printf(
               "より大きい数字は %d です. %n",
               higherNum
            );
    }

    public static int higher(int x, int y) {
        if (x > y) return x;
        return y;
    }

    @Test
    public void testHigher() {
        assertEquals(25, higher(23, 25));
        assertEquals(5, higher(3, 5));
    }
}
```

テストコード  
https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/05.advanced/10.junit-test/src/Higher.java

## テストの実行

このテストコードを実行してみます。

testHigher() メソッドの上部に `Run Test | Debug Test |` というテキストボタンが表示されるので、
`Run Test` をクリックします。

上記のテストコードは、テスト OK なので、テストが完了すると、テキストボタンの右サイドにチェックマーク「✔️」が付きます。

テストが NG だった場合は、「×」マークが付きます。

### Test Report の表示

チェックマーク「✔️」、もしくは「×」マークをクリックすると Test Report が表示されます。

![JUnit テストが OK だった場合](./junit_test_ok.png)

![JUnit テストが NG だった場合](./junit_test_ng.png)

テスト NG だった場合は Test Report で Failed となったメソッド名をクリックすると、エラーの詳細が表示されます。

上記のスタックとレースを見ると、「期待値は <3> だけど <5> だった」と AssertionError が出ています。

はじめの一歩としてのテスト方法は以上です。

JUnit 5 で調べて、テストの方法を色々調べてみてください。テスト自動化のスキルがアップするはずです。
