public class OverflowVerification {
    public static void main(String[] args) {

        int maxInt = Integer.MAX_VALUE;
        System.out.printf("int 型の最大値 = %s%n", maxInt);

        maxInt += 1;
        System.out.printf("int 型の最大値 + 1 = %s%n", maxInt);
    }
}
