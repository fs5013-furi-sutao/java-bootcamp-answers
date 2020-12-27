## ミニ課題（時間: 20 分）

main メソッドに以下の 3 つの処理を記述して、プログラム実行結果が以下に示したようになるように MultiDemendionalArray クラスを作成しなさい。

### 1. 定数宣言:

- 定数「HORIZONTAL_INDEX」（水平方向のインデックス）を宣言し、「2」を代入する
- 定数「VERTICAL_INDEX」（垂直方向のインデックス）を宣言し、「1」を代入する

### 2. int 配列の初期化と表示処理:

- int 配列「dimArray」に以下の表の内容になるように要素を代入して宣言

<table style="width: 10em; border-spacing: 4px 4px;">
  <tr style="border: none; background: none;">
    <td colspan="2" style="border: none; background: none;"> </td>
    <td colspan="4" style="border: none; background: none;">X 方向 →</td>
  </tr>

  <tr style="border: none; background: none;">
    <td colspan="2" style="border: none; background: none;"> </td>
    <td style="border: none; background: none;">0</td>
    <td style="border: none; background: none;">1</td>
    <td style="border: none; background: none;">2</td>
    <td style="border: none; background: none;">3</td>
  </tr>

  <tr style="border: none; background: none;">
    <td rowspan="3" style="vertical-align: top; border: none; background: none;">Y 方向 ↓</td>
    <td style="border: none; background: none;">0</td>
    <td style="font-weight: bold;">&nbsp;1</td>
    <td style="font-weight: bold;">&nbsp;2</td>
    <td style="font-weight: bold;">&nbsp;3</td>
    <td style="font-weight: bold;">&nbsp;4</td>
  </tr>

  <tr style="border: none; background: none;">
    <td style="border: none; background: none;">1</td>
    <td style="font-weight: bold; ">&nbsp;5</td>
    <td style="font-weight: bold; ">&nbsp;6</td>
    <td style="font-weight: bold; color: #ff0000; background-color: pink;">&nbsp;7</td>
    <td style="font-weight: bold; ">&nbsp;8</td>
  </tr>

  <tr style="border: none; background: none;">
    <td style="border: none; background: none;">2</td>
    <td style="font-weight: bold; ">&nbsp;9</td>
    <td style="font-weight: bold; ">10</td>
    <td style="font-weight: bold; ">11</td>
    <td style="font-weight: bold; ">12</td>
  </tr>
</table>

### 3. 多次元配列の指定要素の表示処理:

- 「dimArray」の横に「HORIZONTAL_INDEX」番目、縦に「VERTICAL_INDEX」番目の要素を表示

### MultiDemendionalArray の実行結果

```
水平方向(X)に 2, 垂直方向(Y)に 1 のインデックスにある値 => 7
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/28.multidimendional-array/src/MultiDemendionalArray.java
