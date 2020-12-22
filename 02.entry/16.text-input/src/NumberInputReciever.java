import java.util.Scanner;

public class NumberInputReciever {
    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        System.out.print("数字を入力してください: ");

        int number = stdin.nextInt();
        System.out.printf("入力された数字は %d です.", number);
        stdin.close();
    }
}
