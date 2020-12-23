import java.util.Scanner;

public class LargestOfThreeNumbersFinder {

    public static void main(String[] args) {

        try (Scanner stdin = new Scanner(System.in)) {

            /* int first;
            int second;
            int third; */
            int[] numbers = new int[3];

            for (int i = 0; i < numbers.length; i++) {

                System.out.printf(
                    "%d 番目の数字を入力してください: ", i + 1
                );
                numbers[i] = stdin.nextInt();

                // System.out.print("1 番目の数字を入力してください:");
                // first = stdin.nextInt();

                // System.out.print("2 番目の数字を入力してください:");
                // second = stdin.nextInt();

                // System.out.print("3 番目の数字を入力してください:");
                // third = stdin.nextInt();
            }

            /* for (int num : numbers) {
                System.out.println(num);
            } */

            // int[] numbers = { first, second, third };

            if (isLargest1stNum(numbers)) {
                System.out.println("numbers[0]=" + numbers[0]);
                // if (isLargest1stNum(first, second, third)) {
                // if (first >= second && first >= third) {
                System.out.printf("1番目に入力した数字が一番大きい");
            } else if (isLargest2ndNum(numbers)) {
                // } else if (num2 >= num1 && num2 >= num3) {
                System.out.printf("2番目に入力した数字が一番大きい");
            } else {
                System.out.printf("3番目に入力した数字が一番大きい");
                // System.out.println(third + " is the largest Number");
            }
        }
    }

    private static boolean isLargest1stNum(int[] numbers) {
        return numbers[0] >= numbers[1] && numbers[0] >= numbers[2];
    }

    // private static boolean isLargest1stNum(
    //         int first, int second, int third) {
    //     return first >= second && first >= third;
    // }

    private static boolean isLargest2ndNum(int[] numbers) {
        return numbers[1] >= numbers[0] && numbers[1] >= numbers[2];
    }
}