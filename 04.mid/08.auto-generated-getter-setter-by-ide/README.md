## 学習

### IDE にある Getter/Setter の自動生成機能

IDE の機能を利用すれば、Getter/Setter は自動生成できます。

### VSCode で Getter/Setter を自動生成する手順

どんな IDE にも、そうした機能は付いていますが、例えば、VSCode では次のような手順で実行できます。

#### 1. Java ファイルをエディタで開く

#### 2. 右クリックメニューから「Source Action...」を選択

#### 3. サブメニューから「Generate Getters and Setters...」を選択

#### 4. チェックボックスで生成対象のフィールドを選択

#### 5. 「OK」ボタンをクリック

以上の手順で Getter/Setter を自動生成できます。
次の画像は、上記の手順で Getter/Setter を作成する様子です。

![VSCode で Getter/Setter を自動生成](./generate_getter_and_setter.gif)

## 練習問題（時間: 20 分）

実行結果の通りになるように、次の Business クラスで利用するために、以下の 2 つのクラスを作成しなさい

また、この 2 つのクラスの Getter/Setter は、IDE の機能を使って自動生成しなさい

1. 従業員を表す Employee クラス
2. 部署を表す Division クラス

### Business.java

```Business
package mid.auto.ide;

public class Business {
    public static void main(String[] args) {

        Division division = new Division();
        division.setId(7);
        division.setName("ゲーム事業部");

        Employee employee = new Employee();
        employee.setId(777);
        employee.setName("山本一郎");
        employee.setAge(171);
        employee.setDivision(division);

        System.out.printf(
                "従業員ID:%d %s（%d 歳）さんは、部署ID:%d の %s 所属です. %n",
                employee.getId(),
                employee.getName(),
                employee.getAge(),
                employee.getDivision().getId(),
                employee.getDivision().getName()
            );
    }
}

```

### Business.java の実行結果

```console
従業員ID:777 山本一郎（171 歳）さんは、部署ID:7 の ゲーム事業部 所属です.
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/04.mid/08.auto-generated-getter-setter-by-ide/src/mid/auto/ide
