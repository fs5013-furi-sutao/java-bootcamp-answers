public class DebuggingTest {
    public static void main(String[] args) {

        String concatenate = "";
        int sum = 0;

        for (int i = 1; i < 10; i++) {
            concatenate = concatenate(concatenate, i);
            sum += i;
            print(concatenate, sum);
        }
        System.out.println("End.");
    }

    private static String concatenate(
            String concatenate, int i) {
        return concatenate + String.valueOf(i);
    }

    private static void print(String concatenate, int sum) {
        System.out.println(concatenate);
        System.out.println(sum);
        System.out.println("-----");
    }
}
