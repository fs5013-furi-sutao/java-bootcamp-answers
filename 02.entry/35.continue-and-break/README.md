## ミニ課題 01: 偶数のみを合算（時間: 20 分）

1 ～ 10 までの数について、偶数のみを合計する処理を main メソッドに持つ EvenNumbersAdder を作成しなさい

### EvenNumbersAdder の実行結果

```
i= 2
i= 4
i= 6
i= 8
i=10

sum=30
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/35.continue-and-break/src/EvenNumbersAdder.java

## ミニ課題 02: 3 の列と 7 の段を除外する（時間: 20 分）

3 の列と 7 の段のみ「 @@@@@@@ 」で塗りつぶした九九表を表示する処理を main メソッドに持つ LabeledContinueStatement を作成しなさい

### LabeledContinueStatement の実行結果

```
 1X 1= 1  1X 2= 2  @@@@@@@  1X 4= 4  1X 5= 5  1X 6= 6  1X 7= 7  1X 8= 8  1X 9= 9
 2X 1= 2  2X 2= 4  @@@@@@@  2X 4= 8  2X 5=10  2X 6=12  2X 7=14  2X 8=16  2X 9=18
 3X 1= 3  3X 2= 6  @@@@@@@  3X 4=12  3X 5=15  3X 6=18  3X 7=21  3X 8=24  3X 9=27
 4X 1= 4  4X 2= 8  @@@@@@@  4X 4=16  4X 5=20  4X 6=24  4X 7=28  4X 8=32  4X 9=36
 5X 1= 5  5X 2=10  @@@@@@@  5X 4=20  5X 5=25  5X 6=30  5X 7=35  5X 8=40  5X 9=45
 6X 1= 6  6X 2=12  @@@@@@@  6X 4=24  6X 5=30  6X 6=36  6X 7=42  6X 8=48  6X 9=54
 @@@@@@@  @@@@@@@  @@@@@@@  @@@@@@@  @@@@@@@  @@@@@@@  @@@@@@@  @@@@@@@  @@@@@@@
 8X 1= 8  8X 2=16  @@@@@@@  8X 4=32  8X 5=40  8X 6=48  8X 7=56  8X 8=64  8X 9=72
 9X 1= 9  9X 2=18  @@@@@@@  9X 4=36  9X 5=45  9X 6=54  9X 7=63  9X 8=72  9X 9=81
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/35.continue-and-break/src/LabeledContinueStatement.java

## ミニ課題 03: 20 より大きくなる九九を表示させない（時間: 20 分）

掛け算の結果が 20 より大きい結果となる九九を表示させない九九表を表示する処理を main メソッドに持つ BreakNest を作成しなさい

### BreakNest の実行結果

```
 1X 1= 1  1X 2= 2  1X 3= 3  1X 4= 4  1X 5= 5  1X 6= 6  1X 7= 7  1X 8= 8  1X 9= 9
 2X 1= 2  2X 2= 4  2X 3= 6  2X 4= 8  2X 5=10  2X 6=12  2X 7=14  2X 8=16  2X 9=18
 3X 1= 3  3X 2= 6  3X 3= 9  3X 4=12  3X 5=15  3X 6=18
 4X 1= 4  4X 2= 8  4X 3=12  4X 4=16  4X 5=20
 5X 1= 5  5X 2=10  5X 3=15  5X 4=20
 6X 1= 6  6X 2=12  6X 3=18
 7X 1= 7  7X 2=14
 8X 1= 8  8X 2=16
 9X 1= 9  9X 2=18
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/35.continue-and-break/src/BreakNest.java

## ミニ課題 04: 20 より大きくなる九九になったら表示をストップする（時間: 20 分）

掛け算の結果が 20 より大きい結果となった時点で以降の九九表の表示をストップする処理を main メソッドに持つ LabeledBreakNest を作成しなさい

### LabeledBreakNest の実行結果

```
 1X 1= 1  1X 2= 2  1X 3= 3  1X 4= 4  1X 5= 5  1X 6= 6  1X 7= 7  1X 8= 8  1X 9= 9
 2X 1= 2  2X 2= 4  2X 3= 6  2X 4= 8  2X 5=10  2X 6=12  2X 7=14  2X 8=16  2X 9=18
 3X 1= 3  3X 2= 6  3X 3= 9  3X 4=12  3X 5=15  3X 6=18
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/02.entry/35.continue-and-break/src/LabeledBreakNest.java
