public class EvenNumbersAdder {

    public static void main(String[] args) {

        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0) {
                continue;
            }
            System.out.printf("i=%2d %n", i);
            sum += i;
        }

        System.out.println();
        System.out.printf("sum=%d %n", sum);
    }
}