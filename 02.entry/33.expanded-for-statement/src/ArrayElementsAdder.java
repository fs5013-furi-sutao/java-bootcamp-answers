public class ArrayElementsAdder {
    public static void main(String[] args) {

        int[] numbers = {
            3, 4, 5, -5, 0, 12,
        };

        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        System.out.printf(
            "配列 numbers の %d 個の要素の合計 => %d %n"
            , numbers.length, sum
        );
    }
}
