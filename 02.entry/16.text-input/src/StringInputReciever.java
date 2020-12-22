import java.util.Scanner;

public class StringInputReciever {
    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        System.out.print("文字列を入力してください: ");

        String name = stdin.nextLine();
        System.out.printf("入力された名前は %s です.", name);
        stdin.close();
    }
}
